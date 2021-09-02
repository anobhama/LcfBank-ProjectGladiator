import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/Services/admin.service';
import { VerificationStatus } from 'src/app/TSFiles/VerificationStatus';

@Component({
  selector: 'app-verification-status',
  templateUrl: './verification-status.component.html',
  styleUrls: ['./verification-status.component.css']
})
export class VerificationStatusComponent implements OnInit {

  referenceList: VerificationStatus[] = [];
  customerId: number = 0 ;
  id: any;
  id1: any;
  verified: any;
  referenceId: any;
  id2: any;
  verify: any;
  isVerified: boolean =false;

  constructor(private adminService:AdminService) { }

  ngOnInit(): void {
    this.loadData();
  }

  
  loadData() {
    this.adminService.displayAll().subscribe(
      (data:VerificationStatus[]) => {
        this.referenceList = data;
      }
    );
  }

  inspect(customerId: number, referenceId: number, verified: string){
    this.customerId = customerId;
    this.referenceId= referenceId;
    this.verified = verified;
    console.log(this.customerId);
    console.log(this.referenceId);
    console.log(this.verified);
    this.adminService.setData(this.customerId);
    this.adminService.setReferenceData(this.referenceId);
    this.adminService.setStatusData(this.verified);
    this.id1 = this.adminService.getData();
    this.id2 = this.adminService.getReferenceData();
    this.verify = this.adminService.getStatusData();
    console.log(this.id2);

    if(this.verified=='Y'){
      this.isVerified=true;
    }
  }

}
