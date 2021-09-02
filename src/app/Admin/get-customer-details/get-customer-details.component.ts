import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/Services/admin.service';
import { CustomerDetails } from 'src/app/TSFiles/Registration';

@Component({
  selector: 'app-get-customer-details',
  templateUrl: './get-customer-details.component.html',
  styleUrls: ['./get-customer-details.component.css']
})
export class GetCustomerDetailsComponent implements OnInit {

  customerId: number = 0;
  customerDetailsObj: CustomerDetails = new CustomerDetails();
  id: number = 0;
  isList: boolean = false;

  constructor(private adminService: AdminService) { }

  ngOnInit(): void {
  }

  onSearch() {
    
    this.isList = true;
    this.adminService.getCustomerById(this.customerId).subscribe(
      (data: any) => {
        this.customerDetailsObj = data;
      }
    );
  }

}
