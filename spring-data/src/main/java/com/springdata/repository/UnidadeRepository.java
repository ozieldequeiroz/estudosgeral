package com.springdata.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springdata.orm.Unidade;

@Repository
public interface UnidadeRepository extends CrudRepository<Unidade, Integer> {

}
