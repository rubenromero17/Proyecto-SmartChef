import { Routes } from '@angular/router';
import {PaginaPerfilComponent} from "./pagina-perfil/pagina-perfil.component";

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
    path: 'irAperfilDesdeHome',
    loadComponent: () =>
      import('./pagina-perfil/pagina-perfil.component').then((m) => m.PaginaPerfilComponent),
  },
  {
    path: 'irAbuscarDesdeHome',
    loadComponent: () =>
      import('./pagina-buscar/pagina-buscar.component').then((m) => m.PaginaBuscarComponent),
  },{
    path: 'irAhomeDesdeHome',
    loadComponent: () =>
      import('./home/home.component').then((m) => m.HomeComponent),
  },
  {
    path: 'filtroTendencias',
    loadComponent: () =>
      import('./home/home.component').then((m) => m.HomeComponent),
  },
  {
    path: 'filtroRecientes',
    loadComponent: () =>
      import('./home-recientes/home-recientes.component').then((m) => m.HomeRecientesComponent),
  },
  {
    path: 'filtroFavoritos',
    loadComponent: () =>
      import('./home-favoritos/home-favoritos.component').then((m) => m.HomeFavoritosComponent),
  },
  {
    path: 'perfilHistorial',
    loadComponent: () =>
      import('./perfil-historial/perfil-historial.component').then((m)=> m.PerfilHistorialComponent)
  },
  {
    path: 'perfilEstadisticas',
    loadComponent: () =>
      import('./pagina-perfil/pagina-perfil.component').then((m) => m.PaginaPerfilComponent),
  },
  {
    path: 'perfilCompras',
    loadComponent: () =>
      import('./perfil-compras/perfil-compras.component').then((m) => m.PerfilComprasComponent),
  },
  {
    path: 'editarPerfil',
    loadComponent: () =>
      import('./pagina-edita-perfil/pagina-edita-perfil.component').then((m)=>m.PaginaEditaPerfilComponent)
  },
  {
    path: 'masInfoRecetas',
    loadComponent: () =>
      import('./receta-mas-info/receta-mas-info.component').then((m) => m.RecetaMasInfoComponent),
  },
  {
    path: 'favoritosColecciones',
    loadComponent: () =>
      import('./favoritos-colecciones/favoritos-colecciones.component').then((m) => m.FavoritosColeccionesComponent),
  },
  {
    path: 'coleccionesFavoritos',
    loadComponent: () =>
      import('./favoritos/favoritos.component').then((m) => m.FavoritosComponent),
  },
  {
    path: 'cambiarAIngredientes',
    loadComponent: () =>
      import('./receta-mas-info/receta-mas-info.component').then((m) => m.RecetaMasInfoComponent),
  },
  {
    path: 'cambiarAInstrucciones',
    loadComponent: () =>
      import('./recetas-instrucciones/recetas-instrucciones.component').then((m) => m.RecetasInstruccionesComponent),
  },


  {
    path: '',
    redirectTo: 'inicio',
    pathMatch: 'full',
  },
];
