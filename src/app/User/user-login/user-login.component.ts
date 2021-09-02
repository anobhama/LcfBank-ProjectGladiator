import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/app/Services/user.service';
import { LoginCredentials } from 'src/app/TSFiles/logincredentials';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {

  loginForm: FormGroup;
  submitted: boolean = false;
  validLogin: boolean = false;

  loginObj: LoginCredentials = new LoginCredentials();

  constructor(private formBuilder: FormBuilder, private router: Router, private userService: UserService) { }

  ngOnInit(): void {

    this.loginForm = this.formBuilder.group({
      customerId: ['', Validators.required],
      loginPassword: ['', Validators.required]
    });

  }
  onSubmit() {
    this.submitted = true;
    this.userService.setCustId(this.loginObj.customerId);
    this.userService.setData(this.loginObj.loginPassword);
    console.log("on submit"+this.loginObj.customerId)
    console.log("on submit"+this.loginObj.loginPassword)
    this.userService.login(this.loginObj)
      .subscribe((data: any) => {
        if (data === 1) {
          this.router.navigate(['dashBoard'])
        }
        else {
          alert("Invalid User");
          this.router.navigate(['/login'])
        }
      }
        , error => console.log(error));
    this.loginObj = new LoginCredentials();
    //this.userService.setData(this.loginObj.customerId);
  }
}
