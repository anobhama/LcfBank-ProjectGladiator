import { Component, OnInit } from '@angular/core';
import { UserService } from '../Services/user.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private userService: UserService) {}

  referenceId: any;
  acctNo: any | undefined;
  isVerified: boolean = false;
  search: boolean = false;
  str: string = 'Account verification is pending.';
  str1: string = 'For more information please contact your branch.';

  ngOnInit(): void {
    this.checkStatus = false;
    //this.referenceId=this.userService.getData1();
  }
  onSearch() {
    this.search = true;
    this.userService.isVerified(this.referenceId).subscribe((data) => {
      console.log(data);
      this.acctNo = data;
      if (this.acctNo === 0) {
        this.isVerified = false;
      } 
      else if (this.acctNo === -1) {
        this.isVerified = false;
        this.str = 'Check ReferenceId.';
        this.str1 = '';
      } 
      else {
        this.isVerified = true;
        this.str = 'Congratulations! Account verification is completed.';
        this.str1 = 'Kindly note your A/C No. - ' + this.acctNo;
      }
    });
  }
  checkStatus: boolean = false;
  onCheckStatus() {
    this.checkStatus = true;
  }


}
