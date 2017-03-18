"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var router_1 = require("@angular/router");
var listagem_lancamento_component_1 = require("./listagem_lancamento/listagem.lancamento.component");
var cadastro_lancamentos_component_1 = require("./cadastro.lancamentos/cadastro.lancamentos.component");
var appRoutes = [
    { path: '', component: listagem_lancamento_component_1.ListagemLancamentoComponent },
    { path: 'cadastro', component: cadastro_lancamentos_component_1.CadastroLancamentoCompoent },
    { path: '**', redirectTo: '' }
];
exports.routing = router_1.RouterModule.forRoot(appRoutes);
//# sourceMappingURL=app.routes.js.map