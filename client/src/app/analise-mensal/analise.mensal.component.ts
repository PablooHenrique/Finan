import { Component } from '@angular/core';
import { LancamentoService } from '../lancamentos/lancamento.service';
import { ToastService } from '../shared/toast/toast.service'

declare var $:any;

@Component({
    selector : 'analise.mensal.component',
    templateUrl : 'analise.mensal.component.html',
    moduleId : module.id
})
export class AnaliseMensalComponent {
    public tableHeader = [];

    public lancamentosEmAberto = [];
    public lancamentosPagos = [];
    public mesReferencia;

    public totalLancamentosPagos : number = 0;
    public totalLancamentoEmAberto : number = 0;

    constructor(private _lancamentosService : LancamentoService, private _toast : ToastService ){
        this.tableHeader = ["Id", "Descrição", "Mês Referência", "Valor", "Tipo", "Status", ""]
    }

    analisar(){
        this.pesquisarLancamentoEmAbertoPorMesReferencia(this.mesReferencia);
        this.pesquisarLancamentoPagosPorMesReferencia(this.mesReferencia);
        this.pesquisarTotalLancamentos();
    }

    pesquisarLancamentoEmAbertoPorMesReferencia(mesReferencia){
        this._lancamentosService.pesquisarLancamentosEmAbertoPorMesReferencia(mesReferencia)
            .map(response =>response.json()).subscribe(response => {
                this.lancamentosEmAberto = response;
            });
    }

    pesquisarLancamentoPagosPorMesReferencia(mesReferencia){
        this._lancamentosService.pesquisarLancamentoPagosMesReferencia(mesReferencia)
        .map(response =>response.json()).subscribe(response => {
            this.lancamentosPagos = response;
        });
    }

    efetivarPagamento(lancamento){
        console.log("efetiarPagamento");
        this._lancamentosService.efetivarPagamento(lancamento.id).subscribe(() =>{
            this.analisar();
            this._toast.showNotification("top", "center", $, 2, "Pagamento", "Efetivado com sucesso" );
        })
    }

    pesquisarTotalLancamentos(){
        this._lancamentosService.pesquisarTotalLancamentoEmAbertoPorMesReferencia(this.mesReferencia).
            map(response => response.json()).
            subscribe(response => {
                this.totalLancamentoEmAberto = response;
            });

        this._lancamentosService.pesquisarTotalLancamentoPagosPorMesReferencia(this.mesReferencia).
            map(response => response.json()).
            subscribe(response => {
                this.totalLancamentosPagos = response;
            });
    }
}