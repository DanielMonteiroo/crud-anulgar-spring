import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Curso } from '../model/cursoModel';



@Injectable({
  providedIn: 'root',
}
)
export class CursosService {

  constructor(private httpClient: HttpClient){}//injeção de dependência do HttpClient para fazer requisições HTTP

  private readonly API = 'api/cursos'; //caminho do arquivo json

  list(){
    return this.httpClient.get<Curso[]>(this.API);//chamada do método get para ler o arquivo json
  }

  save(curso: Partial<Curso>){
    return this.httpClient.post<Curso>(this.API, curso);
  }

  loadById(id: number){
    return this.httpClient.get<Curso>(`${this.API}/${id}`);//chamada do método get para ler o arquivo json com o id do curso
  }
}
