import {RouterModule, Routes} from '@angular/router';
import {ListagemLancamentoComponent} from './listagem_lancamento/listagem.lancamento.component';
import {CadastroLancamentoCompoent} from './cadastro.lancamentos/cadastro.lancamentos.component';

const appRoutes: Routes = [
    {path:'', component: ListagemLancamentoComponent},
    {path:'cadastro', component: CadastroLancamentoCompoent},
    { path: '**', redirectTo: ''}
]

export const routing = RouterModule.forRoot(appRoutes);