import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";
import {Eleve, Payment} from "../../../Model/students.model";

@Injectable({
  providedIn: 'root'
})
export class StudentsService {



  constructor(private http: HttpClient) { }

  public getAllPayments(): Observable<Array<Payment>> {
    return this.http.get<Array<Payment>>(`${environment.backendHost}/payments`); // Appel à l'API
  }

  public getAllél(): Observable<Array<Eleve>> {
    return this.http.get<Array<Eleve>>(`${environment.backendHost}/eleves`); // Appel à l'API
  }
  getPayments(code: string): Observable<Array<Payment>> {
    return this.http.get<Array<Payment>>(`${environment.backendHost}/eleves/${code}/payments`);
  }


}
