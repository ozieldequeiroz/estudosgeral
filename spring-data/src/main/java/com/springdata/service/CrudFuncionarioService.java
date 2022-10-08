package com.springdata.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.springdata.orm.Cargo;
import com.springdata.orm.Funcionario;
import com.springdata.orm.Unidade;
import com.springdata.repository.CargoRepository;
import com.springdata.repository.FuncionarioRepository;
import com.springdata.repository.UnidadeRepository;

@Service
public class CrudFuncionarioService {
	
	private Funcionario funcionario = new Funcionario();
	private Cargo cargos = new Cargo();
	private Unidade unidades = new Unidade();
	
	Scanner scanner = new Scanner(System.in);
	private Boolean system = true;
	
	private FuncionarioRepository funcionarioRepository;
	private CargoRepository cargoRepository;
	private UnidadeRepository unidadeRepository;
		
	public CrudFuncionarioService(FuncionarioRepository funcionarioRepository, CargoRepository cargoRepository,UnidadeRepository unidadeRepository) {
		this.funcionarioRepository=funcionarioRepository;
		this.cargoRepository=cargoRepository;
		this.unidadeRepository=unidadeRepository;
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
			case 0:
				system = false;
				break;
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
	}
	
	private void salvar(Scanner scanner) {
		System.out.println("Nome do Funcionario");
		String nome = scanner.next();
		System.out.println("CPF do Funcionario");
		String cpf = scanner.next();
		System.out.println("Salario do Funcionario");
		Double salario = scanner.nextDouble();	

		cargos = takeCargo(scanner);
		unidades = takeUnidade(scanner);
		
		funcionario.setCargo(cargos);
		funcionario.setUnidade(Arrays.asList(unidades));
		funcionario.setNome(nome);
		funcionario.setCpf(cpf);
		funcionario.setSalario(salario);
		funcionario.setDataContratacao(LocalDateTime.now());
		System.out.println("Salvo!");
	}
	
	private void atualizar(Scanner scanner) {
		
		System.out.println("Digite o Id do Funcionario");
		int id= scanner.nextInt();
		System.out.println("Digite o novo nome do Funcionario");
		String nome = scanner.next();
		System.out.println("Digite o novo CPF do Funcionario");
		String cpf = scanner.next();
		System.out.println("Digite o novo Salario do Funcionario");
		Double salario = scanner.nextDouble();
		funcionario.setId(id);
		
		if(!nome.isBlank()) {
			funcionario.setNome(nome);
		} else if(!cpf.isBlank()) {
			funcionario.setCpf(cpf);
		} else if(!salario.isNaN()) {
			funcionario.setSalario(salario);
		}

		funcionarioRepository.save(funcionario);
		System.out.println("Atualizado!");
	}
	private void visualizar() {
		Iterable<Funcionario> funcionarios = funcionarioRepository.findAll();
		funcionarios.forEach(funcionario->System.out.println(funcionario));
	}
	
	private void deletar(Scanner scanner) {
		System.out.println("Digite o Id do Funcionario");
		int id = scanner.nextInt();
		funcionarioRepository.deleteById(id);	
	}
	
	private Cargo takeCargo(Scanner scanner) {
		System.out.println("chegou aqui 1");
		Iterable<Cargo> cargo = cargoRepository.findAll();
		if(cargo.equals(null)) {
			return null;
		}
		System.out.println("chegou aqui 2");
		cargo.forEach(cargos->System.out.println(cargos));
		System.out.println("Digite o Id do Cargo");
		Integer cargoid = scanner.nextInt();
		Optional<Cargo> theCargo = cargoRepository.findById(cargoid);
		return theCargo.get();
	}
	private Unidade takeUnidade(Scanner scanner) {
		Iterable<Unidade> unidade = unidadeRepository.findAll();
		if (unidade.equals(null)) {
			return null;
		}
		unidade.forEach(unidades->System.out.println(unidades));
		System.out.println("Digite o Id da Unidade");
		Integer unidadeId = scanner.nextInt();
		Optional<Unidade> theUnidade = unidadeRepository.findById(unidadeId);
		return theUnidade.get();
	}
	
}