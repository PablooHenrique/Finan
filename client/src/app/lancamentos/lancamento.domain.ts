export class LancamentoDomain{
    constructor(public id : number = 0, 
                public descricao : string = "", 
                public mesReferencia : number = 0,
                public tipo : string = "",
                public valor : number = 0,
                public status : string = ""
                ){}
}