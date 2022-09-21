package com.diplo.sharedkernel.amqp;

import org.springframework.context.ApplicationEvent;

import com.diplo.sharedkernel.event.IntegrationEvent;

public interface IAmqpMessage {
	
	Object getMessage();

}
