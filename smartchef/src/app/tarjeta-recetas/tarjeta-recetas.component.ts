import {Component, EventEmitter, inject, Input, Output} from '@angular/core';
import { IonCard, IonCol, IonIcon, IonRow } from "@ionic/angular/standalone";
import {CommonModule, NgForOf} from "@angular/common";
import { Router } from "@angular/router";
import {RecetaService} from "../servicios/receta-service";
import {Receta} from "../modelos/Receta";
import {RecetaTarjeta} from "../modelos/RecetaTarjeta";
import {CrearReceta} from "../modelos/CrearReceta";

@Component({
  selector: 'app-tarjeta-recetas',
  templateUrl: './tarjeta-recetas.component.html',
  styleUrls: ['./tarjeta-recetas.component.scss'],
  standalone: true,
  imports: [
    CommonModule,
    IonCard,
    IonCol,
    IonIcon,
    IonRow,
  ]
})
export class TarjetaRecetasComponent  {

  @Input() recetas: RecetaTarjeta[] = [];
  @Input() receta!: RecetaTarjeta;
  @Input() Receta!: CrearReceta;
  @Output() eliminar = new EventEmitter<number>();
  @Output() editar = new EventEmitter<number>();


  // eslint-disable-next-line @angular-eslint/prefer-inject
  constructor(public router: Router) {}

  eliminaReceta(receta: RecetaTarjeta): void {
    this.eliminar.emit(receta.id);
  }

  editarReceta(receta: RecetaTarjeta) {
    this.editar.emit(receta.id);
  }


  masInfoRecetas(id: number) {
    this.router.navigate(['/masInfoRecetas', id]);
  }


}
