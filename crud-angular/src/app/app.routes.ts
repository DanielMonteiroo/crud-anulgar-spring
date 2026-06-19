import { Routes } from '@angular/router';

export const routes: Routes = [
  {path:'',pathMatch:'full', redirectTo:'cursos'},//Redirecionamento para a rota cursos
  {path:'cursos',
  loadChildren:()=> import('./cursos/cursos-module').then(m=>m.CursosModule)}//Lazy loading do módulo cursos
];
