package com.diplo.sharedkernel.integrationevents;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import com.diplo.sharedkernel.event.IntegrationEvent;

//public class IntegrationReservaCreada extends IntegrationEvent  {
public class IntegrationReservaConfirmadaRollback {

	/**
	 * 
	 */
	private  String reservaId;
	private  String pagoId;

	public IntegrationReservaConfirmadaRollback() {
		super();
	}


	public IntegrationReservaConfirmadaRollback(String reservaId, String pagoId) {
		//super("ReservaCreada",LocalDateTime.now().toString());
		this.reservaId = reservaId;
		this.pagoId = pagoId;
	}


	public String getReservaId() {
		return reservaId;
	}


	public String getPagoId() {
		return pagoId;
	}

	

}
