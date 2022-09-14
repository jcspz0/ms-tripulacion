package com.diplo.mstripulacion.amqp;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
	
	@Value("tripulacion.tripulacioncreada.vuelo.guardartripulacion")
	private String tripulacionCreadaRoutingkey;

	@Bean
	Queue tripulacionCreadaToVuelo() {
		return new Queue("tripulacion.tripulacioncreada.vuelo.guardartripulacion", false);
	}
	
	@Bean
	TopicExchange tripulacionCreadaExchange() {
		return new TopicExchange("tripulacion.tripulacioncreada.exchange");
	}
	
	@Bean
	Binding tripulacionCreadaBinding(Queue tripulacionCreadaToVuelo, TopicExchange tripulacionCreadaExchange) {
		return BindingBuilder.bind(tripulacionCreadaToVuelo).to(tripulacionCreadaExchange).with(tripulacionCreadaRoutingkey);
	}
	
	@Bean
	public MessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}
	
	@Bean
    public Jackson2JsonMessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }
	
	@Bean
	public AmqpTemplate myRabbitTemplate(ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(jsonMessageConverter());
		return rabbitTemplate;
	}
	
}
