import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {BarraNavegacionComponent} from "../barra-navegacion/barra-navegacion.component";
import {IonContent, IonIcon} from "@ionic/angular/standalone";

@Component({
  selector: 'app-favoritos-colecciones',
  templateUrl: './favoritos-colecciones.component.html',
  styleUrls: ['./favoritos-colecciones.component.scss'],
  standalone: true,
  imports: [
    BarraNavegacionComponent,
    IonContent,
    IonIcon
  ]
})
export class FavoritosColeccionesComponent {

  // eslint-disable-next-line @angular-eslint/prefer-inject
  constructor(private router :Router) { }

  irAinicioDesdeFavoritos(){
    this.router.navigate(['/irAinicioDesdeFavoritos']);
  }
  favoritosColecciones(){
    this.router.navigate(['/favoritosColecciones']);
  }
  coleccionesFavoritos(){
    this.router.navigate(['/coleccionesFavoritos']);
  }

}
