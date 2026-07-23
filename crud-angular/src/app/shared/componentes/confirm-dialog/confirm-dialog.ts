import { Component, inject } from '@angular/core';
import { AppMaterialModule } from "../../app-material/app-material-module";
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { MatDialogModule } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';

@Component({
  selector: 'app-confirm-dialog',
  standalone: true,
  imports: [AppMaterialModule, MatDialogModule, MatButtonModule],
  templateUrl: './confirm-dialog.html',
  styleUrl: './confirm-dialog.scss',
})
export class ConfirmDialog {

readonly dialog = inject(MatDialog);//inject MatDialog service to open the dialog
data: string = "Tem certeza que deseja excluir este item?";


readonly dialogRef = inject(MatDialogRef<ConfirmDialog>);//inject MatDialogRef to get a reference to the dialog instance

onConfirm(result: boolean): void {
    this.dialogRef.close(result);
  }

}
