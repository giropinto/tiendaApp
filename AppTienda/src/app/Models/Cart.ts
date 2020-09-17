export class SellCart{
    productId?: String[];
    totalprice?: Totalprice;
    constructor(){
    }
}
export class Totalprice{
    amount? : number;
    currency?: string;
    isEmpty?: boolean;
}