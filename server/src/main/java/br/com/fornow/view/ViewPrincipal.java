package br.com.fornow.view;

import java.util.Scanner;

public class ViewPrincipal {
	
	public void run() {
		Scanner scanner = new Scanner(System.in);
		criarTelaInicial();
		int opcao = lerEntradaInteira(scanner);
		carregarOpcoes(opcao);
	}
	
	private void criarTelaInicial(){
		System.out.println("Finan");
		System.out.println("Selecione uma op��o");
		System.out.println("1 - Lan�amento");
		System.out.println("0 - sair");
	}

	private void carregarOpcoes(int escolha) {
		switch (escolha) {
		case 1:
			new LancamentoView().criarTelaInicialOpcoesLancamento();
			break;
		default:
			break;
		}
		
	}

	
}
