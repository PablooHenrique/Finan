export class LancamentoDomain{
    constructor(public id : number = 0, 
                public titulo : string = "", 
                public detalhes : string = "", 
                public mesReferencia : number = 0,
                public tipo : string = "",
                public valorPrevisto : number = 0,
                public valorEfetuado : number = 0,
                public status : string = ""
                ){}
}
