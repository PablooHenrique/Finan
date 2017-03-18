import {Component, NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {AppComponent} from './app.component';
import {ListagemLancamentoComponent} from './listagem_lancamento/listagem.lancamento.component';
import {CadastroLancamentoCompoent} from './cadastro.lancamentos/cadastro.lancamentos.component'
import {routing} from './app.routes'
import {FiltroPorDescricao} from './listagem_lancamento/lancamentos.pipe'
import {HttpModule} from '@angular/http'


@NgModule({
    imports: [BrowserModule, routing, HttpModule],
    declarations: [AppComponent, ListagemLancamentoComponent, CadastroLancamentoCompoent, FiltroPorDescricao],
    bootstrap:[AppComponent]
})
export class AppModule{

}