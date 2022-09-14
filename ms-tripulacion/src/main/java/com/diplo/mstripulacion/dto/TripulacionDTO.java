package com.diplo.mstripulacion.dto;

import java.util.UUID;

public class TripulacionDTO {

	private String tripulacionId;
	private int nroDoc;
	private int tipoDoc;
	private String nombre;
	private String apellido;
	private int millas;
	private int horasVuelo;
	private int tipo;
	
	
	
	public TripulacionDTO() {
		super();
	}

	public TripulacionDTO(String tripulacionId, int tipo, int nroDoc, int tipoDoc, String nombre, String apellido, int millas, int horasVuelo) {
		super();
		this.tripulacionId = tripulacionId;
		this.nroDoc = nroDoc;
		this.tipoDoc = tipoDoc;
		this.nombre = nombre;
		this.apellido = apellido;
		this.millas = millas;
		this.horasVuelo = horasVuelo;
		this.tipo = tipo;
	}
	
	public TripulacionDTO(int tipo, int nroDoc, int tipoDoc, String nombre, String apellido) {
		super();
		this.tripulacionId = UUID.randomUUID().toString();
		this.nroDoc = nroDoc;
		this.tipoDoc = tipoDoc;
		this.nombre = nombre;
		this.apellido = apellido;
		this.millas = 0;
		this.horasVuelo = 0;
		this.tipo = tipo;
	}

	public int getNroDoc() {
		return nroDoc;
	}

	public void setNroDoc(int nroDoc) {
		this.nroDoc = nroDoc;
	}

	public int getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(int tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getMillas() {
		return millas;
	}

	public void setMillas(int millas) {
		this.millas = millas;
	}

	public int getHorasVuelo() {
		return horasVuelo;
	}

	public void setHorasVuelo(int horasVuelo) {
		this.horasVuelo = horasVuelo;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getTripulacionId() {
		return tripulacionId;
	}

	public void setTripulacionId(String tripulacionId) {
		this.tripulacionId = tripulacionId;
	}
	
	
}
