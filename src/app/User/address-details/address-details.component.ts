import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/app/Services/user.service';
import { AddressDetails } from 'src/app/TSFiles/addressDetails';

@Component({
  selector: 'app-address-details',
  templateUrl: './address-details.component.html',
  styleUrls: ['./address-details.component.css']
})
export class AddressDetailsComponent implements OnInit {

  registerForm: FormGroup;
  address: AddressDetails = new AddressDetails();
  submitted :boolean= false;
  
  stateList: any = [ 'Andhra Pradesh',
  'Arunachal Pradesh',
  'Assam',
  'Bihar',
  'Chhattisgarh',
  'Goa',
  'Gujarat',
  'Haryana',
  'Himachal Pradesh',
  'Jammu and Kashmir',
  'Jharkhand',
  'Karnataka',
  'Kerala',
  'Madhya Pradesh',
  'Maharashtra',
  'Manipur',
  'Meghalaya',
  'Mizoram',
  'Nagaland',
  'Odisha',
  'Punjab',
  'Rajasthan',
  'Sikkim',
  'Tamil Nadu',
  'Telangana',
  'Tripura',
  'Uttarakhand',
  'Uttar Pradesh',
  'West Bengal',
  'Andaman and Nicobar Islands',
  'Chandigarh',
  'Dadra and Nagar Haveli',
  'Daman and Diu',
  'Delhi',
  'Lakshadweep',
  'Puducherry'
  ];

  changeState(e: { target: { value: any; }; }) {
    console.log(e.target.value);
  }

  constructor(private formBuilder: FormBuilder, private router: Router,private userService: UserService) { }
  ngOnInit() {

    this.registerForm = this.formBuilder.group({
      addressLine1: ['', [Validators.required]],
      addressLine2: ['', [Validators.required]],
      landmark: ['', [Validators.required]],
      city: ['', [Validators.required, Validators.pattern('^[a-zA-Z]+$')]],
      state: ['', [Validators.required, Validators.pattern('^[a-zA-Z]+$')]],
      pinCode: ['', [Validators.required]],
  });
}
  
  insertAddress(): void {
    this.submitted = false;
    this.address = new AddressDetails();
  }
  
 save() {
   
   this.userService.insertAddress(this.address)
     .subscribe(data => 
     {
      this.userService.setCustId(data);
      console.log(data);
     }
     , error => console.log(error));
     this.address = new AddressDetails();
     console.log("address added" + this.address);
     this.router.navigate(['/idDocuments']);	
  }
  onSubmit() {
   this.submitted = true;
     this.save();
     //console.log("address")
 }
}
