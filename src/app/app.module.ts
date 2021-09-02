import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdminLoginComponent } from './Admin/admin-login/admin-login.component';
import { AdminHomeComponent } from './Admin/admin-home/admin-home.component';
import { CustomerListComponent } from './Admin/customer-list/customer-list.component';
import { GetCustomerDetailsComponent } from './Admin/get-customer-details/get-customer-details.component';
import { VerificationStatusComponent } from './Admin/verification-status/verification-status.component';
import { AddressDetailsComponent } from './User/address-details/address-details.component';
import { IdentityDocumentsComponent } from './User/identity-documents/identity-documents.component';
import { UserLoginComponent } from './User/user-login/user-login.component';
import { DashBoardComponent } from './User/dash-board/dash-board.component';
import { OnlineRegistrationComponent } from './User/online-registration/online-registration.component';
import { TransactionComponent } from './User/transaction/transaction.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HomeComponent } from './home/home.component';
import { RegistrationComponent } from './User/registration/registration.component';

@NgModule({
  declarations: [
    AppComponent,
    AdminLoginComponent,
    AdminHomeComponent,
    CustomerListComponent,
    GetCustomerDetailsComponent,
    VerificationStatusComponent,
    AddressDetailsComponent,
    IdentityDocumentsComponent,
    UserLoginComponent,
    DashBoardComponent,
    OnlineRegistrationComponent,
    TransactionComponent,
    HomeComponent,
    RegistrationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
