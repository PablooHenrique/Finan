import { Component, OnInit } from '@angular/core';
import { LancamentoDomain } from '../lancamento.domain';
import { LancamentoService } from '../lancamento.service';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
    templateUrl: 'lancamento.cadastro.component.html',
    selector: 'lancamento.cadastro',
    moduleId: module.id
})

export class CadastroLancamentoComponent implements OnInit{
    public lancamento : LancamentoDomain;
    public id : number = 0; 
    public insertProcess : boolean = false;

    constructor(private _lancamentoService : LancamentoService
              , private _activatedRouter : ActivatedRoute
              , private _router : Router){
        this.lancamento = new LancamentoDomain();
        
    }

    ngOnInit(){
        let id = this._activatedRouter.snapshot.paramMap.get("idLancamento");
        if(id != null){
            this.insertProcess = false;
            this._lancamentoService.pesquisarPorId(id)
                .map(response => response.json())
                .subscribe(response =>{ 
                    this.lancamento = response;
                });
        }else{
            this.insertProcess = true;
        }
    }

    salvar(){
        if (this.lancamento.id > 0) {
            this.editar();
        } else {
            this._lancamentoService.salvar(this.lancamento).subscribe(()=>{
                console.log("Sucess")
            }, error =>{
                console.log(error)
            }) ;
        }
    }

    editar(){
        this._lancamentoService.atualizar(this.lancamento)
            .subscribe(()=>{
                this.insertProcess = false;
                console.log("Sucess")
            }, error =>{
                console.log(error)
            }) ;
    }

    habilitarEdicao(){
        this.insertProcess = true;
    }
}