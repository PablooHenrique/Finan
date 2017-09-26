package br.com.fornow.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.fornow.model.Lancamento;
import br.com.fornow.service.LancamentoService;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listaTodosLancamentos(){
		List<Lancamento> lancamentos = new LancamentoService().listarTodosLancamentos();
		if (lancamentos.isEmpty()) {
			return new ResponseEntity<List<Lancamento>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Lancamento>>(lancamentos, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> salvaLancamento(@RequestBody Lancamento lancamento, UriComponentsBuilder ucBuilder){
		new LancamentoService().salvarLancamento(lancamento);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/lancamentos/{id}").buildAndExpand(lancamento.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<?> atualizaLancamento(@PathVariable("id") long id, @RequestBody Lancamento lancamento){
		lancamento = new LancamentoService().atualizarLancamento(id, lancamento);
		return new ResponseEntity<Lancamento>(lancamento, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<?> deletaLancamento(@PathVariable("id") long id){
		new LancamentoService().deletarLancamento(id);
		return new ResponseEntity<Lancamento>(HttpStatus.NO_CONTENT);
	}
}
