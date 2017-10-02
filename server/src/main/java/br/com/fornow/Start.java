package br.com.fornow;

import java.time.LocalDate;

import br.com.fornow.model.Lancamento;
import br.com.fornow.model.enums.TipoLancamento;
import br.com.fornow.service.LancamentoService;

public class Start {
	public static void main(String[] args) {
		Lancamento lancamento = new Lancamento();
		lancamento.setDataLancamento(LocalDate.now());
		lancamento.setDescricao("Parcela Consorcio Atrasada Carro");
		lancamento.setMesReferencia(10);
		lancamento.setTipoLancamento(TipoLancamento.D);
		lancamento.setValor(700.00);
		new LancamentoService().salvarLancamento(lancamento);
	}
}
