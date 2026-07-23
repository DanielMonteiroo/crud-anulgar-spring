import { AsyncPipe } from '@angular/common';
import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { catchError, Observable, of } from 'rxjs';
import { AppMaterialModule } from '../../shared/app-material/app-material-module';
import { ErrorDialog } from '../../shared/componentes/error-dialog/error-dialog';
import { CategoriaPipe } from "../../shared/pipes/categoria-pipe";
import { Curso } from '../model/cursoModel';
import { CursosService } from './../service/cursosService';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ConfirmDialog } from '../../shared/componentes/confirm-dialog/confirm-dialog';


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

  constructor(private cursosService: CursosService,public dialog: MatDialog,private router: Router,private route: ActivatedRoute,private snackbar: MatSnackBar) //injeção de dependências para o serviço de cursos, o serviço de diálogo e os serviços de roteamento
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

  onEdit(row: Curso){
    this.router.navigate(['edit', row.id], { relativeTo: this.route });//navega para a rota 'edit' relativa à rota atual (cursos) passando o id do curso a ser editado
  }

  onDelete(row: Curso){
   const dialogRef = this.dialog.open(ConfirmDialog, {
      data: 'tem certeza que deseja excluir este item?',
    });

   dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.cursosService.delete(row.id).subscribe({
          next: () => {
             this.cursosService.list().subscribe(cursos => {
          this.cursos = of(cursos); //atualiza a lista de cursos após a exclusão
        });
            this.snackbar.open('Curso excluído com sucesso!', 'Fechar', { duration: 3000, horizontalPosition: 'center', verticalPosition: 'top' });
            window.location.reload();
          },
          error: () => {
            this.onError('Não foi possível excluir o curso. Por favor, tente novamente mais tarde.');
          }
        });
      }
    }
      );
}


}
