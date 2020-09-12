export class Videojuego{
    idvideojuego?:String ;
    titulo?:String;
	precio?:Number ;
	fecha_lanzamiento?:String;
    desarrolladora?:String;
    urlimg?:String;
}
export class VideojuegoLista{
    constructor(){
        this.listaVideojuego = new Array<Videojuego>();
    }
    listaVideojuego?: Videojuego[];
}