export class SellCart{
    productId?: string[];
    totalprice?: Totalprice;
    constructor(){
    }
}
export class Totalprice{
    amount? : number;
    currency?: string;
    isEmpty?: boolean;
}