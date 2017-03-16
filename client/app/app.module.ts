import {Component, NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {AppComponent} from './app.component';
import {ListagemLancamentoComponent} from './listagem_lancamento/listagem.lancamento.component';


@NgModule({
    imports: [BrowserModule],
    declarations: [AppComponent, ListagemLancamentoComponent],
    bootstrap:[AppComponent]
})
export class AppModule{

}