"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = require("@angular/core");
var platform_browser_1 = require("@angular/platform-browser");
var app_component_1 = require("./app.component");
var listagem_lancamento_component_1 = require("./listagem_lancamento/listagem.lancamento.component");
var cadastro_lancamentos_component_1 = require("./cadastro.lancamentos/cadastro.lancamentos.component");
var app_routes_1 = require("./app.routes");
var lancamentos_pipe_1 = require("./listagem_lancamento/lancamentos.pipe");
var http_1 = require("@angular/http");
var AppModule = (function () {
    function AppModule() {
    }
    return AppModule;
}());
AppModule = __decorate([
    core_1.NgModule({
        imports: [platform_browser_1.BrowserModule, app_routes_1.routing, http_1.HttpModule],
        declarations: [app_component_1.AppComponent, listagem_lancamento_component_1.ListagemLancamentoComponent, cadastro_lancamentos_component_1.CadastroLancamentoCompoent, lancamentos_pipe_1.FiltroPorDescricao],
        bootstrap: [app_component_1.AppComponent]
    })
], AppModule);
exports.AppModule = AppModule;
//# sourceMappingURL=app.module.js.map