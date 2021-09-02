import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminHomeComponent } from './Admin/admin-home/admin-home.component';
import { AdminLoginComponent } from './Admin/admin-login/admin-login.component';
import { CustomerListComponent } from './Admin/customer-list/customer-list.component';
import { GetCustomerDetailsComponent } from './Admin/get-customer-details/get-customer-details.component';
import { VerificationStatusComponent } from './Admin/verification-status/verification-status.component';
import { HomeComponent } from './home/home.component';
import { AddressDetailsComponent } from './User/address-details/address-details.component';
import { DashBoardComponent } from './User/dash-board/dash-board.component';
import { IdentityDocumentsComponent } from './User/identity-documents/identity-documents.component';
import { OnlineRegistrationComponent } from './User/online-registration/online-registration.component';
import { RegistrationComponent } from './User/registration/registration.component';
import { TransactionComponent } from './User/transaction/transaction.component';
import { UserLoginComponent } from './User/user-login/user-login.component';

const routes: Routes = [
  {path:"",component:HomeComponent},
  {path:"login", component:UserLoginComponent},
  {path:"address", component:AddressDetailsComponent},
  {path:"dashBoard", component:DashBoardComponent},
  {path:"idDocuments", component:IdentityDocumentsComponent},
  {path:"onlineRegistration", component:OnlineRegistrationComponent},
  {path:"transaction", component:TransactionComponent},
  {path:"admin-login", component:AdminLoginComponent},
  {path:"status/customer-details", component:CustomerListComponent},
  {path:"customer-details", component:GetCustomerDetailsComponent},
  {path:"status", component:VerificationStatusComponent},
  {path:"admin-home", component:AdminHomeComponent},
  {path:"register",component:RegistrationComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
