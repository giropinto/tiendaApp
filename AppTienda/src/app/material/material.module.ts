import { NgModule } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import {MatAutocompleteModule} from '@angular/material/autocomplete';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
const MaterialComponents =[
  MatAutocompleteModule,
  MatButtonModule,
  MatFormFieldModule,
  MatInputModule
];

@NgModule({
  
  imports: [ MaterialComponents],
  exports: [MaterialComponents]
 
})
export class MaterialModule { }
