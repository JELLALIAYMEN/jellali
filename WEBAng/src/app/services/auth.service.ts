import { Injectable } from '@angular/core';
import {Router} from "@angular/router";
import { Eleve } from '../../../Model/students.model';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:8037';
  public username!:any;
  public roles: any;
  public  isauthenticated: boolean=false;

  public users: any = {
    admin: {password: '1234', roles: ['STUDENT', 'ADMIN']},
    user1: {password: '1234', roles: ['STUDENT']}
  }


  constructor(private http: HttpClient ,private  router:Router) {
  }
  public login(username: string, password: string): boolean {
    if (this.users[username] && this.users[username]['password'] === password) {
      this.isauthenticated = true;
      this.username = username;
      this.roles = this.users[username]['roles'];
      return true;
    } else {
      return false;
    }
  }




  logout() {
    this.isauthenticated=false;
    this.username =undefined;
    this.roles =undefined;
    this.router.navigateByUrl("/login")
  }
  getAll(): Observable<Eleve[]> {
    return this.http.get<Eleve[]>(`${this.apiUrl}/eleves`);
  }
}
