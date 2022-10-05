package com.springdata.orm;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "funcionario")
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	private String nome;
	private String cpf;
	private Double salario;
	private LocalDateTime dataContratacao;
	
	@ManyToOne 
	@JoinColumn(name = "cargo_id", nullable = false)
	private Cargo cargo = new Cargo();	
	
	//@Fetch(FetchMode.SELECT)
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	//@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "funcionarios_unidades", 
				joinColumns = { @JoinColumn(name = "fk_funcionario", referencedColumnName = "id",
                nullable = false, updatable = false) }, 
	inverseJoinColumns = { @JoinColumn(name = "fk_unidade", referencedColumnName = "id",
    nullable = false, updatable = false) })
	List<Unidade> unidades;
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public LocalDateTime getDataContratacao() {
		return dataContratacao;
	}
	public void setDataContratacao(LocalDateTime dataContratacao) {
		this.dataContratacao = dataContratacao;
	}
	@Override
	public String toString() {
		return "Funcionario [ Id=" + Id + ", nome=" + nome + ", cpf=" + cpf + ", salario=" + salario
				+ ", dataContratacao=" + dataContratacao + " ]";
	}

}
