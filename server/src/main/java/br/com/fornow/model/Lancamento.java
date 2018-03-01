package br.com.fornow.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.com.fornow.model.enums.TipoLancamento;

@Entity
public class Lancamento {
	
	@Id
	@GeneratedValue
	private long id;
	private Double valor;
	private String descricao;
	private int mesReferencia;
	private TipoLancamento tipo;
	private StatusLancamento status;
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
	public TipoLancamento getTipo() {
		return tipo;
	}
	public void setTipo(TipoLancamento tipo) {
		this.tipo = tipo;
	}
	public StatusLancamento getStatus() {
		return status;
	}
	public void setStatus(StatusLancamento status) {
		this.status = status;
	}
}
