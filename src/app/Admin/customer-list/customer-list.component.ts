import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/Services/admin.service';
import { CustomerDetails } from 'src/app/TSFiles/Registration';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  id: number = 0;
  customerDetailsObj: CustomerDetails = new CustomerDetails();
  isList: boolean = false;
  verified: any;
  referenceid: any;
  check: boolean = true;
  isVerified: boolean= false;

  constructor(private adminService: AdminService) {

    this.ngOnInit();
  }

  ngOnInit(): void {

    this.verified = this.adminService.getStatusData();
    if(this.verified=='Y'){
      this.isVerified=true;
    }
    else {
      this.isVerified= false;
    }
    console.log(this.verified);
    console.log(this.isVerified);
  }

  Details(){
    
    this.customerDetails();
    this.addressDetails();
    this.branchDetails();
    this.accountDetails();

  }

  customerDetails() {
    this.isList = true;

    this.id = this.adminService.getData();
    console.log(this.id + "details");
    this.adminService.getCustomerById(this.id).subscribe((data: any) => {
      this.customerDetailsObj = data;
    });
  }

  addressDetails(){

  }

  branchDetails(){

  }

  accountDetails(){

  }

  approve(){

    this.referenceid = this.adminService.getReferenceData();
    this.verified = this.adminService.getStatusData();
    this.adminService.getStatusByReferenceId(this.referenceid).subscribe((data: any) => {
      this.check = data;
      alert("Approved");
    });


  }

}
