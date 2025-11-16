import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-tarjeta-chef',
  templateUrl: './tarjeta-chef.component.html',
  styleUrls: ['./tarjeta-chef.component.scss']
})
export class TarjetaChefComponent {
  @Input() nombre: string = 'Chef';
  @Input() recetas: number = 0;
  @Input() favoritos: number = 0;
  @Input() semana: number = 0;

  // eslint-disable-next-line @angular-eslint/prefer-inject
  constructor(private router: Router) {}


  editarPerfil(){
    this.router.navigate(['editarPerfil']);
  }
}
