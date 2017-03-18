package br.com.finan.fs;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.finan.dominio.Lancamento;

@RestController
public class LancamentosController {
	
	@RequestMapping(value = "/lancamentos", method=RequestMethod.GET)
	public ResponseEntity<List<Lancamento>> listarLancamentos(){
		List<Lancamento> lancamentos= new ArrayList<Lancamento>();
		
		Lancamento lancamento = new Lancamento();
		lancamento.setDataLancamento(LocalDate.of(2017, 03, 18));
		lancamento.setDescricao("Futebol");
		lancamento.setValorLancamento(10.0);
		
		lancamentos.add(lancamento);
		
		lancamento = new Lancamento();
		lancamento.setDataLancamento(LocalDate.of(2017, 03, 15));
		lancamento.setDescricao("Caneca Direito");
		lancamento.setValorLancamento(10.0);
		
		lancamentos.add(lancamento);
		
		return new ResponseEntity<List<Lancamento>>(lancamentos, HttpStatus.OK);
	}
}
