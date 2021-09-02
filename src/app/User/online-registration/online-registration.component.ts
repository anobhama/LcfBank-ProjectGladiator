import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/app/Services/user.service';
import { LoginCredentials } from 'src/app/TSFiles/logincredentials';

@Component({
  selector: 'app-online-registration',
  templateUrl: './online-registration.component.html',
  styleUrls: ['./online-registration.component.css']
})
export class OnlineRegistrationComponent implements OnInit {

  registerForm: FormGroup;
  onlineObj: LoginCredentials = new LoginCredentials();
  submitted = false;
  customerId: any;
  constructor(private formBuilder: FormBuilder, private router: Router,private userService:UserService) { }

  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({
      customerId: ['', [Validators.required]],
      loginPassword: ['', [Validators.required]],
      transactionPin: ['', [Validators.required]],
      
  });
  }
  
  netBankingRegistration(): void {
    this.submitted = false;
    this.onlineObj = new LoginCredentials();
  }
  
 save() {
   
   this.userService.netBankingRegistration(this.onlineObj)
     .subscribe(data => 
      {
        console.log(data);
        this.customerId=data;
        alert("Customer Id"+data);

      }, error => console.log(error));
     this.onlineObj = new LoginCredentials();
     console.log(" registartion done" + this.onlineObj);
     this.router.navigate(['']);	
  }
  onSubmit() {
   this.submitted = true;
     this.save();
     
    
 }

}
