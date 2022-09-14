package com.diplo.mstripulacion.entityframework.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.diplo.mstripulacion.dto.TripulacionDTO;

@Entity
@Table(name = "tripulacion")
public class TripulacionEntity {
	
	@Id
	private String TripulacionId;
	private int nroDoc;
	private int tipoDoc;
	private String nombre;
	private String apellido;
	private int millas;
	private int horasVuelo;
	private int tipo;
	
	public TripulacionEntity() {}

	public String getTripulacionId() {
		return TripulacionId;
	}

	public void setTripulacionId(String tripulacionId) {
		TripulacionId = tripulacionId;
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
	
	public TripulacionEntity(TripulacionDTO tripulacionDTO) {
		this.TripulacionId= tripulacionDTO.getTripulacionId();
		this.nroDoc = tripulacionDTO.getNroDoc();
		this.tipoDoc = tripulacionDTO.getTipoDoc();
		this.nombre = tripulacionDTO.getNombre();
		this.apellido = tripulacionDTO.getApellido();
		this.millas = tripulacionDTO.getMillas();
		this.horasVuelo = tripulacionDTO.getHorasVuelo();
		this.tipo = tripulacionDTO.getTipo();
	}
	
}
