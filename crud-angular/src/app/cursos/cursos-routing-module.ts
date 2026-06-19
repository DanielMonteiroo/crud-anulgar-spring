import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CursosApp } from './cursos/cursosApp';
import { CursoForm } from './curso-form/curso-form';


const routes: Routes = [
  {path:'',component:CursosApp},
  {path:'new',component:CursoForm}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class CursosRoutingModule {}
