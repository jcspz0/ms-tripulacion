package com.diplo.mstripulacion.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.diplo.mstripulacion.amqp.RabbitMQtripulacionCreadaSender;
import com.diplo.mstripulacion.dto.TripulacionDTO;
import com.diplo.mstripulacion.entityframework.entity.TripulacionEntity;
import com.diplo.mstripulacion.entityframework.entity.repository.TripulacionEntityRepository;
import com.diplo.sharedkernel.amqp.AmqpMessage;
import com.diplo.sharedkernel.integrationevents.IntegrationTripulacionCreada;

@RestController
@RequestMapping(path="/tripulacion")
@CrossOrigin(origins= "*")
public class TripulacionController {
	
	@Autowired
	private TripulacionEntityRepository reposiroty;
	
	@Autowired
	private RabbitMQtripulacionCreadaSender sender;
	
	@Value("tripulacion.tripulacioncreada.vuelo.guardartripulacion")
	private String tripulacionCreadaRoutingkey;
	
	@Value("tripulacion.tripulacioncreada.exchange")
	private String tripulacionCreadaExchange;
	
	@RequestMapping(value = "/crear", method = RequestMethod.POST)
	public TripulacionDTO CrearTripulacion(@RequestBody TripulacionDTO tripulacionDTO) {
		try {
			TripulacionDTO tripulacion = new TripulacionDTO(tripulacionDTO.getTipo(), tripulacionDTO.getNroDoc(), tripulacionDTO.getTipoDoc(), tripulacionDTO.getNombre(), tripulacionDTO.getApellido());
			reposiroty.save(new TripulacionEntity(tripulacion));
			AmqpMessage message = new AmqpMessage(new IntegrationTripulacionCreada(tripulacion.getTripulacionId(), tripulacion.getNombre()+" "+tripulacion.getApellido(), tripulacion.getNroDoc()));
			sender.sendMessage(message, tripulacionCreadaExchange, tripulacionCreadaRoutingkey);
			return tripulacion;
		} catch (Exception e) {
			System.out.println("Excepcion "+e);	
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ocurrio un error");
		}
	}

}
