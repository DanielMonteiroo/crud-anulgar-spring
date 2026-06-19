import { Component, inject } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { AppMaterialModule } from "../../app-material/app-material-module";

@Component({
  selector: 'app-error-dialog',
  imports: [AppMaterialModule],
  templateUrl: './error-dialog.html',
  styleUrl: './error-dialog.scss',
})
export class ErrorDialog {

  data = inject(MAT_DIALOG_DATA);

}
