package com.springdata.specification;

import java.time.LocalDate;

import org.springframework.data.jpa.domain.Specification;

import com.springdata.orm.Funcionario;

public class SpecificationFuncionario {
	
	public static Specification<Funcionario> nome(String nome){
		return (root,criteriaQuery,criteriaBuilder)->
		criteriaBuilder.like(root.get("nome"), "%"+ nome+"%");
	}
	
	public static Specification<Funcionario> cpf(String cpf){
		return (root,criteriaQuery,criteriaBuilder)->
		criteriaBuilder.like(root.get("cpf"), "%"+ cpf+"%");
	}
	
	public static Specification<Funcionario> salario(Double salario){
		return (root,criteriaQuery,criteriaBuilder)->
		criteriaBuilder.greaterThan(root.get("salario"), salario);
	}

	public static Specification<Funcionario> cpf(LocalDate dataContratacao){
		return (root,criteriaQuery,criteriaBuilder)->
		criteriaBuilder.greaterThan(root.get("dataContratacao"),dataContratacao); 
	}

}
