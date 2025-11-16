import { Component, OnInit } from '@angular/core';
import {BarraNavegacionComponent} from "../barra-navegacion/barra-navegacion.component";
import {IonButton, IonCard, IonCardContent, IonContent, IonIcon, IonItem, IonLabel} from "@ionic/angular/standalone";
import {Router} from "@angular/router";

@Component({
  selector: 'app-pagina-edita-perfil',
  templateUrl: './pagina-edita-perfil.component.html',
  styleUrls: ['./pagina-edita-perfil.component.scss'],
  standalone: true,
  imports: [
    BarraNavegacionComponent,
    IonLabel,
    IonItem,
    IonCardContent,
    IonCard,
    IonIcon,
    IonButton,
    IonContent
  ]
})
export class PaginaEditaPerfilComponent {

  // eslint-disable-next-line @angular-eslint/prefer-inject
  constructor(private router: Router) { }


}
