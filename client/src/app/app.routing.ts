import { Routes } from '@angular/router';

import { DashboardComponent }   from './dashboard/dashboard.component';
import { LancamentosComponent } from './lancamentos/lancamentos.component';
import { CadastroLancamentoComponent } from './lancamentos/cadastro/lancamento.cadastro.component';
import { AnaliseMensalComponent } from './analise-mensal/analise.mensal.component';

export const AppRoutes: Routes = [
    {
        path: '',
        redirectTo: 'dashboard',
        pathMatch: 'full',
    },
    {
        path: 'dashboard',
        component: DashboardComponent
    },
    {
        path: 'lancamentos',
        component: LancamentosComponent
    },
    {
        path: 'lancamentos/cadastro-lancamento',
        component: CadastroLancamentoComponent
    },
    {
        path: 'analise-mensal',
        component: AnaliseMensalComponent
    }

]
