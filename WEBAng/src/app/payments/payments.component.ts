import {Component, OnInit, ViewChild} from '@angular/core';
import { StudentsService } from '../services/students.service';
import { Payment } from '../../../Model/students.model';
import {MatPaginator} from "@angular/material/paginator";
import {MatTableDataSource} from "@angular/material/table";

@Component({
  selector: 'app-payments',
  templateUrl: './payments.component.html',
  styleUrls: ['./payments.component.css']
})
export class PaymentsComponent implements OnInit {
 public Payments : any;
 public  datasource:any;
 public  displayedColumns:string[]=['id','date','typepay','modepay','statuspay','amount','firstName'];
 // Assuming Payment is the correct type
@ViewChild(MatPaginator) piginator!:MatPaginator;
  constructor(private studentsService: StudentsService) {}

  ngOnInit() {
    this.studentsService.getAllPayments().subscribe({ // Ensure this method returns an Observable<Payment[]>
      next: (data: Payment[]) => {
        console.log('Payments data received:', data);
        this.Payments  = data;
        this.datasource=new MatTableDataSource(this.Payments);
        this.datasource.piginator=this.piginator;
        // Assign fetched data to the payments array
      },
      error: (err) => {
        console.error('Error fetching payments:', err);
      }
    });
  }
}


