import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdminTemplateComponent } from './admin-template/admin-template.component';

// Import Angular Material Modules
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatMenuModule } from '@angular/material/menu';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';
import { MatCardModule } from '@angular/material/card';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatDividerModule } from '@angular/material/divider';

// Import Reactive Forms Module
import { ReactiveFormsModule } from '@angular/forms';

// Import Components
import { ProfileComponComponent } from './profile-compon/profile-compon.component';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { StudensComponent } from './studens/studens.component';
import { PaymentsComponent } from './payments/payments.component';
import { ActualitesComponent } from './actualites/actualites.component';
import { MenusComponent } from './menus/menus.component';
import { DisciplinesComponent } from './disciplines/disciplines.component';
import { DocumentsComponent } from './documents/documents.component';
import { MessageriesComponent } from './messageries/messageries.component';
import { ReclamationsComponent } from './reclamations/reclamations.component';
import { HomeComponent } from './home/home.component';
import { NotesComponent } from './notes/notes.component';
import { MoyennesComponent } from './moyennes/moyennes.component';
import { LoadPaymentsComponent } from './load-payments/load-payments.component';
import { LoadacttualitesComponent } from './loadacttualites/loadacttualites.component';
import { LoaddisciplinesComponent } from './loaddisciplines/loaddisciplines.component';
import { LoadelComponent } from './loadel/loadel.component';


// Import AuthService and AuthGuard
import { AuthService } from './services/auth.service';
import { AuthGuard } from './guards/auth.guard';
import { StupayComponent } from './stupay/stupay.component';
import {HttpClientModule} from "@angular/common/http";
import { NewpayComponent } from './newpay/newpay.component';
import {MatDatepicker, MatDatepickerInput, MatDatepickerToggle} from "@angular/material/datepicker";
import {MatNativeDateModule} from "@angular/material/core";
import {MatSelect, MatSelectModule} from "@angular/material/select";

@NgModule({
  declarations: [
    AppComponent,
    AdminTemplateComponent,
    ProfileComponComponent,
    LoginComponent,
    DashboardComponent,
    StudensComponent,
    PaymentsComponent,
    ActualitesComponent,
    MenusComponent,
    DisciplinesComponent,
    DocumentsComponent,
    MessageriesComponent,
    ReclamationsComponent,
    HomeComponent,
    NotesComponent,
    MoyennesComponent,
    LoadPaymentsComponent,
    LoadacttualitesComponent,
    LoaddisciplinesComponent,
    LoadelComponent,
    NewpayComponent,

  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    ReactiveFormsModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    // Angular Material Modules
    MatToolbarModule,
    MatButtonModule,
    MatIconModule,
    MatMenuModule,
    MatSidenavModule,
    MatListModule,
    MatCardModule,
    MatDividerModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatInputModule,
    MatFormFieldModule,
    MatDatepickerInput,
    MatDatepickerToggle,
    MatNativeDateModule,
    MatDatepicker,
    MatSelectModule
  ],
  providers: [AuthService, AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
