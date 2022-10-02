package com.springdata.service;

import java.util.Optional;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.springdata.orm.Cargo;
import com.springdata.repository.CargoRepository;

@Service
public class CrudCargoService {
	
	Scanner scanner = new Scanner(System.in);
	private Boolean system = true;
	
	private CargoRepository cargoRepository;
		
	public CrudCargoService(CargoRepository cargoRepository) {
		this.cargoRepository=cargoRepository;
	}
	
	public void iniciar(Scanner scanner){
		while (system) {
			System.out.println("Qual ação de cargo quer executar");
			System.out.println("Digite - 0 : para sair");
			System.out.println("Digite - 1 : Adicionar um Cargo");
			System.out.println("Digite - 2 : Atualizar um Cargo");
			System.out.println("Digite - 3 : Visualizar os Cargo");
			System.out.println("Digite - 4 : Deletar um Cargo");
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
		
	}
	
	private void salvar(Scanner scanner) {
		Cargo cargo = new Cargo();
		System.out.println("Descricao do Cargo");
		String desc = scanner.next();
		cargo.setDescricao(desc);
		cargoRepository.save(cargo);
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
		cargoRepository.save(cargo);
		System.out.println("Atualizado!");
	}
	private void visualizar() {
		Iterable<Cargo> cargos = cargoRepository.findAll();
		cargos.forEach(cargo-> System.out.println(cargo));
	}
	
	public void deletar(Scanner scanner) {
		System.out.println("Digite o Id");
		int id = scanner.nextInt();
		cargoRepository.deleteById(id);
		
	}
}
