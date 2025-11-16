import { Component, OnInit } from '@angular/core';
import {BarraNavegacionComponent} from "../barra-navegacion/barra-navegacion.component";
import {IonContent, IonIcon} from "@ionic/angular/standalone";
import {TarjetaChefComponent} from "../tarjeta-chef/tarjeta-chef.component";
import {Router} from "@angular/router";

@Component({
  selector: 'app-perfil-historial',
  templateUrl: './perfil-historial.component.html',
  styleUrls: ['./perfil-historial.component.scss'],
  standalone: true,
  imports: [
    BarraNavegacionComponent,
    IonContent,
    IonIcon,
    TarjetaChefComponent
  ]
})
export class PerfilHistorialComponent{

  // eslint-disable-next-line @angular-eslint/prefer-inject
  constructor(private router : Router) { }

  perfilHistorial(){
    this.router.navigate(['/perfilHistorial']);
  }
  perfilEstadisticas(){
    this.router.navigate(['/perfilEstadisticas']);
  }
  perfilCompras(){
    this.router.navigate(['/perfilCompras']);
  }


}
