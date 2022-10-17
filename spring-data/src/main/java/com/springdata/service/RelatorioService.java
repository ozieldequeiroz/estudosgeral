package com.springdata.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.springdata.orm.Funcionario;
import com.springdata.orm.FuncionarioProjecao;
import com.springdata.repository.FuncionarioRepository;

@Service
public class RelatorioService {
	
	Scanner scanner = new Scanner(System.in);
	private Boolean system = true;
	private DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private FuncionarioRepository funcionarioRepository;
	
	public RelatorioService( FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository=funcionarioRepository;
	}
	
	public void iniciar(Scanner scanner){
		while (system) {
			System.out.println("Qual ação de cargo quer executar");
			System.out.println("Digite - 0 : para sair");
			System.out.println("Digite - 1 : Relatorio por nome");
			System.out.println("Digite - 2 : Relatorio por data contratacao");
			System.out.println("Digite - 3 : Relatorio por projecao");
			int action = scanner.nextInt();
			
			switch (action) {
			case 0:
				system = false;
				break;
			case 1:
				relatorioNome(scanner);
				break;
			case 2:
				relatorioNomeDataContratacaoSalario(scanner);
				break;
			case 3:
				funcionaSalario();
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
	
	private void relatorioNomeDataContratacaoSalario(Scanner scanner) {
		System.out.println("Digite o nome ; ");
		String nome = scanner.next();
		System.out.println("Digite o salario ; ");
		Double salario= scanner.nextDouble();
		System.out.println("Digite a data de contratacao ; ");
		String data= scanner.next();
		List<Funcionario> funcionario = funcionarioRepository.findNomeDataContratacaoSalarioMaior(nome, salario, LocalDate.parse(data,format));
		funcionario.forEach(System.out::println);
	}
	
	private void funcionaSalario() {
		List<FuncionarioProjecao> list = funcionarioRepository.findSalarioMaior();
		list.forEach(f->System.out.println("Funcionario " + " | Id "+ 
					f.getId()+ " Nome "+ f.getNome() +" | Salario "+f.getSalario()));
	}


}
