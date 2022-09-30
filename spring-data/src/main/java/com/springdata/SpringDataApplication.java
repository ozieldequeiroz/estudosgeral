package com.springdata;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springdata.orm.Cargo;
import com.springdata.service.CrudCargoService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner{
	
	private Boolean system = true;
	
	private final CrudCargoService crudCargoService;
	
	public SpringDataApplication(CrudCargoService cargoRepository) {
		this.crudCargoService = cargoRepository;
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
			int action = scanner.nextInt();
			
			if (action == 1) {
				crudCargoService.iniciar(scanner);
			} else {
				system = false;
			}
			
			/*switch (action) {
			case 1:
				crudCargoService.iniciar(scanner);
				break;

			default:
				break;
			}*/
			
		}

		
	}

}
