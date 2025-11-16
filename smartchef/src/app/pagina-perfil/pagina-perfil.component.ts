import { Component, OnInit } from '@angular/core';
import {BarraNavegacionComponent} from "../barra-navegacion/barra-navegacion.component";
import {TarjetaChefComponent} from "../tarjeta-chef/tarjeta-chef.component";
import {IonContent, IonIcon} from "@ionic/angular/standalone";
import {Router} from "@angular/router";

@Component({
  selector: 'app-pagina-perfil',
  templateUrl: './pagina-perfil.component.html',
  styleUrls: ['./pagina-perfil.component.scss'],
  standalone: true,
  imports: [
    BarraNavegacionComponent,
    TarjetaChefComponent,
    IonContent,
    IonIcon
  ]
})
export class PaginaPerfilComponent {

  // eslint-disable-next-line @angular-eslint/prefer-inject
  constructor(private router : Router) {


  }
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
