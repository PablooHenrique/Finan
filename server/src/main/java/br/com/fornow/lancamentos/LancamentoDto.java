package br.com.fornow.lancamentos;

import java.math.BigDecimal;

import br.com.fornow.lancamentos.enums.StatusLancamento;
import br.com.fornow.lancamentos.enums.TipoLancamento;

public class LancamentoDto {
	
	private long id;
	private String titulo;
	private String detalhes;
	private BigDecimal valorPrevisto;
	private BigDecimal valorEfetuado;
	private int mesReferencia;
	private TipoLancamento tipo;
	private StatusLancamento status;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDetalhes() {
		return detalhes;
	}
	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}
	public BigDecimal getValorPrevisto() {
		return valorPrevisto;
	}
	public void setValorPrevisto(BigDecimal valorPrevisto) {
		this.valorPrevisto = valorPrevisto;
	}
	public BigDecimal getValorEfetuado() {
		return valorEfetuado;
	}
	public void setValorEfetuado(BigDecimal valorEfetuado) {
		this.valorEfetuado = valorEfetuado;
	}
	public int getMesReferencia() {
		return mesReferencia;
	}
	public void setMesReferencia(int mesReferencia) {
		this.mesReferencia = mesReferencia;
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
