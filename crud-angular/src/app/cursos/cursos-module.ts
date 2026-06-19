import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { AppMaterialModule } from '../shared/app-material/app-material-module'; //imoprtando o módulo do material design para usar os componentes do material design no módulo de cursos
import { CursosRoutingModule } from './cursos-routing-module';
import { SharedModule } from '../shared/shared-module';

@NgModule({
  declarations: [],
  imports: [CommonModule, CursosRoutingModule, AppMaterialModule,SharedModule],
})
export class CursosModule {}
