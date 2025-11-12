import { Component, OnInit } from '@angular/core';
import {IonButton, IonContent, IonIcon} from "@ionic/angular/standalone";
import {BarraNavegacionComponent} from "../barra-navegacion/barra-navegacion.component";
import {Router} from "@angular/router";

@Component({
  selector: 'app-favoritos',
  templateUrl: './favoritos.component.html',
  styleUrls: ['./favoritos.component.scss'],
  standalone: true,
  imports: [
    IonIcon,
    BarraNavegacionComponent,
    IonButton,
    IonContent
  ]
})
export class FavoritosComponent {

  // eslint-disable-next-line @angular-eslint/prefer-inject
  constructor(public router: Router) { }

  irAinicioDesdeFavoritos(){
    this.router.navigate(['/irAinicioDesdeFavoritos']);
  }


}
