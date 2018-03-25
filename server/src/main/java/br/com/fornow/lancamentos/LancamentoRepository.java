package br.com.fornow.lancamentos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fornow.lancamentos.enums.StatusLancamento;
import br.com.fornow.lancamentos.enums.TipoLancamento;

public interface LancamentoRepository extends JpaRepository<LancamentoVo, Long>{
	
	LancamentoVo findById(Long id);
	List<LancamentoVo> findByStatusAndMesReferencia(StatusLancamento status, int mesReferencia);
	List<LancamentoVo> findByMesReferencia(int mesReferencia);
	List<LancamentoVo> findByTipoAndMesReferencia(TipoLancamento tipo, int mesReferencia);
}
