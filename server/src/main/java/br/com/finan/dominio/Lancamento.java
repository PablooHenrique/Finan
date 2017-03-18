package br.com.finan.dominio;

import java.time.LocalDate;

public class Lancamento {
	
	private long id;
	private LocalDate dataLancamento;
	private String descricao;
	private Double valorLancamento;
	
	public LocalDate getDataLancamento() {
		return dataLancamento;
	}
	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getValorLancamento() {
		return valorLancamento;
	}
	public void setValorLancamento(Double valorLancamento) {
		this.valorLancamento = valorLancamento;
	}
}
