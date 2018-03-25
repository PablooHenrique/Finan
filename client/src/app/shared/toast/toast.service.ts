import { Injectable } from "@angular/core";

@Injectable()
export class ToastService{
    showNotification(from, align, $, colorNumber, mensagemDestaque, mensagemPadrao){
        var type = ['','info','success','warning','danger'];
        var color = colorNumber;

    	$.notify({
        	message: "<b>"+mensagemDestaque+"</b> - " +mensagemPadrao+"."
        },{
            type: type[color],
            timer: 4000,
            placement: {
                from: from,
                align: align
            }
        });
    }
}