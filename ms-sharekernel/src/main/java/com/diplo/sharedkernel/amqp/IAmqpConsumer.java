package com.diplo.sharedkernel.amqp;

import org.springframework.context.ApplicationEvent;

import com.diplo.sharedkernel.event.IntegrationEvent;
import com.diplo.sharedkernel.event.IntegrationMessage;

//public interface IAmqpConsumer <T extends IntegrationEvent> {
public interface IAmqpConsumer <T> {

	void Consume(T message);
	
}
