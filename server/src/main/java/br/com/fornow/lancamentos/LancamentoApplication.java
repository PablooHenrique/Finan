package br.com.fornow.lancamentos;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.fornow.lancamentos.enums.StatusLancamento;
import br.com.fornow.lancamentos.enums.TipoLancamento;


@Controller
public class LancamentoApplication {
	
	@Autowired
	private LancamentoService service;
	
	public void salvar(LancamentoDto lancamento){
		LancamentoVo vo = converterDtoEmValueObject(lancamento);
		service.salvar(vo);
	}
	
	public List<LancamentoDto> listar(){
		List<LancamentoVo> lancamentos = this.service.listar();
		List<LancamentoDto> dtos = converterListaVoEmDto(lancamentos);
		return dtos;
	}
	
	private List<LancamentoDto> converterListaVoEmDto(List<LancamentoVo> lancamentos) {
		ModelMapper mapper = new ModelMapper();
		LancamentoDto[] map = mapper.map(lancamentos, LancamentoDto[].class);
		List<LancamentoDto> dtos = Arrays.asList(map);
		return dtos;
	}

	public LancamentoDto atualiza(LancamentoDto lancamento){
		LancamentoVo vo = converterDtoEmValueObject(lancamento);
		vo = this.service.atualizar(vo);
		lancamento = converterVoEmDto(vo);
		return lancamento;
	}
	
	public void deleta(long id){
		this.service.deletar(id);
	}

	public LancamentoDto pesquiarPorId(long id) {
		LancamentoVo lancamento = this.service.pesquisarPorId(id);
		LancamentoDto dto = converterVoEmDto(lancamento);
		return dto;
	}

	public List<LancamentoDto> pesquisarPorMesReferencia(int mesReferencia) {
		List<LancamentoVo> lancamentos = this.service.pesquisarPorMesReferencia(mesReferencia);
		List<LancamentoDto> dtos = converterListaVoEmListaDto(lancamentos);
		return dtos;
	}

	public List<LancamentoDto> pesquisarPorStatusEMesReferencia(int mesReferencia, StatusLancamento status) {
		List<LancamentoVo> lancamentos = this.service.pesquisarPorStatusEMesReferencia(mesReferencia, status);
		List<LancamentoDto> dtos = converterListaVoEmListaDto(lancamentos);
		return dtos;
	}

	public LancamentoDto efetivarPagamento(long id) {
		LancamentoVo lancamento = this.service.efetivarPagamento(id);
		LancamentoDto dto = converterVoEmDto(lancamento);
		return dto;
	}

	public BigDecimal pesquisarTotalPrevistoPorStatusEMesReferencia(int mesReferencia, StatusLancamento status) {
		BigDecimal total = this.service.pesquisarTotalPrevistoPorStatusEMesReferencia(mesReferencia, status);
		return total;
	}
	
	private LancamentoDto converterVoEmDto(LancamentoVo lancamento) {
		ModelMapper mapper = new ModelMapper();
		LancamentoDto dto = mapper.map(lancamento, LancamentoDto.class);
		return dto;
	}
	
	public List<LancamentoDto> pesquisarPorTipoEMesReferencia(TipoLancamento tipo, int mesReferencia) {
		List<LancamentoVo> lancamentos = this.service.pesquisarPorTipoEMesReferencia(tipo, mesReferencia);
		List<LancamentoDto> dtos = converterListaVoEmListaDto(lancamentos);
		return dtos;
	}

	public BigDecimal pesquisarTotalPorTipoEMesReferencia(TipoLancamento tipo, int mesReferencia) {
		BigDecimal total = this.service.pesquisarTotalPorTipoEMesReferencia(tipo, mesReferencia);
		return total;
	}
	
	private List<LancamentoDto> converterListaVoEmListaDto(List<LancamentoVo> lancamentos) {
		ModelMapper mapper = new ModelMapper();
		LancamentoDto[] map = mapper.map(lancamentos, LancamentoDto[].class);
		List<LancamentoDto> dtos = Arrays.asList(map);
		return dtos;
	}
	
	private LancamentoVo converterDtoEmValueObject(LancamentoDto lancamento) {
		ModelMapper mapper = new ModelMapper();
		LancamentoVo vo = mapper.map(lancamento, LancamentoVo.class);
		return vo;
	}
}
