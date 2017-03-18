import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
    name: 'filtroPorDescricao'
})
export class FiltroPorDescricao implements PipeTransform{
    transform(lancamentos, digitado: string){
        digitado = digitado.toLowerCase();
        return lancamentos.filter(lancamento => lancamento.descricao.toLowerCase().includes(digitado))
    }
}