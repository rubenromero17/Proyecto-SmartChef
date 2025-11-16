import { Component, OnInit } from '@angular/core';
import {BarraNavegacionComponent} from "../barra-navegacion/barra-navegacion.component";
import {IonContent, IonIcon} from "@ionic/angular/standalone";
import {Router} from "@angular/router";

@Component({
    selector: 'app-home-recientes',
    templateUrl: './home-recientes.component.html',
    styleUrls: ['./home-recientes.component.scss'],
    standalone: true,
    imports: [
        BarraNavegacionComponent,
        IonContent,
        IonIcon
    ]
})
export class HomeRecientesComponent {

  // eslint-disable-next-line @angular-eslint/prefer-inject
  constructor(private router : Router) { }

  filtroFavoritos(){
    this.router.navigate(['/filtroFavoritos']);
  }
  filtroRecientes(){
    this.router.navigate(['/filtroRecientes']);
  }
  masInfoRecetas(){
    this.router.navigate(['/masInfoRecetas']);
  }
  filtroTendencias(){
    this.router.navigate(['/filtroTendencias']);
  }

}
