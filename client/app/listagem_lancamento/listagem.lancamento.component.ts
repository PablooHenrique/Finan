import {Component} from '@angular/core';


@Component({
    moduleId : module.id,
    selector: 'ListagemLancamento',
    templateUrl: './listagem.lancamento.html'
})
export class ListagemLancamentoComponent{
    lancamentos : object[] = [];

    constructor(){
        this.lancamentos=[{data:'14/03/2017', descricao: 'Futebol', valor:10.00}, {data:'15/03/2017', descricao: 'Caneca', valor:20.00}]
    }

    
}