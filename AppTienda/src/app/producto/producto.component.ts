import { Component, OnInit } from '@angular/core';
import { HttpServiceService } from '../Services/http-service.service';
import { generate, Observable  } from 'rxjs';
import { FormArray, FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { map, startWith, debounceTime} from 'rxjs/operators';
import { Videojuego, VideojuegoLista } from '../Models/Videojuego';
import { ActivatedRoute } from '@angular/router';
import { FilterContent } from '../Models/Filter';


@Component({
  selector: 'app-producto',
  templateUrl: './producto.component.html',
  styleUrls: ['./producto.component.css']
})
export class ProductoComponent implements OnInit {
  myControl = new FormControl();
  videojuegos: Videojuego[] = [];
  filteredOptions: Observable<Videojuego[]> = null;
  LoadedOption:boolean =true;
  filtercontent: FilterContent;
  nestedForm: FormGroup;
  generolist = ['200', '201', '204', '205', '206', '207', '208', '209', '210', '211', '212', '213', '214', '215', '216'];
  generos=  ['Action', 'Adventure', 'RPG', 'Indie', 'Shooter', 'Simulation', 'Sports', 'Racing', 'Strategy', 'Combat', 'Battle Royale', 'Platform', 'Survival', 'Horror', 'Anime'];
  lenguajelist=['300', '301', '302', '303', '304', '305', '306', '307', '308'];
  lenguajes= ['Español', 'English', 'Deutsch', 'Japanese', 'Chinese', 'Francois', 'Portugués', 'Italiano', 'Russian'];
  constructor(private httpService:HttpServiceService,private route:ActivatedRoute,private formbuilder: FormBuilder) {
    this.filtercontent= {
      genre: [],
      language: [],
    }
    this.httpService.VideojuegogetFilter(this.filtercontent).pipe(
    )
      .subscribe(data=>{
        {
          console.log(data);
          this.videojuegos=data.listaVideojuego;
          console.log(data);
        }
      });
  }


  ngOnInit(): void {
    this.nestedForm = this.formbuilder.group({
      generovideojuego: this.addGenresControls(),
      lenguajevideojuego: this.addLanguageControls(),
    });

    this.filteredOptions = this.myControl.valueChanges.pipe(
      startWith(''),
      debounceTime(1000),
      map(value => this._filter(value))) ;
  }
  private _filter(value: string): Videojuego[] {
    const filterValue = value.toLowerCase();

    return this.videojuegos.filter((videojuego) => videojuego.titulo.toLowerCase().includes(filterValue));
  }

  addGenresControls(){
    const arr = this.generos.map(element =>{
      return this.formbuilder.control(false);
    });
    return this.formbuilder.array(arr);
  }
  addLanguageControls(){
    const arr = this.lenguajes.map(element =>{
      return this.formbuilder.control(false);
    });
    return this.formbuilder.array(arr);
  }
  get selectedGenres(){
    return <FormArray>this.nestedForm.get('generovideojuego');
  }
  get selectedLanguages(){
    return <FormArray>this.nestedForm.get('lenguajevideojuego');
  }
  getSelectedGenre(){
    this.filtercontent.genre = [];
    this.selectedGenres.controls.forEach((control,i)=>{
      if(control.value){
        this.filtercontent.genre.push(this.generolist[i]);
      }
    });
    console.log(this.filtercontent.genre)
    this.httpService.VideojuegogetFilter(this.filtercontent)
    .subscribe(data=>{
      this.videojuegos=data.listaVideojuego;
    });
    this.myControl.setValue("");
  }
  getSelectedLanguage(){
    this.filtercontent.language = [];
    this.selectedLanguages.controls.forEach((control,i)=>{
      if(control.value){
        this.filtercontent.language.push(this.lenguajelist[i]);
      }
    });
    console.log(this.filtercontent.language)
    this.httpService.VideojuegogetFilter(this.filtercontent)
    .subscribe(data=>{
      this.videojuegos=data.listaVideojuego;
    });
    this.myControl.setValue("");
  }
  

}
