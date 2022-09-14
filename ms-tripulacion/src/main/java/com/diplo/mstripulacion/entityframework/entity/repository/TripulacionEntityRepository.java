package com.diplo.mstripulacion.entityframework.entity.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.diplo.mstripulacion.entityframework.entity.TripulacionEntity;

@Repository
public interface TripulacionEntityRepository extends CrudRepository<TripulacionEntity, String> {

}
