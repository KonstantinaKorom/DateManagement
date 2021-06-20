import { DialogComponent } from './dialog/dialog.component';
import { Router } from '@angular/router';
import { Status } from './model/status.model';
import { stringify } from '@angular/compiler/src/util';
import { Component } from '@angular/core';
import { HolidaysService } from 'src/app/service/holidays.service';
import { Holiday } from './model/holiday.model';
import { Button } from 'protractor';
import { MatDialog, MatDialogConfig, MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'School Holidays';
  list: any;
  holidays: Holiday[];
  status: Status[];
  columns: any;

  // injecting the MatDialog service via the constructor
  constructor(private holidaysService: HolidaysService, private dialog: MatDialog) {
    this.columns = ["date", "status", "action"];

  }


  ngOnInit(): void {
    this.holidaysService
      .getAllHolidays()
      .subscribe(data => { this.holidays = data }
      );
    this.holidaysService
      .getAllStatus()
      .subscribe(data => { this.status = data }
      );

  }
  onDelete(object: Holiday) {
    let date = object.date;
    this.holidaysService.deleteHoliday(date)
      .subscribe(
        data => {
          console.log(data)
          this.holidaysService.getAllHolidays().subscribe(
            newdata => { this.holidays = newdata }
          );

        },
        error => console.log(error)

      );
    // bad practise TODO change
    window.location.reload()

  }

  //open the DialogComponent
  openDialog() {

    //creating an instance of MatDialogConfig, which will configure the dialog with a set of default behaviors
    const dialogConfig = new MatDialogConfig();

    //overriding behaviors
    dialogConfig.disableClose = true;  //not able to close the the dialog by clicking out of the box
    dialogConfig.autoFocus = true;  // focus auto on the first form field of the dialog
    dialogConfig.hasBackdrop = true;  //blocks from clicking the rest of the UI while dialog is opened
    dialogConfig.direction = 'ltr'; // elements inside dialog are left justified

    this.dialog.open(DialogComponent, dialogConfig);
}

}

