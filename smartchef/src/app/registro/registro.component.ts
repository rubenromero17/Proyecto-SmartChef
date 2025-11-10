import { Component, OnInit } from '@angular/core';
import {IonButton, IonContent, IonIcon, IonInput, IonItem, IonLabel} from "@ionic/angular/standalone";

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
    IonContent
  ]
})
export class RegistroComponent {

  constructor() { }


}
