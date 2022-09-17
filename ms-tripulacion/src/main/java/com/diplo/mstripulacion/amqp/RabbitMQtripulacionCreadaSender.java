package com.diplo.mstripulacion.amqp;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.diplo.sharedkernel.amqp.IAmqpMessage;
import com.diplo.sharedkernel.amqp.IAmqpProducer;
import com.diplo.sharedkernel.integrationevents.IntegrationReservaCreada;
import com.diplo.sharedkernel.integrationevents.IntegrationTripulacionCreada;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class RabbitMQtripulacionCreadaSender implements IAmqpProducer<IntegrationTripulacionCreada>{

	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	ObjectMapper mapper = new ObjectMapper();  
	
	@Value("tripulacion.tripulacioncreada.vuelo.guardartripulacion")
	private String tripulacionCreadaRoutingkey;
	
	@Value("tripulacion.tripulacioncreada.exchange")
	private String tripulacionCreadaExchange;
	
	@Override
	public void sendMessage(IAmqpMessage message, String exchange, String queue, String routingkey) {
		//rabbitTemplate.convertAndSend(this.exchange, "", message.getMessage());
		try {
			rabbitTemplate.convertAndSend(exchange, routingkey,mapper.writeValueAsString((IntegrationTripulacionCreada) message.getMessage()));
			System.out.println("Send msg = " + mapper.writeValueAsString((IntegrationTripulacionCreada) message.getMessage()));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AmqpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

	
}
