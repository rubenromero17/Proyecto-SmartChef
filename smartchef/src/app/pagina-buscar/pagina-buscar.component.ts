import { Component, inject, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import {
  IonButton,
  IonContent,
  IonIcon,
  IonInput
} from '@ionic/angular/standalone';

import { BarraNavegacionComponent } from '../barra-navegacion/barra-navegacion.component';
import { TarjetaRecetasComponent } from '../tarjeta-recetas/tarjeta-recetas.component';

import { RecetaService } from '../servicios/receta-service';
import { RecetaTarjeta } from '../modelos/RecetaTarjeta';
import { CrearReceta } from '../modelos/CrearReceta';



@Component({
  selector: 'app-pagina-buscar',
  templateUrl: './pagina-buscar.component.html',
  styleUrls: ['./pagina-buscar.component.scss'],
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    BarraNavegacionComponent,
    TarjetaRecetasComponent,
    IonButton,
    IonContent,
    IonIcon,
    IonInput
  ],
})
export class PaginaBuscarComponent implements OnInit {

  protected recetasService = inject(RecetaService);

  // eslint-disable-next-line @angular-eslint/prefer-inject
  constructor(public router: Router) {}

  recetas: RecetaTarjeta[] = [];
  mostrarFormulario = false;


  nuevaReceta: CrearReceta = this.crearRecetaVacia();

  ngOnInit() {
    this.cargartodaslasrecetas();
  }


  abrirFormularioParaEditarPorId(id: number) {
    this.recetasService.obtenerRecetaPorId(id).subscribe({
      next: (receta) => {
        this.nuevaReceta = {
          ...receta,
          ingredientes: receta.ingredientes ? [...receta.ingredientes] : [],
          instrucciones: receta.instrucciones ? [...receta.instrucciones] : []
        };

        this.mostrarFormulario = true;
      },
      error: (err) => {
        console.error('Error al cargar la receta', err);
        alert('No se pudo cargar la receta.');
      }
    });
  }


  guardarReceta() {
    console.log('Receta que voy a enviar al backend:', this.nuevaReceta);

    if (this.nuevaReceta.id && this.nuevaReceta.id !== 0) {
      this.recetasService.editarReceta(this.nuevaReceta).subscribe({
        next: () => {
          alert('Receta actualizada correctamente');
          this.resetFormulario();
          this.cargartodaslasrecetas();
        },
        error: (err) => console.error('Error al editar receta', err)
      });
    } else {
      this.recetasService.crearReceta(this.nuevaReceta).subscribe({
        next: () => {
          alert('Receta creada correctamente');
          this.resetFormulario();
          this.cargartodaslasrecetas();
        },
        error: (err) => console.error('Error al crear receta', err)
      });
    }
  }


  resetFormulario() {
    this.nuevaReceta = this.crearRecetaVacia();
    this.mostrarFormulario = false;
  }


  crearRecetaVacia(): CrearReceta {
    return {
      id: 0,
      nombre: '',
      descripcion: '',
      tiempoPreparacion: 0,
      urlImagen: '',
      dificultad: 'FACIL',
      economica: false,
      vegetariana: false,
      sin_gluten: false,
      rapido: false,
      ingredientes: [],
      instrucciones: []
    };
  }


  agregarIngrediente() {
    if (!this.nuevaReceta) {
      this.nuevaReceta = this.crearRecetaVacia();
    }
    if (!this.nuevaReceta.ingredientes) {
      this.nuevaReceta.ingredientes = [];
    }
    this.nuevaReceta.ingredientes.push({ nombre: '', cantidad: 1 });
  }

  eliminarIngrediente(index: number) {
    this.nuevaReceta.ingredientes.splice(index, 1);
  }


  agregarInstruccion() {
    if (!this.nuevaReceta) {
      this.nuevaReceta = this.crearRecetaVacia();
    }
    if (!this.nuevaReceta.instrucciones) {
      this.nuevaReceta.instrucciones = [];
    }
    this.nuevaReceta.instrucciones.push({ descripcion: '' });
  }


  eliminarInstruccion(index: number) {
    this.nuevaReceta.instrucciones.splice(index, 1);
  }

  cargartodaslasrecetas() {
    this.recetasService.obtenerRecetas().subscribe({
      next: recetas => {
        this.recetasOriginales = recetas;
        this.recetas = recetas;
      },
      error: err => console.error(err)
    });
  }

  borrarReceta(id: number) {
    if (!confirm('¿Eliminar esta receta?')) return;

    this.recetasService.eliminarReceta(id).subscribe({
      next: () => {
        this.recetas = this.recetas.filter(r => r.id !== id);
      },
      error: err => console.error('Error al borrar receta', err)
    });
  }


  busquedaActiva = false;
  filtroActivo = false;


  filtro = {
    economica: false,
    vegetariana: false,
    sin_gluten: false,
    rapido: false,
    ingredientes: [] as string[]
  };

  ingredienteFiltro: string = '';


  agregarIngredienteFiltro() {
    if (this.ingredienteFiltro && !this.filtro.ingredientes.includes(this.ingredienteFiltro)) {
      this.filtro.ingredientes.push(this.ingredienteFiltro);
      this.ingredienteFiltro = '';
    }
  }

  quitarIngredienteFiltro(index: number) {
    this.filtro.ingredientes.splice(index, 1);
  }

  aplicarFiltro() {
    this.recetasService.buscarRecetasPorFiltro(this.filtro).subscribe({
      next: recetasFiltradas => this.recetas = recetasFiltradas,
      error: err => console.error('Error al filtrar recetas', err)
    });
  }


  textoBusqueda: string = '';
  recetasOriginales: RecetaTarjeta[] = [];



  buscarPorNombre() {
    const texto = this.textoBusqueda.toLowerCase().trim();

    if (!texto) {
      this.recetas = this.recetasOriginales;
      return;
    }

    this.recetas = this.recetasOriginales.filter(r =>
      r.nombre.toLowerCase().includes(texto)
    );
  }

  toggleBusqueda() {
    this.busquedaActiva = !this.busquedaActiva;

    if (!this.busquedaActiva) {
      this.textoBusqueda = '';
      this.recetas = this.recetasOriginales;
    }
  }








}
