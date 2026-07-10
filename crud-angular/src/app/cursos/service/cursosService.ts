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

  loadById(id: number){
    return this.httpClient.get<Curso>(`${this.API}/${id}`);//chamada do método get para ler o arquivo json com o id do curso
  }

  save(curso: Partial<Curso>){
    if(curso.id){//verifica se o curso possui um id, se sim, chama o método update, caso contrário, chama o método create
      return this.update(curso);
    }
    return this.create(curso);
  }

  delete(id: number){
    return this.httpClient.delete(`${this.API}/${id}`);//chamada do método delete para deletar um curso existente
  }

  private create(curso: Partial<Curso>){
    return this.httpClient.post<Curso>(this.API, curso);//chamada do método post para criar um novo curso
  }

  private update(curso: Partial<Curso>){
    return this.httpClient.put<Curso>(`${this.API}/${curso.id}`, curso);//chamada do método put para atualizar um curso existente
  }

}
