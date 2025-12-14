import { Component, OnInit } from '@angular/core';
import { IonContent, IonIcon } from '@ionic/angular/standalone';
import { ActivatedRoute, Router } from '@angular/router';
import { BarraNavegacionComponent } from '../barra-navegacion/barra-navegacion.component';
import { Receta } from '../modelos/Receta';
import { RecetaService } from '../servicios/receta-service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-receta-mas-info',
  templateUrl: './receta-mas-info.component.html',
  styleUrls: ['./receta-mas-info.component.scss'],
  standalone: true,
  imports: [
    IonIcon,
    IonContent,
    BarraNavegacionComponent,
    CommonModule
  ]
})
export class RecetaMasInfoComponent implements OnInit {

  receta!: Receta;
  mostrarIngredientes: boolean = true;

  constructor(
    // eslint-disable-next-line @angular-eslint/prefer-inject
    private route: ActivatedRoute,
    // eslint-disable-next-line @angular-eslint/prefer-inject
    private recetaService: RecetaService,
    // eslint-disable-next-line @angular-eslint/prefer-inject
    private router: Router
  ) { }

  ngOnInit(): void {
    const id = +this.route.snapshot.paramMap.get('id')!;
    this.recetaService.obtenerRecetaEnDetalle(id).subscribe({
      next: (receta) => this.receta = receta,
      error: (err) => console.error('Error al obtener receta', err)
    });
  }

  cambiarAInstrucciones(): void {
    this.mostrarIngredientes = false;
  }

  cambiarAIngredientes(): void {
    this.mostrarIngredientes = true;
  }

  volverABuscarDesdeRecetasMasInfo(): void {
    this.router.navigate(['/volverABuscarDesdeRecetasMasInfo']);
  }
}
