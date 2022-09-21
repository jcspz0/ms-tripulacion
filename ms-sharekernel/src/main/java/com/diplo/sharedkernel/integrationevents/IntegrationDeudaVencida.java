package com.diplo.sharedkernel.integrationevents;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import com.diplo.sharedkernel.event.IntegrationEvent;

//public class IntegrationReservaCreada extends IntegrationEvent  {
public class IntegrationDeudaVencida   {

	/**
	 * 
	 */
	
	private String reservaId;

	public IntegrationDeudaVencida() {
		super();
	}

	public IntegrationDeudaVencida(String reservaId) {
		//super("ReservaCreada",LocalDateTime.now().toString());
		this.reservaId = reservaId;
	}

	public String getReservaId() {
		return reservaId;
	}

	

}
