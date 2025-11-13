import { Component, OnInit } from '@angular/core';
import {IonButton} from "@ionic/angular/standalone";
import {Router} from "@angular/router";

@Component({
  selector: 'app-filtros-home',
  templateUrl: './filtros-home.component.html',
  styleUrls: ['./filtros-home.component.scss'],
  standalone: true,
  imports: [
    IonButton
  ]
})
export class FiltrosHomeComponent{

  // eslint-disable-next-line @angular-eslint/prefer-inject
  constructor(public router: Router) {

  }

  filtroTendencias(){
    this.router.navigate(['filtroTendencias']);
  }
  filtroRecientes(){
    this.router.navigate(['filtroRecientes']);
  }
  filtroFavoritos(){
    this.router.navigate(['filtroFavoritos']);
  }



}
