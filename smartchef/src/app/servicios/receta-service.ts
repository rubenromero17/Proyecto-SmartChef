import { inject, Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Receta } from "../modelos/Receta";
import { RecetaTarjeta } from "../modelos/RecetaTarjeta";
import { CrearReceta } from "../modelos/CrearReceta";
import { environment } from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class RecetaService {
  private http = inject(HttpClient);
  private apiUrl = environment.apiUrl;

  constructor() {}

  obtenerRecetas(): Observable<RecetaTarjeta[]> {
    // Aquí sí tenías la barra, este estaba bien
    return this.http.get<RecetaTarjeta[]>(`${this.apiUrl}/receta/tarjetasRecetas`);
  }

  eliminarReceta(id: number) {
    return this.http.delete(`${this.apiUrl}/receta/eliminarReceta/${id}`);
  }

  obtenerRecetaEnDetalle(id: number): Observable<Receta> {
    return this.http.get<Receta>(`${this.apiUrl}/receta/verDetalles/${id}`);
  }

  crearReceta(receta: CrearReceta): Observable<CrearReceta> {
    return this.http.post<CrearReceta>(`${this.apiUrl}/receta/agregarReceta`, receta);
  }

  editarReceta(receta: CrearReceta): Observable<CrearReceta> {
    return this.http.put<CrearReceta>(`${this.apiUrl}/receta/editar/${receta.id}`, receta);
  }

  obtenerRecetaPorId(id: number): Observable<CrearReceta> {
    return this.http.get<CrearReceta>(`${this.apiUrl}/receta/buscarPorId/${id}`);
  }

  buscarRecetasPorFiltro(filtro: any): Observable<RecetaTarjeta[]> {
    const params: any = {};
    if (filtro.economica) params.economica = filtro.economica;
    if (filtro.vegetariana) params.vegetariana = filtro.vegetariana;
    if (filtro.sin_gluten) params.sin_gluten = filtro.sin_gluten;
    if (filtro.rapido) params.rapido = filtro.rapido;
    if (filtro.ingredientes && filtro.ingredientes.length > 0) params.ingredientes = filtro.ingredientes;


    return this.http.get<RecetaTarjeta[]>(`${this.apiUrl}/receta/buscarReceta`, { params });
  }
}
