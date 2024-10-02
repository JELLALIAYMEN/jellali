import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource } from "@angular/material/table";
import { MatPaginator } from "@angular/material/paginator";
import { MatSort } from "@angular/material/sort";
import { Router } from "@angular/router";
import {AuthService} from "../services/auth.service";
import {Eleve, Payment} from "../../../Model/students.model";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";

@Component({
  selector: 'app-studens',
  templateUrl: './studens.component.html',
  styleUrls: ['./studens.component.css'] // Corrected here
})
export class StudensComponent implements OnInit, AfterViewInit {
  public students: any[] = []; // Initialize as an array
  public datasource: MatTableDataSource<any>; // Specify the type as MatTableDataSource

  displayedColumns = ['id', "firstName", "lastname", "gmail", "payments", "notes", "moyennes", "disciplines","réclamations"];

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private  authService:AuthService ,private router: Router,private http : HttpClient) {
    // Initialize MatTableDataSource in the constructor
    this.datasource = new MatTableDataSource(this.students);
  }

  ngAfterViewInit(): void {
    this.datasource.paginator = this.paginator;
    this.datasource.sort = this.sort;
  }




  ngOnInit() {
     // Populate the students array
    this.http.get("http://localhost:8037/payments")
    for (let i: number = 1; i < 100; i++) {
       this.students.push({
        id: i,
       firstName: Math.random().toString(20).substring(2, 7),
        lastname: Math.random().toString(20).substring(2, 7),
         gmail: `student${i}@example.com`
       });
    }
     this.datasource.data = this.students; // Set the data for the dataSource
   }

  filterStudent($event: Event) {
    const value = ($event.target as HTMLInputElement).value;
    this.datasource.filter = value.trim().toLowerCase(); // Ensure the filter is case insensitive
  }



  getNotes(student: any) {
    this.router.navigateByUrl("/admin/notes");
  }
  getPayments(student: Eleve) {
    this.router.navigateByUrl('/admin/paystu/{+student.code}');

  }


  getMoyennes(student: any) { // Added parameter
    this.router.navigateByUrl("admin/moy");
  }

  getDisciplines(student: any) {
    this.router.navigateByUrl("admin/disciplines");
  }

  getReclamations(student:Eleve) {
    this.router.navigateByUrl("/admin/paystu/$'+student.code");
  }
}


