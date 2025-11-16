import { Component, OnInit } from '@angular/core';
import {IonButton, IonContent, IonIcon} from "@ionic/angular/standalone";
import {Router} from "@angular/router";
import {BarraNavegacionComponent} from "../barra-navegacion/barra-navegacion.component";

@Component({
  selector: 'app-receta-mas-info',
  templateUrl: './receta-mas-info.component.html',
  styleUrls: ['./receta-mas-info.component.scss'],
  standalone: true,
  imports: [
    IonButton,
    IonIcon,
    IonContent,
    BarraNavegacionComponent
  ]
})
export class RecetaMasInfoComponent  {

  // eslint-disable-next-line @angular-eslint/prefer-inject
  constructor(private router : Router) {

  }
  cambiarAInstrucciones(){
    this.router.navigate(['cambiarAInstrucciones']);
  }
  cambiarAIngredientes(){
    this.router.navigate(['cambiarAIngredientes']);
  }





}
