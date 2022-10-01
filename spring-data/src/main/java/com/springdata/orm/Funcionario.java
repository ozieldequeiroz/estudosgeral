package com.springdata.orm;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	private String nome;
	private String cpf;
	private Double salario;
	private LocalDateTime dataContratacao;
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
	@Override
	public int hashCode() {
		return Objects.hash(Id, cpf, dataContratacao, nome, salario);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return Objects.equals(Id, other.Id) && Objects.equals(cpf, other.cpf)
				&& Objects.equals(dataContratacao, other.dataContratacao) && Objects.equals(nome, other.nome)
				&& Objects.equals(salario, other.salario);
	}
	

}
