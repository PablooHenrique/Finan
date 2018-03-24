package br.com.fornow.lancamentos;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.fornow.lancamentos.enums.StatusLancamento;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {
	
	@Autowired
	private LancamentoService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listaTodosLancamentos(){
		List<LancamentoVo> lancamentos = this.service.listar();
		if (lancamentos.isEmpty()) {
			return new ResponseEntity<List<Lancamento>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<LancamentoVo>>(lancamentos, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> salvaLancamento(@RequestBody LancamentoVo lancamento, UriComponentsBuilder ucBuilder){
		this.service.salvar(lancamento);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/lancamentos/{id}").buildAndExpand(lancamento.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<?> atualizaLancamento(@RequestBody LancamentoVo lancamento){
		lancamento = this.service.atualizar(lancamento);
		return new ResponseEntity<LancamentoVo>(lancamento, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletaLancamento(@PathVariable("id") long id){
		this.service.deletar(id);
		return new ResponseEntity<LancamentoVo>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> pesquisaLancamentoPorId(@PathVariable("id") long id){
		LancamentoVo lancamento = this.service.pesquisarPorId(id);
		return new ResponseEntity<LancamentoVo>(lancamento, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{mesReferencia}/{status}")
	public ResponseEntity<?> pesquisaLancamentoPorStatusEMesReferencia(
							  @PathVariable("mesReferencia") int mesReferencia
							, @PathVariable("status") StatusLancamento status){
		
		List<LancamentoVo> lancamentos = this.service.pesquisarPorStatusEMesReferencia(mesReferencia, status);
		return new ResponseEntity<List<LancamentoVo>>(lancamentos, HttpStatus.OK);
	}
	
	@RequestMapping(value="/efetivaPagamento/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> efetivaPagamento(@PathVariable("id") long id){
		LancamentoVo lancamento = this.service.efetivarPagamento(id);
		return new ResponseEntity<LancamentoVo>(lancamento, HttpStatus.OK);
	}
	
	@RequestMapping(value="/pesquisaTotalLancamentosPrevistoPorStatusEMesReferencia/{status}/{mesReferencia}")
	public ResponseEntity<?> pesquisaTotalDeLancamentoPorStatusEMesReferencia(
			  				@PathVariable("mesReferencia") int mesReferencia
			  			  , @PathVariable("status") StatusLancamento status){
		BigDecimal total = this.service.pesquisarTotalPrevistoPorStatusEMesReferencia(mesReferencia, status);
		return new ResponseEntity<BigDecimal>(total, HttpStatus.OK);
	}
}
