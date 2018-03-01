import { Component } from '@angular/core';

@Component({
    selector : 'analise.mensal.component',
    templateUrl : 'analise.mensal.component.html',
    moduleId : module.id
})
export class AnaliseMensalComponent {
    public tableHeader = [];

    constructor(){
        this.tableHeader = ["Id", "Descrição", "Mês Referência", "Valor", "Tipo", "Status", ""]
    }
}