import {Component, OnInit, ViewChild} from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { StudentsService } from '../services/students.service';
import { MatTableDataSource } from '@angular/material/table';
import { Payment } from '../../../Model/students.model';
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";

@Component({
  selector: 'app-stupay',
  templateUrl: './stupay.component.html',
})
export class StupayComponent implements OnInit {
  elcode!: string; // Code of the student
  elevepay!: Array<Payment>;
  @ViewChild(MatPaginator) paginator! : MatPaginator;
  @ViewChild(MatSort) sort! : MatSort;
  // Liste des paiements de l'élève

  constructor(
    private activateRoute: ActivatedRoute,
    private studentsService: StudentsService,
    private router: Router
  ) {}

  ngOnInit() {
    // Récupérer le code à partir des paramètres de la route
    this.elcode = this.activateRoute.snapshot.params['code'];

    // Appel du service pour récupérer les paiements
    this.studentsService.getPayments(this.elcode).subscribe({
      next: (value: Payment[]) => {
        this.elevepay = value; // Assigner les paiements reçus à 'elevepay'
      },
      error: (error) => {
        console.log(error); // Gérer les erreurs
      }
    });
  }

  newPayment() {
    // Correction du modèle de chaîne de caractères
    this.router.navigateByUrl(`/admin/newpay/${this.elcode}`);
  }
}
