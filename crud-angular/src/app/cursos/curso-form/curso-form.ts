import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { AppMaterialModule } from '../../shared/app-material/app-material-module';
import { ReactiveFormsModule } from '@angular/forms';
import { CursosService } from '../service/cursosService';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-curso-form',
  imports: [AppMaterialModule, ReactiveFormsModule],
  templateUrl: './curso-form.html',
  styleUrl: './curso-form.scss',
})
export class CursoForm {

  form: FormGroup;
  constructor(private formBuilder: FormBuilder,private service: CursosService,private snackBar: MatSnackBar) {
    this.form = this.formBuilder.group({
      nome: [''],
      categoria: ['']
    });
  }

  //metodo para submeter o formulário
  onSubmit(){
    this.service.save(this.form.value).subscribe(resultado => resultado,erro=> this.onError());
  }

  //metodo para cancelar o formulário
  onCancel(){

  }

  private onError(){
     this.snackBar.open("Erro ao salvar curso","",{duration: 5000});
  }

}
