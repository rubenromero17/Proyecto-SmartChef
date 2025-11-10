import { Routes } from '@angular/router';
import {RegistroComponent} from "./registro/registro.component";

export const routes: Routes = [
  {
    path: 'inicio',
    loadComponent: () =>
      import('./inicio/inicio.component').then((m) => m.InicioPage),
  },
  {
  path: 'registro',
    loadComponent: () =>
      import('./registro/registro.component').then(m => m.RegistroComponent),
  },
  {
    path: '',
    redirectTo: 'inicio',
    pathMatch: 'full',
  },
];
