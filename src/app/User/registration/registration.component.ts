import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/app/Services/user.service';
import { CustomerDetails } from 'src/app/TSFiles/Registration';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css'],
  providers: [DatePipe]
})
export class RegistrationComponent implements OnInit {

  registerForm: FormGroup;
  submitted: boolean = false;		
  today: Date = new Date();
  todayStr:string = "";					
  //invalidLogin: boolean = false;	

websiteList: any = ['Service', 'Self-Employed', 'Business', 'Student', 'Other'];

  constructor(private formBuilder: FormBuilder, private router: Router,private custService: UserService, private datePipe: DatePipe) { 
    // this.todayStr = this.today;
    // this.todayStr = this.datePipe.transform(this.today, 'yyyy-MM-dd');
  }

  ngOnInit(): void {

    console.log(this.today);

    this.registerForm = this.formBuilder.group({
      firstName: ['', [Validators.required, Validators.pattern('^[a-zA-Z]+$')]],
      middleName: ['', [Validators.pattern('^[a-zA-Z]+$')]],
      lastName: ['', [Validators.required, Validators.pattern('^[a-zA-Z]+$')]],
      dob: ['', [Validators.required]],
      gender: ['', [Validators.required]],
      occupation: ['', [Validators.required]],
      annualIncome: ['', [Validators.required]],
      contactNumber: ['', [Validators.required]],
      emailId:['',[Validators.required]],
    });
  }
 

  changeWebsite(e: { target: { value: any; }; }) {
    console.log(e.target.value);
  }

  
  CustomerDetails: CustomerDetails = new CustomerDetails();
  firstName:string="";
  middleName:string="";
  lastName:string="";
  
  newCustomer(): void {
    this.submitted = false;
    this.CustomerDetails = new CustomerDetails();
  }
  
 save() {
   
  this.CustomerDetails.customerName = this.firstName + " " + this.lastName;
  console.log("save() "+this.firstName + this.lastName);
  this.custService.newCustomer(this.CustomerDetails)
     .subscribe(data => console.log(data), error => console.log(error));
     this.CustomerDetails = new CustomerDetails();
     console.log("customer added" + this.CustomerDetails);
     this.router.navigate(['/address']);	
  }

  onSubmit() {
    this.submitted = true;
      this.save();
      //console.log("customer")
  }


}
