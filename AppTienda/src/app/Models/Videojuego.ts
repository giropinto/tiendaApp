export class Videojuego{
    idvideojuego?: string ;
    titulo?: string;
    precio?: number ;
  // tslint:disable-next-line:variable-name
    fecha_lanzamiento?: string;
    desarrolladora?: string;
    urlimg?: string;
}
export class VideojuegoLista{
    constructor(){
        this.listaVideojuego = new Array<Videojuego>();
    }
    listaVideojuego?: Videojuego[];
}

export class LGDto{
    lenguaje?: string[];
    genero?: string[];
}
