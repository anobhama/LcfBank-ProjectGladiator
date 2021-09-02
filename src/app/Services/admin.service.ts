import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  baseUrl: string = "http://localhost:8090/banking/lcf/admin-page";
  data: any;
  data1: any;
  data2: any;


  constructor(private http:HttpClient) { }

  displayAll(){
    return this.http.get<any[]>(this.baseUrl + '/verification-status-list');
  }

  getCustomerById(customerId: number){
    return this.http.get<any[]>(this.baseUrl + '/customer-details/' + customerId);
  }

  getStatusByReferenceId(referenceId: number){
    return this.http.get<any[]>(this.baseUrl + '/verification-status/' + referenceId);
  }

  getData(): any {
    console.log(this.data);
    return this.data;
  }

  setData(data: any){
    this.data = data;
    console.log(this.data);
  }

  getReferenceData() {
    return this.data1;
  }

  setReferenceData(data1: any) {
    this.data1 = data1;
    console.log(this.data1);
  }

  getStatusData() {
    return this.data2;
  }

  setStatusData(data2: any) {
    this.data2 = data2;
    console.log(this.data2);
  }
}
