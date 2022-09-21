package com.diplo.sharedkernel.integrationevents;

import java.time.LocalDateTime;
import java.util.UUID;

import com.diplo.sharedkernel.event.IntegrationEvent;

public class IntegrationDeudaCreada {

	private UUID deudaId;
	private String estado;
	private UUID reservaId;
	private double Total;

	
	
	public IntegrationDeudaCreada() {
		super();
	}

	public IntegrationDeudaCreada(UUID deudaId, UUID reservaId, double total, String estado) {
		//super("DeudaCreada",LocalDateTime.now().toString());
		this.deudaId = deudaId;
		this.reservaId = reservaId;
		Total = total;
		this.estado = estado;
	}


	public UUID getDeudaId() {
		return deudaId;
	}

	public String getEstado() {
		return estado;
	}

	public UUID getReservaId() {
		return reservaId;
	}

	public double getTotal() {
		return Total;
	}


}
