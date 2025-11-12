import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import {
  IonButton,
  IonCard,
  IonCol,
  IonContent,
  IonFooter,
  IonIcon,
  IonRow,
  IonToolbar
} from '@ionic/angular/standalone';
import {Router} from "@angular/router";
import {BarraNavegacionComponent} from "../barra-navegacion/barra-navegacion.component";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
  standalone: true,
  imports: [
    CommonModule,
    IonIcon,
    IonButton,
    IonToolbar,
    IonFooter,
    IonCard,
    IonRow,
    IonCol,
    IonContent,
    BarraNavegacionComponent
  ]
})
export class HomeComponent {

  // eslint-disable-next-line @angular-eslint/prefer-inject
  constructor(public router: Router) {}

}
