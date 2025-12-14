import {Instrucciones} from "./Instrucciones";
import {Ingredientes} from "./Ingredientes";


export interface Receta{
  id: number;
  nombre: string;
  descripcion: string;
  tiempoPreparacion: number;
  urlImagen: string;
  dificultad: string;
  economica: boolean;
  vegetariana: boolean;
  sin_gluten: boolean;
  rapido: boolean;

  instrucciones:Instrucciones[];
  ingredientes:Ingredientes[];


}
