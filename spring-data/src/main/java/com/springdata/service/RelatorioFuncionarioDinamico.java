package com.springdata.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.data.jpa.domain.Specification;

import com.springdata.orm.Funcionario;
import com.springdata.repository.FuncionarioRepository;
import com.springdata.specification.SpecificationFuncionario;

public class RelatorioFuncionarioDinamico {
	
	private final FuncionarioRepository funcionarioRepository;

	public RelatorioFuncionarioDinamico(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	public void inicial(Scanner scanner) {
		System.out.println("Digite o nome");
		String nome = scanner.next();
		List<Funcionario> funcionario = funcionarioRepository
				.findAll(Specification.where(SpecificationFuncionario.nome(nome)));
	}

}
