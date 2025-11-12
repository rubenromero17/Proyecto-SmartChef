import { Component, OnInit } from '@angular/core';
import {IonButton, IonCard, IonCardContent, IonCol, IonContent, IonGrid, IonIcon, IonInput, IonItem, IonLabel, IonRow} from "@ionic/angular/standalone";
import {Router} from "@angular/router";
@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.scss'],
  standalone: true,
  imports: [
    IonIcon,
    IonButton,
    IonItem,
    IonLabel,
    IonInput,
    IonContent,
    IonRow,
    IonCol,
    IonGrid,
    IonCardContent,
    IonCard
  ]
})
export class RegistroComponent {

  // eslint-disable-next-line @angular-eslint/prefer-inject
  constructor( private router: Router) {
  }

  volverInicio():void {
    this.router.navigate(['/volverAtras']);
  }


}
