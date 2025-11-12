import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import {RouterModule} from '@angular/router';
import { IonicModule } from '@ionic/angular';
import {bootstrapApplication} from "@angular/platform-browser";



@Component({
  selector: 'app-inicio',
  standalone : true,
  imports:[CommonModule, RouterModule, IonicModule],
  templateUrl: './inicio.component.html',
  styleUrls: ['./inicio.component.scss'],
})
export class InicioPage {

  // eslint-disable-next-line @angular-eslint/prefer-inject
  constructor(public router: Router) {}

  iniciarSesion() {
    console.log('Iniciando sesión...');
  }

  irARegistro() {
    this.router.navigate(['/registro']);
  }
  irAhome(){
    this.router.navigate(['/irAhome']);
  }

}
