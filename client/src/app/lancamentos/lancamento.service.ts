import { Injectable } from '@angular/core';
import { Component } from '@angular/core/src/metadata/directives';
import { Http, Headers} from '@angular/http';
import { LancamentoDomain } from './lancamento.domain';

@Injectable()
export class LancamentoService{
    private baseUrl : string = "http://localhost:8080/lancamentos"

    constructor(private _http : Http){}

    public listar(){
        let url = this.baseUrl;
        return this._http.get(url);
    }

    public pesquisarPorId(id){
        let url = this.baseUrl +"/"+id;
        return this._http.get(url)
    }

    public salvar(lancamento : LancamentoDomain){
        let headers = new Headers();
        headers.append('Content-Type', 'application/json')

        let url = this.baseUrl;
        return this._http.post(url, JSON.stringify(lancamento), {headers});
    }

    public atualizar(lancamento : LancamentoDomain){
        let headers = new Headers();
        headers.append('Content-Type', 'application/json')

        let url = this.baseUrl+"/"+lancamento.id;
        return this._http.put(url, JSON.stringify(lancamento), {headers});
    }

    public deletar(id){
        let headers = new Headers();
        headers.append('Content-Type', 'application/json')

        let url = this.baseUrl+"/"+id;
        return this._http.delete(url, {headers});
    }
}