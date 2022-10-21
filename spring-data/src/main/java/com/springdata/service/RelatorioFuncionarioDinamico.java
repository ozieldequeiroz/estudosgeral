package com.springdata.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.data.jpa.domain.Specification;

import com.springdata.orm.Funcionario;
import com.springdata.repository.FuncionarioRepository;
import com.springdata.specification.SpecificationFuncionario;

public class RelatorioFuncionarioDinamico {
	
	private final FuncionarioRepository funcionarioRepository;
	private final DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public RelatorioFuncionarioDinamico(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	public void inicial(Scanner scanner) {
		System.out.println("Digite o nome");
		String nome = scanner.next();
		
		if(nome.contentEquals("NULL")) {
			nome = null;
		}
		
		System.out.println("Digite o CPF");
		String cpf = scanner.next();
		
		if(cpf.equalsIgnoreCase("NULL")) {
			cpf = null;
		}
		
		System.out.println("Digite o salario ");
		Double salario = scanner.nextDouble();
		
		if(salario == 0) {
			cpf = null;
		}
		
		System.out.println("Digite a data de contratacao");
		String data = scanner.next();
		
		LocalDate dataContratacao;
		if(data.equalsIgnoreCase("NULL")) {
			dataContratacao = null;
		} else {
			dataContratacao = LocalDate.parse(data,format);
		}
		
		List<Funcionario> funcionario = funcionarioRepository
				.findAll(Specification.where(
						SpecificationFuncionario.nome(nome))
						.or(SpecificationFuncionario.cpf(cpf))
						.or(SpecificationFuncionario.salario(salario))
						.or(SpecificationFuncionario.salario(salario))
						);
		funcionario.forEach(System.out::println);
	}

}
