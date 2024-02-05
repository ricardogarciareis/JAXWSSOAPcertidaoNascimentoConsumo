package com.dzzcreations.JAXWSSOAPcertidaoNascimentoConsumo.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

public class Nascimento {

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "- Deve escolher uma data de nascimento")
	@Past(message = "- A data de nascimmento deve ser anterior à atual")
	private Date dataNascimento;
	
	private int idade;
	private String diaSemana;
	
	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	public Nascimento() {

	}
	
	public Nascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	
	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
