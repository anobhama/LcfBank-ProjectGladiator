import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/Services/user.service';
import { AccountDetails } from 'src/app/TSFiles/AccountDetails';
import { AddressDetails } from 'src/app/TSFiles/addressDetails';
import { IdentityDocuments } from 'src/app/TSFiles/IdentificationDocuments';
import { LoginCredentials } from 'src/app/TSFiles/logincredentials';
import { CustomerDetails } from 'src/app/TSFiles/Registration';
import { Summary } from 'src/app/TSFiles/Summary';

@Component({
  selector: 'app-dash-board',
  templateUrl: './dash-board.component.html',
  styleUrls: ['./dash-board.component.css']
})
export class DashBoardComponent implements OnInit {

  customerObj: CustomerDetails = new CustomerDetails();

  addressObj: AddressDetails = new AddressDetails();

  identityDocObj: IdentityDocuments = new IdentityDocuments();

  accountObj: AccountDetails = new AccountDetails();

  resetObj: LoginCredentials = new LoginCredentials();


  summaryList: Summary[] = [];

  addressId: any;
  customerId: any;
  newObj : string;


  isHome: boolean = true;
  isUserProfile: boolean = false;
  isTransactionTable: boolean = false;
  isResetPassword: boolean = false;
  isHelp: boolean = false;
  isFundsTransfer: boolean = false;
  isLogout: boolean = false;

  constructor(private router: Router, private userService: UserService) {}

  ngOnInit(): void {
    this.customerId = this.userService.getCustId();

    this.loadData();
  }

  logout() {
    this.isLogout = true;
    this.userService.setCustId(null);
    this.router.navigate(['/login']);
  }

  userProfile() {
    this.isUserProfile = true;
    this.isTransactionTable = false;
    this.isHome = false;
    this.isHelp = false;
    this.isLogout = false;
    this.isResetPassword = false;
    this.isFundsTransfer = false;
  }
  transactionTable() {
    this.isTransactionTable = true;
    this.isUserProfile = false;
    this.isHome = false;
    this.isHelp = false;
    this.isLogout = false;
    this.isResetPassword = false;
    this.isFundsTransfer = false;
  }

  home() {
    this.isHome = true;
    this.isTransactionTable = false;
    this.isUserProfile = false;
    this.isHelp = false;
    this.isLogout = false;
    this.isResetPassword = false;
    this.isFundsTransfer = false;
  }

  transactionTableDisplay() {
    this.userService.generateSummary(this.customerId).subscribe(
      (data: Summary[]) => {
        this.summaryList = data;
        console.log(data);
      },
      (error) => console.log(error)
    );
    console.log('summary Documents fetched' + this.summaryList);
    this.transactionTable();
  }
  userProfileDisplay() {
    this.userProfile();
  }

  loadData() {
    if (this.customerId == null) {
      this.router.navigate(['/login']);
    }
    //this.customerObj = this.userService.getCustomerById(this.customerId);
    console.log('pro b4 ' + this.customerId);
    this.customerId = this.userService.getCustId();
    console.log('pro after ' + this.customerId);
    this.userService.getCustomerById(this.customerId).subscribe((data: any) => {
      this.customerObj = data;
      this.addressId = this.customerObj.permanentAddressId;
      console.log('addressid in' + this.addressId + this.addressObj);

      //this.addressObj= this.userService.getAddressDetailsById(this.addressId);

      this.userService.getAddressById(this.addressId).subscribe((data: any) => {
        this.addressObj = data;
        this.addressId = this.customerObj.permanentAddressId;
      });

      //this.identityDocObj=this.userService.getIdentityDocuments(this.customerId);
      this.userService
        .getIdentityDocumentsById(this.customerId)
        .subscribe((data: any) => {
          this.identityDocObj = data;
        });
    });

    this.userService
      .searchAccountByCustomerId(this.customerId)
      .subscribe((data: any) => {
        console.log('AccountDetails ' + data);
        this.accountObj = data;
        this.userService.setAccNo(this.accountObj.accountNumber);
      });
  }

}
