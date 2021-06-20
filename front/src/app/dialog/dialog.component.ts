import { Component, Inject, OnInit } from '@angular/core';
import {FormBuilder, Validators, FormGroup} from "@angular/forms";
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { HolidaysService } from 'src/app/service/holidays.service';
import { AppComponent } from '../app.component';
import { Holiday } from '../model/holiday.model';
import { Status } from '../model/status.model';
import { DateAdapter } from '@angular/material/core';


@Component({
  selector: 'app-dialog',
  templateUrl: './dialog.component.html',
  styleUrls: ['./dialog.component.css']
})
export class DialogComponent implements OnInit {

  title = "Add new holiday";
  status: string;
  date: Date;
  sendValue: Date

  weekendFilters = (d: Date | null): boolean => {
    const day = (d || new Date()).getDay();
    return day !== 0 && day !== 6;
  }

  constructor(@Inject(MAT_DIALOG_DATA) public data,
    private dialogRef: MatDialogRef<DialogComponent>,
    private holidayService: HolidaysService
   ) {

    }

  ngOnInit(): void {

  }

  close(): void {
    this.dialogRef.close();
  }

  //TODO changes, not working
  onSave() {
    // let holiday: Holiday
    // holiday.date = this.sendValue;
    // let status: Status;
    // status.datestatus = "holiday";
    // holiday.status = status;
    // this.dialogRef.close(this.holidayService.createHoliday(holiday));

  }
}

