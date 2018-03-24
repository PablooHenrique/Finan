package br.com.fornow.service;

import java.time.LocalDate;
import java.util.List;

import br.com.fornow.model.Lancamento;
import br.com.fornow.model.StatusLancamento;
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

	public Lancamento atualizarLancamento(long id, Lancamento lancamentoDto) {
		Lancamento lancamento = new LancamentoRepository().procurarLancamentoPorId(id);
		lancamento.setDescricao(lancamentoDto.getDescricao());
		lancamento.setMesReferencia(lancamentoDto.getMesReferencia());
		lancamento.setTipo(lancamentoDto.getTipo());
		lancamentoDto.setValor(lancamentoDto.getValor());
		
		new LancamentoRepository().atualizarLancamento(lancamento);
		System.out.println("Atualizado");
		return null;
	}

	public void deletarLancamento(long id) {
		new LancamentoRepository().deletar(id);
		System.out.println("Deletado");
	}

	public Lancamento pesquisarPorId(long id) {
		Lancamento lancamento = new LancamentoRepository().pesquisarPorId(id);
		System.out.println("Pesquisou por id");
		return lancamento;
	}

	public List<Lancamento> pesquisarPorStatusEMesReferencia(int mesReferencia, StatusLancamento status) {
		List<Lancamento> lancamentos = new LancamentoRepository().pesquisarLancamentosPorStatusEPorMes(status, mesReferencia);
		return lancamentos;
	}

	public Lancamento efetivarPagamento(long id) {
		LancamentoRepository repository = new LancamentoRepository();
		Lancamento lancamento = repository.pesquisarPorId(id);
		lancamento.setDataDePagamento(LocalDate.now());
		lancamento.setStatus(StatusLancamento.PAGO);
		repository.atualizarLancamento(lancamento);
		return lancamento;
	}

	public Double pesquisarTotalPorStatusEMesReferencia(int mesReferencia, StatusLancamento status) {
		List<Lancamento> lancamentos = pesquisarPorStatusEMesReferencia(mesReferencia, status);
		Double total = 0.0;
		
		for (Lancamento lancamento : lancamentos) {
			total += lancamento.getValor();
		}
		
		return total;
	}
}
