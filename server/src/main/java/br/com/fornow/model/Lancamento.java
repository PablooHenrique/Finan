package br.com.fornow.model;

import java.time.LocalDate;

public class Lancamento {
	
	private long id;
	private Double valor;
	private String descricao;
	private int mesReferencia;
	private LocalDate dataLancamento;
	private LocalDate dataDePagamento;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getMesReferencia() {
		return mesReferencia;
	}
	public void setMesReferencia(int mesReferencia) {
		this.mesReferencia = mesReferencia;
	}
	public LocalDate getDataLancamento() {
		return dataLancamento;
	}
	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
	public LocalDate getDataDePagamento() {
		return dataDePagamento;
	}
	public void setDataDePagamento(LocalDate dataDePagamento) {
		this.dataDePagamento = dataDePagamento;
	}
}