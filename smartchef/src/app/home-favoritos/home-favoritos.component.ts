import { Component, OnInit } from '@angular/core';
import {BarraNavegacionComponent} from "../barra-navegacion/barra-navegacion.component";
import {IonButton, IonContent, IonIcon} from "@ionic/angular/standalone";
import {Router} from "@angular/router";

@Component({
    selector: 'app-home-favoritos',
    templateUrl: './home-favoritos.component.html',
    styleUrls: ['./home-favoritos.component.scss'],
    standalone: true,
    imports: [
        BarraNavegacionComponent,
        IonButton,
        IonContent,
        IonIcon
    ]
})
export class HomeFavoritosComponent {

  // eslint-disable-next-line @angular-eslint/prefer-inject
  constructor(private router : Router) {

  }


}
