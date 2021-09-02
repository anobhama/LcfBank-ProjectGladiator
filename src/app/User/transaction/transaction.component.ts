import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/app/Services/user.service';
import { TransactionDetails } from 'src/app/TSFiles/TransactionDetails';

@Component({
  selector: 'app-transaction',
  templateUrl: './transaction.component.html',
  styleUrls: ['./transaction.component.css']
})
export class TransactionComponent implements OnInit {
  transactionForm: FormGroup;
  submitted: boolean = false;									

  transactionObj: TransactionDetails = new TransactionDetails();

  paymentModeList:any = ['NEFT','IMPS','RTGS']

  constructor(private formBuilder: FormBuilder, private router: Router,private userService: UserService) { }

  ngOnInit(): void {

    this.transactionObj.benefactorAccNumber = this.userService.getAccNo();

    this.transactionForm = this.formBuilder.group({
      beneficiaryAccountInfo: ['', [Validators.required, Validators.pattern('^[a-zA-Z]+$')]],
      beneficiaryAccNumber: ['', [Validators.required]],
      benefactorAccNumber: ['', [Validators.required]],
      amount: ['', [Validators.required]],
      modeOfTransaction: ['', [Validators.required]],
      transactionId: ['', [Validators.required]],
      remarks: ['', [Validators.required]]

    });
  }
 

  paymentMode(e: { target: { value: any; }; }) {
    console.log(e.target.value);
  }

  
  
  commitTransaction(): void {
    this.submitted = false;
    this.transactionObj = new TransactionDetails();
  }
  
 save() {
   
   this.userService.commitTransaction(this.transactionObj)
     .subscribe(data =>{
       console.log(data);
       if(data===0 || data===-1 || data ===-2)
       {
         alert("Transaction Failed!");
       }
       else{
       alert("Transaction Successfull!");
       }
      }, error => console.log(error));
     this.transactionObj = new TransactionDetails();
     console.log("transaction done" + this.transactionObj);
     this.router.navigate(['/dashBoard']);	
  }

  onSubmit() {
    this.submitted = true;
      this.save();
      console.log("suceess")
  }
}
