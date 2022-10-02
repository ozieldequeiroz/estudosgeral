package com.springdata;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springdata.orm.Cargo;
import com.springdata.service.CrudCargoService;
import com.springdata.service.CrudFuncionarioService;
import com.springdata.service.CrudUnidadeService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner{
	
	private Boolean system = true;
	
	private final CrudCargoService crudCargoService;
	private final CrudFuncionarioService funcionarioService;
	private final CrudUnidadeService unidadeService;
	
	public SpringDataApplication(
			CrudCargoService cargoRepository,
			CrudFuncionarioService funcionarioService,
			CrudUnidadeService unidadeService) {
		this.crudCargoService = cargoRepository;
		this.funcionarioService=funcionarioService;
		this.unidadeService=unidadeService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		while (system) {
			System.out.println("Qual ação você quer executar");
			System.out.println("Digite - 0 : para sair");
			System.out.println("Digite - 1 : Adicionar um Cargo");
			System.out.println("Digite - 2 : Adicionar um Funcionario");
			System.out.println("Digite - 3 : Adicionar uma Unidade");
			int action = scanner.nextInt();
			
			switch (action) {
			case 0:
				system = false;
			case 1:
				crudCargoService.iniciar(scanner);
				break;
			case 2:
				funcionarioService.iniciar(scanner);
			case 3:
				unidadeService.iniciar(scanner);
			default:
				system = false;
				break;
			}
			
		}
	}

}
