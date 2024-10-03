import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource } from "@angular/material/table";
import { StudentsService } from "../services/students.service";
import { Eleve } from "../../../Model/students.model";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";

@Component({
  selector: 'app-studens',
  templateUrl: './studens.component.html',
  styleUrls: ['./studens.component.css']
})
export class StudensComponent implements OnInit {
  displayedColumns = ['id', 'firstName', 'secondname', 'gmail', 'code'];
  students!: Array<Eleve>;
  public datasource!: MatTableDataSource<Eleve>;
  @ViewChild(MatPaginator) piginator!:MatPaginator;
  @ViewChild(MatSort) sort!:MatSort;

  constructor(private StudentsService: StudentsService) {
    this.datasource = new MatTableDataSource(this.students);
  }

  ngOnInit() {
    this.StudentsService.getAll().subscribe({
      next: (value: Eleve[]) => {  // Corrected the syntax here
        this.students = value;
        this.datasource = new MatTableDataSource<Eleve>(this.students);
      },
      error: (err) => {
        console.error('Erreur lors de la récupération des étudiants :', err);
      }
    });
  }
}
