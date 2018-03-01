import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { AppRoutes } from './app.routing';
import { SidebarModule } from './sidebar/sidebar.module';
import { FooterModule } from './shared/footer/footer.module';
import { NavbarModule} from './shared/navbar/navbar.module';
import { FixedPluginModule} from './shared/fixedplugin/fixedplugin.module';
import { NguiMapModule} from '@ngui/map';

import { DashboardComponent }   from './dashboard/dashboard.component';
import { TypographyComponent }   from './typography/typography.component';

import { LancamentosComponent } from './lancamentos/lancamentos.component';
import { CadastroLancamentoComponent } from './lancamentos/cadastro/lancamento.cadastro.component';

import { AnaliseMensalComponent } from './analise-mensal/analise.mensal.component';


import { LancamentoService } from './lancamentos/lancamento.service';

import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';

/** Import do RxJs */
import 'rxjs/add/operator/map';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    TypographyComponent,
    LancamentosComponent,
    CadastroLancamentoComponent,
    AnaliseMensalComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(AppRoutes),
    SidebarModule,
    NavbarModule,
    FooterModule,
    FixedPluginModule,
    HttpModule,
    FormsModule,
    NguiMapModule.forRoot({apiUrl: 'https://maps.google.com/maps/api/js?key=YOUR_KEY_HERE'})

  ],
  providers: [LancamentoService],
  bootstrap: [AppComponent]
})
export class AppModule { }
