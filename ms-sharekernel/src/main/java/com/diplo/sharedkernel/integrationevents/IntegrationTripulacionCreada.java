package com.diplo.sharedkernel.integrationevents;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import com.diplo.sharedkernel.event.IntegrationEvent;

//public class IntegrationReservaCreada extends IntegrationEvent  {
public class IntegrationTripulacionCreada implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String tripulacionId;
	private final String nombre;
	private final int nroDoc;
	
	public IntegrationTripulacionCreada(String tripulacionId, String nombre, int nroDoc) {
		super();
		this.tripulacionId = tripulacionId;
		this.nombre = nombre;
		this.nroDoc = nroDoc;
	}

	public String getTripulacionId() {
		return tripulacionId;
	}

	public String getNombre() {
		return nombre;
	}

	public int getNroDoc() {
		return nroDoc;
	}

}
