package br.com.fornow.fs;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.fornow.application.produto.ProdutoApplication;
import br.com.fornow.service.produto.ProdutoDto;

@RestController
@RequestMapping("/produto")
public class ProdutoFs {
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> salva(@RequestBody ProdutoDto produto){
		boolean resp = new ProdutoApplication().salvarProduto(produto);
		if (resp) {
			return ResponseEntity.created(URI.create("/cadastradoComSucesso")).build();
		}
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> lista(){
		List<ProdutoDto> produtos = new ProdutoApplication().listarTodosProdutos();
		String json = new Gson().toJson(produtos);
		return ResponseEntity.ok(json);
	}
}
