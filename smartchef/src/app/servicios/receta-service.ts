import {inject, Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Receta} from "../modelos/Receta";
import {RecetaTarjeta} from "../modelos/RecetaTarjeta";
import {CrearReceta} from "../modelos/CrearReceta";


@Injectable({
  providedIn: 'root'
})
export class RecetaService {

  private http = inject(HttpClient);


  /**
   * consultar todos
   *
   *
   * getById
   *
   *
   * Agregar
   *
   * Eliminar
   *
   * Editar
   */

  constructor() {}

  obtenerRecetas(): Observable<RecetaTarjeta[]> {
    return this.http.get<RecetaTarjeta[]>(`http://localhost:8080/receta/tarjetasRecetas`);
  }
  eliminarReceta(id: number) {
    return this.http.delete(`http://localhost:8080/receta/eliminarReceta/${id}`);
  }
  obtenerRecetaEnDetalle(id: number): Observable<Receta> {
    return this.http.get<Receta>(`http://localhost:8080/receta/verDetalles/${id}`);
  }
  crearReceta(receta: CrearReceta): Observable<CrearReceta> {
    return this.http.post<CrearReceta>(`http://localhost:8080/receta/agregarReceta`, receta);
  }
  editarReceta(receta: CrearReceta): Observable<CrearReceta> {
    return this.http.put<CrearReceta>(`http://localhost:8080/receta/editar/${receta.id}`, receta);
  }
  obtenerRecetaPorId(id: number): Observable<CrearReceta> {
    return this.http.get<CrearReceta>(`http://localhost:8080/receta/buscarPorId/${id}`);
  }

  buscarRecetasPorFiltro(filtro: any): Observable<RecetaTarjeta[]> {
    const params: any = {};
    if (filtro.economica) params.economica = filtro.economica;
    if (filtro.vegetariana) params.vegetariana = filtro.vegetariana;
    if (filtro.sin_gluten) params.sin_gluten = filtro.sin_gluten;
    if (filtro.rapido) params.rapido = filtro.rapido;
    if (filtro.ingredientes && filtro.ingredientes.length > 0) params.ingredientes = filtro.ingredientes;

    return this.http.get<RecetaTarjeta[]>('http://localhost:8080/receta/buscarReceta', { params });
  }




}
