package com.diplo.sharedkernel.integrationevents;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import com.diplo.sharedkernel.event.IntegrationEvent;

//public class IntegrationReservaCreada extends IntegrationEvent  {
public class IntegrationCheckinCreado {

	/**
	 * 
	 */
	
	private String reservaId;

	public IntegrationCheckinCreado(String reservaId) {
		//super("ReservaCreada",LocalDateTime.now().toString());
		this.reservaId = reservaId;
		
	}
	
	

	public IntegrationCheckinCreado() {
		super();
	}



	public String getReservaId() {
		return reservaId;
	}

}
