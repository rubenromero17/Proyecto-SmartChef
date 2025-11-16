import { Component, OnInit } from '@angular/core';
import {BarraNavegacionComponent} from "../barra-navegacion/barra-navegacion.component";
import {IonContent, IonIcon} from "@ionic/angular/standalone";
import {Router} from "@angular/router";

@Component({
  selector: 'app-recetas-instrucciones',
  templateUrl: './recetas-instrucciones.component.html',
  styleUrls: ['./recetas-instrucciones.component.scss'],
  standalone: true,
  imports: [
    BarraNavegacionComponent,
    IonContent,
    IonIcon
  ]
})
export class RecetasInstruccionesComponent {

  // eslint-disable-next-line @angular-eslint/prefer-inject
  constructor(private router : Router) { }

  cambiarAInstrucciones(){
    this.router.navigate(['cambiarAInstrucciones']);
  }
  cambiarAIngredientes(){
    this.router.navigate(['cambiarAIngredientes']);
  }
  irAhomeDesdeHome(){
    this.router.navigate(['irAhomeDesdeHome']);
  }


}
