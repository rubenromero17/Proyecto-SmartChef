import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: 'inicio',
    loadComponent: () =>
      import('./inicio/inicio.component').then((m) => m.InicioPage),
  },
  {
    path: 'registro',
    loadComponent: () =>
      import('./registro/registro.component').then((m) => m.RegistroComponent),
  },
  {
    path: 'volverAtras',
    loadComponent: () =>
      import('./inicio/inicio.component').then((m) => m.InicioPage),
  },
  {
    path: 'irAhome',
    loadComponent: () =>
      import('./home/home.component').then((m) => m.HomeComponent),
  },
  {
    path: 'irAinicioDesdeHome',
    loadComponent: () =>
      import('./inicio/inicio.component').then((m) => m.InicioPage),
  },
  {
    path: 'irAinicioDesdeFavoritos',
    loadComponent: () =>
      import('./inicio/inicio.component').then((m) => m.InicioPage),
  },
  {
    path: 'irAfavoritosDesdeHome',
    loadComponent: () =>
      import('./favoritos/favoritos.component').then((m) => m.FavoritosComponent),
  },
  {
    path: 'irAfavoritosHomeDesdeHome',
    loadComponent: () =>
      import('./home-favoritos/home-favoritos.component').then((m) => m.HomeFavoritosComponent),
  },
  {
    path: '',
    redirectTo: 'inicio',
    pathMatch: 'full',
  },
];
