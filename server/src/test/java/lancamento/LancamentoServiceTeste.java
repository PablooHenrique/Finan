package lancamento;

import java.util.List;

import org.junit.Test;

import br.com.fornow.model.Lancamento;
import br.com.fornow.service.LancamentoService;

public class LancamentoServiceTeste {
	
	@Test
	public void salvaLancamentoTeste(){
		new LancamentoService().salvarLancamento(criarLancamento());
	}
	
	@Test
	public void listarLancamentos(){
		List<Lancamento> lancamentos = new LancamentoService().listarTodosLancamentos();
		lancamentos.stream().forEach(x->System.out.println(x.getId() +"- " + x.getDescricao() +"- "+ x.getValor()));
	}
	
	public Lancamento criarLancamento(){
		Lancamento lancamento = new Lancamento();
		lancamento.setDescricao("Teste de Lancamento");
		lancamento.setMesReferencia(10);
		lancamento.setValor(200.0);
		return lancamento;
	}
}
