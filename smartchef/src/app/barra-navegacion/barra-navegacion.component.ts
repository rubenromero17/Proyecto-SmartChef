import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { IonButton, IonFooter, IonIcon, IonToolbar } from '@ionic/angular/standalone';

@Component({
  selector: 'app-barra-navegacion',
  standalone: true,
  imports: [IonButton, IonIcon, IonToolbar, IonFooter],
  templateUrl: './barra-navegacion.component.html',
  styleUrls: ['./barra-navegacion.component.scss'],
})
export class BarraNavegacionComponent {
  activo: string = '';

  // eslint-disable-next-line @angular-eslint/prefer-inject
  constructor(public router: Router) {}

  irAfavoritosDesdeHome(){
    this.router.navigate(['/irAfavoritosDesdeHome'])
  }

  irAperfilDesdeHome(){
    this.router.navigate(['/irAperfilDesdeHome'])
  }

  irAbuscarDesdeHome(){
    this.router.navigate(['/irAbuscarDesdeHome'])
  }

  irAhomeDesdeHome(){
    this.router.navigate(['/irAhomeDesdeHome'])
  }

}
