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
import br.com.fornow.lancamentos.enums.TipoLancamento;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {
	
	@Autowired
	private LancamentoApplication application;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> lista(){
		List<LancamentoDto> lancamentos = this.application.listar();
		if (lancamentos.isEmpty()) {
			return new ResponseEntity<List<LancamentoDto>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<LancamentoDto>>(lancamentos, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> salva(@RequestBody LancamentoDto lancamento, UriComponentsBuilder ucBuilder){
		this.application.salvar(lancamento);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/lancamentos/{id}").buildAndExpand(lancamento.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<?> atualiza(@RequestBody LancamentoDto lancamento){
		lancamento = this.application.atualiza(lancamento);
		return new ResponseEntity<LancamentoDto>(lancamento, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleta(@PathVariable("id") long id){
		this.application.deleta(id);
		return new ResponseEntity<LancamentoDto>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> pesquisaPorId(@PathVariable("id") long id){
		LancamentoDto lancamento = this.application.pesquiarPorId(id);
		return new ResponseEntity<LancamentoDto>(lancamento, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET,  value = "/pesquisaPorMesReferencia/{mesReferencia}")
	public ResponseEntity<?> pesquisaPorMesReferencia(@PathVariable("mesReferencia") int mesReferencia){
		List<LancamentoDto> lancamentos = this.application.pesquisarPorMesReferencia(mesReferencia);
		return new ResponseEntity<List<LancamentoDto>>(lancamentos, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{mesReferencia}/{status}")
	public ResponseEntity<?> pesquisaLancamentoPorStatusEMesReferencia(
							  @PathVariable("mesReferencia") int mesReferencia
							, @PathVariable("status") StatusLancamento status){
		
		List<LancamentoDto> lancamentos = this.application.pesquisarPorStatusEMesReferencia(mesReferencia, status);
		return new ResponseEntity<List<LancamentoDto>>(lancamentos, HttpStatus.OK);
	}
	
	@RequestMapping(value="/efetivaPagamento/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> efetivaPagamento(@PathVariable("id") long id){
		LancamentoDto lancamento = this.application.efetivarPagamento(id);
		return new ResponseEntity<LancamentoDto>(lancamento, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/pesquisaTotalLancamentosPrevistoPorStatusEMesReferencia/{status}/{mesReferencia}")
	public ResponseEntity<?> pesquisaTotalDeLancamentoPrevistosPorStatusEMesReferencia(
			  				@PathVariable("mesReferencia") int mesReferencia
			  			  , @PathVariable("status") StatusLancamento status){
		BigDecimal total = this.application.pesquisarTotalPrevistoPorStatusEMesReferencia(mesReferencia, status);
		return new ResponseEntity<BigDecimal>(total, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/pesquisaPorTipoEMesReferencia/{tipo}/{mesReferencia}")
	public ResponseEntity<?> pesquisarPorTipoEMesReferencia(@PathVariable("tipo") TipoLancamento tipo, @PathVariable("mesReferencia") int mesReferencia ){
		List<LancamentoDto> lancamentos = this.application.pesquisarPorTipoEMesReferencia(tipo, mesReferencia);
		return new ResponseEntity<List<LancamentoDto>>(lancamentos, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/pesquisaTotalPorTipoEMesReferencia/{tipo}/{mesReferencia}")
	public ResponseEntity<BigDecimal> pesquisaTotalPorTipoEMesReferencia(@PathVariable("tipo") TipoLancamento tipo, @PathVariable("mesReferencia") int mesReferencia){
		BigDecimal total = this.application.pesquisarTotalPorTipoEMesReferencia(tipo, mesReferencia);
		return new ResponseEntity<BigDecimal>(total, HttpStatus.OK);
	}
}
