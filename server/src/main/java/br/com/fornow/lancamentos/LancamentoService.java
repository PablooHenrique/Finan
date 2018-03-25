package br.com.fornow.lancamentos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fornow.lancamentos.enums.StatusLancamento;
import br.com.fornow.lancamentos.enums.TipoLancamento;

@Service
public class LancamentoService {
	
	@Autowired
	private LancamentoRepository repository;
	
	public List<LancamentoVo> listar(){
		List<LancamentoVo> lancamentos = this.repository.findAll();
		return lancamentos;
	}
	
	public LancamentoVo salvar(LancamentoVo lancamento){
		lancamento.setDataLancamento(LocalDate.now());
		lancamento = this.repository.save(lancamento);
		return lancamento;
	}
	
	public LancamentoVo atualizar(LancamentoVo lancamento){
		LancamentoVo findById = this.repository.findById(lancamento.getId());
		
		findById.setValorEfetuado(lancamento.getValorEfetuado());
		findById.setValorPrevisto(lancamento.getValorPrevisto());
		findById.setTitulo(lancamento.getTitulo());
		findById.setTipo(lancamento.getTipo());
		findById.setStatus(lancamento.getStatus());
		findById.setMesReferencia(lancamento.getMesReferencia());
		findById.setDetalhes(lancamento.getDetalhes());
		
		lancamento = this.repository.save(findById);
		return lancamento;
	}

	public void deletar(long id) {
		this.repository.delete(id);
	}

	public LancamentoVo pesquisarPorId(long id) {
		LancamentoVo lancamento = this.repository.findById(id);
		return lancamento;
	}

	public List<LancamentoVo> pesquisarPorStatusEMesReferencia(int mesReferencia, StatusLancamento status) {
		List<LancamentoVo> lancamentos = this.repository.findByStatusAndMesReferencia(status, mesReferencia);
		return lancamentos;
	}

	public LancamentoVo efetivarPagamento(long id) {
		LancamentoVo lancamento = this.repository.findById(id);
		
		lancamento.setStatus(StatusLancamento.PAGO);
		lancamento.setDataDePagamento(LocalDate.now());
		
		this.repository.save(lancamento);
		
		return lancamento;
	}

	public BigDecimal pesquisarTotalPrevistoPorStatusEMesReferencia(int mesReferencia, StatusLancamento status) {
		List<LancamentoVo> lancamentos = this.repository.findByStatusAndMesReferencia(status, mesReferencia);
		BigDecimal total = new BigDecimal("0");
		for (LancamentoVo lancamentoVo : lancamentos) {
			total = total.add(lancamentoVo.getValorPrevisto());
		}
		return total;
	}
	
	public BigDecimal pesquisarTotalEfetuadoPorMesReferencia(int mesReferencia) {
		List<LancamentoVo> lancamentos = this.repository.findByStatusAndMesReferencia(StatusLancamento.PAGO, mesReferencia);
		BigDecimal total = new BigDecimal("0");
		for (LancamentoVo lancamentoVo : lancamentos) {
			total = total.add(lancamentoVo.getValorEfetuado());
		}
		return total;
	}

	public List<LancamentoVo> pesquisarPorMesReferencia(int mesReferencia) {
		List<LancamentoVo> lancamentos = this.repository.findByMesReferencia(mesReferencia);
		return lancamentos;
	}

	public List<LancamentoVo> pesquisarPorTipoEMesReferencia(TipoLancamento tipo, int mesReferencia) {
		List<LancamentoVo> lancamentos = this.repository.findByTipoAndMesReferencia(tipo, mesReferencia);
		return lancamentos;
	}

	public BigDecimal pesquisarTotalPorTipoEMesReferencia(TipoLancamento tipo, int mesReferencia) {
		List<LancamentoVo> lancamentos = this.repository.findByTipoAndMesReferencia(tipo, mesReferencia);
		BigDecimal total = new BigDecimal("0");
		for (LancamentoVo lancamento : lancamentos) {
			total = total.add(lancamento.getValorPrevisto());
		}
		return total;
	}
}
