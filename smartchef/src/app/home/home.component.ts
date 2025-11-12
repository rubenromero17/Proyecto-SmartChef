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
    IonCard,
    IonRow,
    IonCol,
    IonContent,
    BarraNavegacionComponent
  ]
})
export class HomeComponent {
  favorito1 = false;
  favorito2 = false;
  favorito3 = false;

  toggleFavorito(num: number) {
    if (num === 1) this.favorito1 = !this.favorito1;
    if (num === 2) this.favorito2 = !this.favorito2;
    if (num === 3) this.favorito3 = !this.favorito3;
  }


  // eslint-disable-next-line @angular-eslint/prefer-inject
  constructor(public router: Router) {}

  irAinicioDesdeHome(){
    this.router.navigate(['/irAinicioDesdeHome']);
  }
  irAfavoritosHomeDesdeHome(){
    this.router.navigate(['/irAfavoritosHomeDesdeHome']);
  }
}
