package com.springdata.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.springdata.orm.Cargo;
import com.springdata.orm.Unidade;
import com.springdata.repository.CargoRepository;
import com.springdata.repository.UnidadeRepository;

@Service
public class CrudUnidadeService {

	Scanner scanner = new Scanner(System.in);
	private Boolean system = true;
	
	private UnidadeRepository unidadeRepository;
	
	public CrudUnidadeService(UnidadeRepository unidadeRepository) {
		this.unidadeRepository=unidadeRepository;
	}
	
	public void iniciar(Scanner scanner){
		while (system) {
			System.out.println("Qual ação de cargo quer executar");
			System.out.println("Digite - 0 : para sair");
			System.out.println("Digite - 1 : Adicionar uma Unidade");
			System.out.println("Digite - 2 : Atualizar uma Unidade");
			System.out.println("Digite - 3 : Visualizar as Unidade");
			System.out.println("Digite - 4 : Deletar uma Unidade");
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
		Unidade unidade = new Unidade();
		System.out.println("Descricao na Unidade");
		String desc = scanner.next();
		unidade.setDescricao(desc);
		System.out.println("Endereco na Unidade");
		String end = scanner.next();
		unidade.setEndereco(end);
		unidadeRepository.save(unidade);
		System.out.println("Salvo!");
	}
	
	private void atualizar(Scanner scanner) {
		Unidade unidade = new Unidade();
		System.out.println("Digite o Id na Unidade");
		int id= scanner.nextInt();
		unidade.setId(id);
		System.out.println("Digite a Descricao da Unidade");
		String desc = scanner.next();
		System.out.println("Endereco o novo endereco da Unidade");
		String end = scanner.next();
		if(!desc.isBlank()) {
			unidade.setDescricao(desc);
		}
		if (!end.isBlank()) {
			unidade.setEndereco(end);
		}
		unidadeRepository.save(unidade);
		System.out.println("Atualizado!");
	}
	private void visualizar() {
		Iterable<Unidade> unidades = unidadeRepository.findAll();
		unidades.forEach(unidade-> System.out.println(unidade));
	}
	
	public void deletar(Scanner scanner) {
		System.out.println("Digite o Id da Unidade");
		int id = scanner.nextInt();
		unidadeRepository.deleteById(id);
		
	}

}
