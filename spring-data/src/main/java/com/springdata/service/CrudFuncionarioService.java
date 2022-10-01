package com.springdata.service;

import java.time.LocalDateTime;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.springdata.orm.Cargo;
import com.springdata.orm.Funcionario;
import com.springdata.repository.FuncionarioRepository;

@Service
public class CrudFuncionarioService {
	
	private Funcionario fucionario = new Funcionario();
	Scanner scanner = new Scanner(System.in);
	private Boolean system = true;
	
	private FuncionarioRepository funcionarioRepository;
		
	public CrudFuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository=funcionarioRepository;
	}
	
	public void iniciar(Scanner scanner){
		while (system) {
			System.out.println("Qual ação de cargo quer executar");
			System.out.println("Digite - 0 : para sair");
			System.out.println("Digite - 1 : Adicionar um Funcionario");
			System.out.println("Digite - 2 : Atualizar um Funcionario");
			System.out.println("Digite - 3 : Visualizar os Funcionario");
			System.out.println("Digite - 4 : Deletar um Funcionario");
			int action = scanner.nextInt();
			
			switch (action) {
			case 1:
				salvar(scanner);
				break;
			case 2:
				atualizar(scanner);
				break;
			case 3:
				visualizar();
				break;
			case 4:
				deletar(scanner);
				break;
			default:
				system = false; 
				break;
			}
			
		}
		//salvar(scanner);
	}
	
	private void salvar(Scanner scanner) {
		System.out.println("Nome do Funcionario");
		String nome = scanner.next();
		System.out.println("CPF do Funcionario");
		String cpf = scanner.next();
		System.out.println("Salario do Funcionario");
		Double salario = scanner.nextDouble();
		fucionario.setNome(nome);
		fucionario.setCpf(cpf);
		fucionario.setSalario(salario);
		fucionario.setDataContratacao(LocalDateTime.now());
		System.out.println("Salvo!");
	}
	
	private void atualizar(Scanner scanner) {
		Cargo cargo = new Cargo();
		System.out.println("Digite o Id do cargo");
		int id= scanner.nextInt();
		System.out.println("Digite nova Descricao");
		String desc = scanner.next();
		cargo.setDescricao(desc);
		cargo.setId(id);
		//cargoRepository.save(cargo);
		System.out.println("Atualizado!");
	}
	private void visualizar() {
	//	Iterable<Cargo> cargos = cargoRepository.findAll();
		//cargos.forEach(cargo-> System.out.println(cargo));
	}
	
	public void deletar(Scanner scanner) {
		System.out.println("Digite o Id");
		int id = scanner.nextInt();
	//	cargoRepository.deleteById(id);
		
	}

}
