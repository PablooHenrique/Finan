"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = require("@angular/core");
var http_1 = require("@angular/http");
var ListagemLancamentoComponent = (function () {
    function ListagemLancamentoComponent(http) {
        this.lancamentos = [];
        var stream = http.get('http://localhost:8080/lancamentos');
        stream.subscribe(function (res) { return console.log(res.json()); });
        this.lancamentos = [{ data: '14/03/2017', descricao: 'Futebol', valor: 10.00 }, { data: '15/03/2017', descricao: 'Caneca', valor: 20.00 }];
    }
    return ListagemLancamentoComponent;
}());
ListagemLancamentoComponent = __decorate([
    core_1.Component({
        moduleId: module.id,
        selector: 'ListagemLancamento',
        templateUrl: './listagem.lancamento.html'
    }),
    __metadata("design:paramtypes", [http_1.Http])
], ListagemLancamentoComponent);
exports.ListagemLancamentoComponent = ListagemLancamentoComponent;
//# sourceMappingURL=listagem.lancamento.component.js.map