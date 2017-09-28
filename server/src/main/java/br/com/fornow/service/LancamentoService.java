package br.com.fornow.service;

import java.util.List;

import br.com.fornow.model.Lancamento;
import br.com.fornow.repository.LancamentoRepository;

public class LancamentoService {
	
	public void salvarLancamento(Lancamento lancamento){
		new LancamentoRepository().salvarLancamento(lancamento);
		System.out.println("Lancamento Salvo");
	}

	public List<Lancamento> listarTodosLancamentos() {
		System.out.println("Listando...");
		List<Lancamento> lancamentos = new LancamentoRepository().listar();
		return lancamentos;
	}

	public Lancamento atualizarLancamento(long id, Lancamento lancamento) {
		new LancamentoRepository().atualizarLancamento(lancamento);
		System.out.println("Atualizado");
		return null;
	}

	public void deletarLancamento(long id) {
		new LancamentoRepository().deletar(id);
		System.out.println("Deletado");
	}
}
