import { NgModule } from '@angular/core';
import {mapToCanActivate, RouterModule, Routes} from '@angular/router';

import {LoginComponent} from "./login/login.component";
import {ProfileComponComponent} from "./profile-compon/profile-compon.component";
import {DashboardComponent} from "./dashboard/dashboard.component";
import {StudensComponent} from "./studens/studens.component";
import {MenusComponent} from "./menus/menus.component";
import {DisciplinesComponent} from "./disciplines/disciplines.component";
import {ActualitesComponent} from "./actualites/actualites.component";
import {MessageriesComponent} from "./messageries/messageries.component";
import {DocumentsComponent} from "./documents/documents.component";
import {PaymentsComponent} from "./payments/payments.component";
import {ReclamationsComponent} from "./reclamations/reclamations.component";
import {HomeComponent} from "./home/home.component";
import {NotesComponent} from "./notes/notes.component";
import {MoyennesComponent} from "./moyennes/moyennes.component";
import {AdminTemplateComponent} from "./admin-template/admin-template.component";
import {LoadPaymentsComponent} from "./load-payments/load-payments.component";
import {LoaddisciplinesComponent} from "./loaddisciplines/loaddisciplines.component";
import {AuthService} from "./services/auth.service";
import {AuthGuard} from "./guards/auth.guard.spec";
import {LoadelComponent} from "./loadel/loadel.component";
import {AuthorizationGuard} from "./guards/AuthorizationGuard.guard";
import { StupayComponent } from './stupay/stupay.component'
import {NewpayComponent} from "./newpay/newpay.component";

const routes: Routes = [
  { path: "", component: LoginComponent },
  { path: "login", component: LoginComponent },
  {
    path: "admin", component: AdminTemplateComponent, canActivate: [AuthGuard],
    children: [
      { path: "home", component: HomeComponent },
      { path: "profile", component: ProfileComponComponent },
      { path: "dashboard", component: DashboardComponent },
      { path: "Students", component: StudensComponent }, // Ensure correct component spelling (StudentsComponent)
      { path: "menu", component: MenusComponent },
      { path: "disciplines", component: DisciplinesComponent },
      { path: "actualités", component: ActualitesComponent },
      { path: "payments", component: PaymentsComponent },



      { path: "messageries", component: MessageriesComponent },
      { path: "document", component: DocumentsComponent },
      { path: "loadpay", component: LoadPaymentsComponent },
      { path: "loaddis", component: LoaddisciplinesComponent },
      { path: "elv", component: LoaddisciplinesComponent },
      { path: "réclamation", component: ReclamationsComponent },
      { path: "paystu/:code", component:  StupayComponent },
      { path: 'moy', component: MoyennesComponent },
      { path: 'notes', component: NotesComponent },
      { path: 'newpay/:code', component: NewpayComponent  },
      {
        path: 'loadmoyennes',
        component: MoyennesComponent,
        canActivate: [AuthorizationGuard],
        data: { roles: ['ADMIN'] }
      },
      {
        path: 'loaddiscipline',
        component: LoadPaymentsComponent,
        canActivate: [AuthorizationGuard],
        data: { roles: ['ADMIN'] }
      },
      {
        path: 'loadeleve',
        component: LoadelComponent,
        canActivate: [AuthorizationGuard],
        data: { roles: ['ADMIN'] }
      }
    ]
  }
];








@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: [ AuthGuard],
})
export class AppRoutingModule { }
