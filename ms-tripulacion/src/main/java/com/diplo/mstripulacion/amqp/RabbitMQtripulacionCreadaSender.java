package com.diplo.mstripulacion.amqp;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.diplo.sharedkernel.amqp.IAmqpMessage;

@Service
public class RabbitMQtripulacionCreadaSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	@Value("tripulacion.tripulacioncreada.vuelo.guardartripulacion")
	private String tripulacionCreadaRoutingkey;
	
	@Value("tripulacion.tripulacioncreada.exchange")
	private String tripulacionCreadaExchange;
	
	public void sendMessage(IAmqpMessage message, String exchange, String routingkey) {
		//rabbitTemplate.convertAndSend(this.exchange, "", message.getMessage());
		rabbitTemplate.convertAndSend(exchange, routingkey, message.getMessage());
		System.out.println("Send msg = " + message.getMessage());
	}
	
}
