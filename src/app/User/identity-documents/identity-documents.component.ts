import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/app/Services/user.service';
import { IdentityDocuments } from 'src/app/TSFiles/IdentificationDocuments';

@Component({
  selector: 'app-identity-documents',
  templateUrl: './identity-documents.component.html',
  styleUrls: ['./identity-documents.component.css']
})
export class IdentityDocumentsComponent implements OnInit {

  registerForm: FormGroup;
  idDoc: IdentityDocuments = new IdentityDocuments();
  submitted = false;

  constructor(private formBuilder: FormBuilder, private router: Router,private userService: UserService) { 

  }
  ngOnInit() {

    this.registerForm = this.formBuilder.group({
      aadharNumber: ['', [Validators.required]],
      pan: ['', [Validators.required]],
      
  });
}
  
insertIdentityDocuments(): void {
    this.submitted = false;
    this.idDoc = new IdentityDocuments();
  }
  
 save() {
   
   this.userService.insertIdentityDocuments(this.idDoc)
     .subscribe(data => 
      {
        console.log(data);
        alert("Reference Id " + data);
      }, error => console.log(error));
     
     this.idDoc = new IdentityDocuments();

     console.log("Identity Documents added" + this.idDoc);
    
     this.router.navigate(['']);	
  }
  onSubmit() {
   this.submitted = true;
   this.idDoc.customerId=this.userService.getCustId();
     this.save();
     
    
 }

}
