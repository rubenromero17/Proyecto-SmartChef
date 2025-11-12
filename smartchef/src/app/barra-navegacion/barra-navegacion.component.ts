import { Component } from '@angular/core';
import { IonicModule } from '@ionic/angular';
import {Router} from "@angular/router";
import {IonButton, IonFooter, IonIcon, IonToolbar} from "@ionic/angular/standalone";

@Component({
  selector: 'app-barra-navegacion',
  standalone: true,
  imports: [IonicModule,IonButton,IonIcon,IonToolbar,IonFooter],
  templateUrl: './barra-navegacion.component.html',
  styleUrls: ['./barra-navegacion.component.scss'],
})
export class BarraNavegacionComponent {

  public activeButton: string = 'home';

  // eslint-disable-next-line @angular-eslint/prefer-inject
  constructor(public router: Router) {
  }
 public setActive(button: string) {
    this.activeButton = button;

  }
}
