package br.com.fornow.application.produto;

import java.util.ArrayList;
import java.util.List;

import br.com.fornow.service.produto.ProdutoDto;
import br.com.fornow.service.produto.ProdutoService;

public class ProdutoApplication {

	public boolean salvarProduto(ProdutoDto produto) {
		return new ProdutoService().salvar(produto);
	}

	public List<ProdutoDto> listarTodosProdutos() {
		ArrayList<ProdutoDto> produtos = new ArrayList<ProdutoDto>();
		
		ProdutoDto produto = new ProdutoDto();
		produto.setId(300);
		produto.setDescricao("Descricao do Produto");
		produto.setPreco(30.0);
		
		produtos.add(produto);
		
		return produtos;
	}

}
