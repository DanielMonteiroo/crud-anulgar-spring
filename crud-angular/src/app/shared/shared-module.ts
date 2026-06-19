import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AppMaterialModule } from './app-material/app-material-module';
import { CategoriaPipe } from './pipes/categoria-pipe';


@NgModule({
  declarations: [],
  imports: [CommonModule,AppMaterialModule,CategoriaPipe],
})
export class SharedModule {}
