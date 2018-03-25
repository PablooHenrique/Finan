import { Component } from '@angular/core';
import { LancamentoDomain } from './lancamento.domain';
import { LancamentoService } from './lancamento.service';
import { Router } from '@angular/router';

@Component({
    selector: 'lancamento.component',
    templateUrl: 'lancamentos.component.html',
    moduleId: module.id
})
export class LancamentosComponent{
    public tableHeader;
    public lancamentos : LancamentoDomain[]; 
    public mesReferencia : number;

    constructor(private _lancamentoService : LancamentoService, private _router : Router){
        let data = new Date();
        this.mesReferencia = data.getMonth() + 1;

        this.consultarLancamentos();
        this.inicializarTableHeader();
    }

    inicializarTableHeader(){
        this.tableHeader = ["Id", "Descrição", "Mês Referência", "Valor", "Tipo", "Status", ""]
    }

    consultarLancamentos(){
        this._lancamentoService.pesquisarLancamentosPorMesReferencia(this.mesReferencia)
        .map(response => response.json())
        .subscribe(response =>{
            this.lancamentos = response;
        }, error => {
            console.log("Erro : " + error);
        });
    }

    exibirDetalhes(id){
        this._router.navigate(['lancamentos/cadastro-lancamento', {idLancamento : id}])
    }

    deletar(id){
        this._lancamentoService.deletar(id).subscribe(()=>{
            this.consultarLancamentos();
        });
    }

    consultarDebitos(){
        this._lancamentoService.pesquisarDebitosPorMesReferencia(this.mesReferencia)
            .map(response => response.json())
            .subscribe(response => this.lancamentos = response);
    }

    consultarCreditos(){
        this._lancamentoService.pesquisarCreditosPorMesReferencia(this.mesReferencia)
            .map(response => response.json())
            .subscribe(response => this.lancamentos = response);
    }
}