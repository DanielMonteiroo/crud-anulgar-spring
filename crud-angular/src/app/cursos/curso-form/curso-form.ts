import { Component } from '@angular/core';
import { FormGroup, NonNullableFormBuilder } from '@angular/forms';
import { AppMaterialModule } from '../../shared/app-material/app-material-module';
import { ReactiveFormsModule } from '@angular/forms';
import { CursosService } from '../service/cursosService';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Location } from '@angular/common';

@Component({
  selector: 'app-curso-form',
  imports: [AppMaterialModule, ReactiveFormsModule],
  templateUrl: './curso-form.html',
  styleUrl: './curso-form.scss',
})
export class CursoForm {

  form: FormGroup;
  constructor(private formBuilder: NonNullableFormBuilder,private service: CursosService,private snackBar: MatSnackBar,private location: Location) {
    this.form = this.formBuilder.group({
      nome: [''],
      categoria: ['']
    });
  }

  //metodo para submeter o formulário
  onSubmit(){
    this.service.save(this.form.value).subscribe(result => this.onSucess(),erro=> this.onError());
  }

  //metodo para cancelar o formulário
  onCancel(){
    this.location.back();
  }

  private onSucess(){
     this.snackBar.open("Curso salvo com sucesso!","",{duration: 5000});
     this.location.back();
  }

  private onError(){
     this.snackBar.open("Erro ao salvar curso","",{duration: 5000});
  }

}
