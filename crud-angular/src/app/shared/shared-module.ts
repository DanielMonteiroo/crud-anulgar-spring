import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AppMaterialModule } from './app-material/app-material-module';
import { CategoriaPipe } from './pipes/categoria-pipe';
import { ConfirmDialog } from './componentes/confirm-dialog/confirm-dialog';


@NgModule({
  declarations: [],
  imports: [CommonModule,AppMaterialModule,CategoriaPipe,ConfirmDialog],
})
export class SharedModule {}
