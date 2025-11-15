import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { BarraNavegacionComponent } from '../barra-navegacion/barra-navegacion.component';
import {
  IonButton,
  IonCard,
  IonCheckbox,
  IonCol,
  IonContent,
  IonIcon,
  IonInput,
  IonRow,
} from '@ionic/angular/standalone';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-pagina-buscar',
  templateUrl: './pagina-buscar.component.html',
  styleUrls: ['./pagina-buscar.component.scss'],
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    BarraNavegacionComponent,
    IonButton,
    IonCard,
    IonCheckbox,
    IonCol,
    IonContent,
    IonIcon,
    IonInput,
    IonRow,
  ],
})
export class PaginaBuscarComponent {
  constructor(public router: Router) {}

  busqueda: string = '';
  busquedaActiva = false;
  mostrarFiltro = false;

  toggleBusqueda() {
    this.busquedaActiva = !this.busquedaActiva;
    if (!this.busquedaActiva) {
      this.busqueda = '';
      this.recetasFiltradas = [...this.recetas];
    }
  }
  filtros = {
    vegetariano: false,
    sinGluten: false,
    rapidas: false,
    economicas: false,
    ingredientes: '',
  };

  recetas = [
    {
      nombre: 'Pasta Carbonara Clásica',
      imagen: 'assets/icon/pastaCarbonara.png',
      tiempo: '20 Min',
      personas: '4 Pers',
      ingredientes: 7,
      tags: ['italiano', 'pasta'],
      vegetariano: false,
      sinGluten: false,
      rapida: true,
      economica: true,
    },
    {
      nombre: 'Ensalada Buddha Bowl',
      imagen: 'assets/icon/ensaladaBuddha.png',
      tiempo: '15 Min',
      personas: '1 Pers',
      ingredientes: 9,
      tags: ['saludable', 'vegetariano'],
      vegetariano: true,
      sinGluten: true,
      rapida: true,
      economica: true,
    },
    {
      nombre: 'Pollo al Limón',
      imagen: 'assets/icon/pollo-al-limon.png',
      tiempo: '45 Min',
      personas: '4 Pers',
      ingredientes: 5,
      tags: ['pollo', 'casero'],
      vegetariano: false,
      sinGluten: true,
      rapida: false,
      economica: true,
    },
    {
      nombre: 'Smoothie Bowl Tropical',
      imagen: 'assets/icon/smoothieBowl.png',
      tiempo: '10 Min',
      personas: '4 Pers',
      ingredientes: 8,
      tags: ['desayuno', 'tropical'],
      vegetariano: true,
      sinGluten: true,
      rapida: true,
      economica: true,
    },
    {
      nombre: 'Risotto de Champiñones',
      imagen: 'assets/icon/risottoChampiñones.png',
      tiempo: '35 Min',
      personas: '4 Pers',
      ingredientes: 10,
      tags: ['champiñones', 'aventura'],
      vegetariano: true,
      sinGluten: false,
      rapida: false,
      economica: false,
    },
  ];

  recetasFiltradas = [...this.recetas];

  toggleFiltro() {
    this.mostrarFiltro = !this.mostrarFiltro;
  }

  cerrarFiltro() {
    this.mostrarFiltro = false;
  }

  aplicarFiltros() {
    this.recetasFiltradas = this.recetas.filter((r) => {
      const cumpleVegetariano = !this.filtros.vegetariano || r.vegetariano;
      const cumpleSinGluten = !this.filtros.sinGluten || r.sinGluten;
      const cumpleRapidas = !this.filtros.rapidas || parseInt(r.tiempo) <= 20;
      const cumpleEconomicas = !this.filtros.economicas || r.economica;

      const ingredientesOk =
        !this.filtros.ingredientes ||
        r.tags.some((tag) =>
          tag.toLowerCase().includes(this.filtros.ingredientes.toLowerCase())
        );

      return (
        cumpleVegetariano &&
        cumpleSinGluten &&
        cumpleRapidas &&
        cumpleEconomicas &&
        ingredientesOk
      );
    });
  }

  filtrarRecetas() {
    const texto = this.busqueda.toLowerCase().trim();

    this.recetasFiltradas = this.recetas.filter(
      (r) =>
        r.nombre.toLowerCase().includes(texto) ||
        r.tags.some((tag) => tag.toLowerCase().includes(texto))
    );
  }
}
