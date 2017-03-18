"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = require("@angular/core");
var FiltroPorDescricao = (function () {
    function FiltroPorDescricao() {
    }
    FiltroPorDescricao.prototype.transform = function (lancamentos, digitado) {
        digitado = digitado.toLowerCase();
        return lancamentos.filter(function (lancamento) { return lancamento.descricao.toLowerCase().includes(digitado); });
    };
    return FiltroPorDescricao;
}());
FiltroPorDescricao = __decorate([
    core_1.Pipe({
        name: 'filtroPorDescricao'
    })
], FiltroPorDescricao);
exports.FiltroPorDescricao = FiltroPorDescricao;
//# sourceMappingURL=lancamentos.pipe.js.map