package com.springdata.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.springdata.orm.Funcionario;
import com.springdata.orm.FuncionarioProjecao;



@Repository
public interface FuncionarioRepository extends PagingAndSortingRepository<Funcionario, Integer>{
	
	List<Funcionario> findByNome(String nome);
	@Query("SELECT f FROM Funcionario f WHERE f.nome = :nome and f.salario>= :salario AND f.dataContratacao=:data")
	List<Funcionario> findNomeDataContratacaoSalarioMaior(String nome,Double salario,LocalDate data);
	
	@Query(value="SELECT * FROM FUNCIONARIOS f WHERE f.data_contratacao>=:data",
			nativeQuery = true)
	List<Funcionario> findDataContracaoMaior(LocalDate data);
	
	@Query(value="SELECT f.id, f.nome,f.salario FROM FUNCIONARIOS f ",
			nativeQuery = true)
	List<FuncionarioProjecao> findSalarioMaior();

}
