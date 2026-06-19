import { Component } from '@angular/core';
import { catchError, delay, first, Observable, of, tap } from 'rxjs';
import { Curso } from '../model/cursoModel';
import { CursosService } from './../service/cursosService';
import { AppMaterialModule } from '../../shared/app-material/app-material-module';
import { AsyncPipe } from '@angular/common';
import { MatDialog } from '@angular/material/dialog';
import { ErrorDialog } from '../../shared/componentes/error-dialog/error-dialog';
import { CategoriaPipe } from "../../shared/pipes/categoria-pipe";
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-cursos',
  standalone: true,
  imports: [AppMaterialModule, AsyncPipe, CategoriaPipe],
  templateUrl: './cursosApp.html',
  styleUrl: './cursosApp.scss',
})
export class CursosApp {

 cursos:Observable<Curso[]>;
 displayedColumns = ['nome', 'categoria', 'acoes'];

  constructor(private cursosService: CursosService,public dialog: MatDialog,private router: Router,private route: ActivatedRoute) //injeção de dependências para o serviço de cursos, o serviço de diálogo e os serviços de roteamento
  {
    //carrega os cursos usando o serviço de cursos e lida com erros usando o operador catchError do RxJS
    this.cursos = this.cursosService.list().pipe(
      catchError(error => {
       this.onError('Não foi possível carregar os cursos. Por favor, tente novamente mais tarde.'); //chama o método onError para exibir a mensagem de erro
      return of([]);
      })
    );
  }
 // this.cursos = this.cursosService.list().pipe(first(),delay(6000),tap(cursos => console.log(cursos))

onError(erroMsg: string) { //metodo para abrir o dialog de erro
    this.dialog.open(ErrorDialog, {
      data: erroMsg
    });
  }

  onAdd() {
    this.router.navigate(['new'], { relativeTo: this.route }); //navega para a rota 'new' relativa à rota atual (cursos) para adicionar um novo curso
  }

}
