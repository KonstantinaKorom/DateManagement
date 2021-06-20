import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Holiday } from '../model/holiday.model';
@Injectable({
  providedIn: 'root'
})
export class HolidaysService {


  private baseUrl: string;

  constructor(private http: HttpClient) {
    this.baseUrl = 'http://localhost:8080/api';
   }

  getAllHolidays(): Observable<any> {
    return this.http.get(this.baseUrl+`/dates/holidays`);
  }

  getAllStatus(): Observable<any> {
    return this.http.get(this.baseUrl+`/status`);
  }
  deleteHoliday(date: Date): Observable<any> {
    return this.http.delete(this.baseUrl+`/dates/holidays/`+date);
  }

  createHoliday(holiday: Holiday): Observable<any>{
    return this.http.post(this.baseUrl+`/dates/holidays/new`, holiday);
  }

}
