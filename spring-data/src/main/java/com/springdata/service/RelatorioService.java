package com.springdata.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.springdata.orm.Funcionario;
import com.springdata.repository.FuncionarioRepository;

@Service
public class RelatorioService {
	
	Scanner scanner = new Scanner(System.in);
	private Boolean system = true;
	
	private FuncionarioRepository funcionarioRepository;
	
	public RelatorioService( FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository=funcionarioRepository;
	}
	
	public void iniciar(Scanner scanner){
		while (system) {
			System.out.println("Qual ação de cargo quer executar");
			System.out.println("Digite - 0 : para sair");
			System.out.println("Digite - 1 : Relatorio por nome");
			int action = scanner.nextInt();
			
			switch (action) {
			case 0:
				system = false;
				break;
			case 1:
			//	salvar(scanner);
				break;
			case 2:
			//	atualizar(scanner);
				break;
			case 3:
			//	visualizar();
				break;
			case 4:
			//	deletar(scanner);
				break;
			default:
				system = false; 
				break;
			}
		}
	}
	
	private void relatorioNome(Scanner scanner) {
		System.out.println("Digite o nome para pesquisa; ");
		String nome = scanner.next();
		List<Funcionario> funcionario = funcionarioRepository.findByNome(nome);
		funcionario.forEach(System.out::println);
	}


}
