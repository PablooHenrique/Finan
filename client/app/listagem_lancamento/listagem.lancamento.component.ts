import {Component} from '@angular/core';
import {Http} from '@angular/http'


@Component({
    moduleId : module.id,
    selector: 'ListagemLancamento',
    templateUrl: './listagem.lancamento.html'
})
export class ListagemLancamentoComponent{
    lancamentos : object[] = [];

    constructor(http: Http){
        let stream = http.get('http://localhost:8080/lancamentos');
        stream.subscribe(res=>console.log(res.json()));

        this.lancamentos=[{data:'14/03/2017', descricao: 'Futebol', valor:10.00}, {data:'15/03/2017', descricao: 'Caneca', valor:20.00}]
    }    
}