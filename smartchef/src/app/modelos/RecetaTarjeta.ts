import {Instrucciones} from "./Instrucciones";
import {Ingredientes} from "./Ingredientes";


export interface RecetaTarjeta{
  id: number;
  nombre: string;
  tiempoPreparacion: number;
  urlImagen: string;
  numeroIngredientes: number;
  booleanosActivos: string[];

}
