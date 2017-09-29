package br.com.fornow.view;

import java.time.LocalDate;
import java.util.Scanner;

import br.com.fornow.model.Lancamento;
import br.com.fornow.model.enums.TipoLancamento;
import br.com.fornow.service.LancamentoService;

public class LancamentoView {
	public void criarTelaInicialOpcoesLancamento(){
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("1 - Novo lançamento");
		System.out.println("2 - Pesquisar Lançamento");
		System.out.println("0 - Sair");
		
		int opcao = scanner.nextInt();
		carregarOpcao(opcao);
	}
	
	private void carregarOpcao(int opcao) {
		switch (opcao) {
		case 1:
			criarTelaNovoLancamento();
			break;
		default:
			break;
		}
	}

	private void criarTelaNovoLancamento(){
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite a descrição do lançamento");
		String descricaoDoLancamento = scanner.nextLine();
		
		System.out.println("E um lançamento do tipo Credito(C) ou Debito(D) ");
		String tipoLancamento = scanner.nextLine();
		
		System.out.println("Digite o mês de vencimento");
		int mesVencimento = scanner.nextInt();
		
		System.out.println("Digite o valor");
		Double valorLancamento = scanner.nextDouble();
		
		System.out.println("Lancamento ja esta finalizado? 0 Falso - 1 Verdadeiro");
		boolean lancamentoFinalizado = scanner.nextBoolean();
		
		salvarLancamento(descricaoDoLancamento, tipoLancamento, mesVencimento, valorLancamento, lancamentoFinalizado);
		System.out.println("Lancamento Realizado Com Sucesso");
	}
	
	public void salvarLancamento(String descricao, String tipoLancamento, int mesReferencia, Double valorLancamento, boolean lancamentoFinalizado){
		Lancamento lancamento = new Lancamento();
		lancamento.setDescricao(descricao);
		lancamento.setTipoLancamento(TipoLancamento.valueOf(tipoLancamento));
		lancamento.setMesReferencia(mesReferencia);
		lancamento.setValor(valorLancamento);
		if (lancamentoFinalizado) {
			lancamento.setDataDePagamento(LocalDate.now());
		}
		
		new LancamentoService().salvarLancamento(lancamento);
	}
}
