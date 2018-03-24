package br.com.fornow.lancamentos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fornow.lancamentos.enums.StatusLancamento;

public interface LancamentoRepository extends JpaRepository<LancamentoVo, Long>{
	
	LancamentoVo findById(Long id);
	List<LancamentoVo> findByStatusAndMesReferencia(StatusLancamento status, int mesReferencia);
}
