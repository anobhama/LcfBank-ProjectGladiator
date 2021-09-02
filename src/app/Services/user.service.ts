import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseUrl="http://localhost:8090/banking/lcf/user-page";

  constructor(private http:HttpClient) { }

  
  insertAddress(address : Object): Observable<Object> {
    console.log(this.http.post(`${this.baseUrl}`+'/register/address-details', address))
    return this.http.post(`${this.baseUrl}`+'/register/address-details', address);
   }

   getAddressById(addressId :any)
   {
    return this.http.get<any[]>(this.baseUrl + '/user-profile/address-details/' + addressId);
   }
   getCustomerById(customerId : any)
   {
        return this.http.get<any[]>(this.baseUrl + '/user-profile/personal-details/' + customerId);
   }
   insertAccount(account : Object): Observable<Object> {
    console.log(this.http.post(`${this.baseUrl}`+'/register/account-details', account))
    return this.http.post(`${this.baseUrl}`+'/register/account-details', account);
   }
   
   newCustomer(CustomerDetails : Object): Observable<Object> {
    console.log(this.http.post(`${this.baseUrl}`+'/register/personal-details', CustomerDetails))
    return this.http.post(`${this.baseUrl}`+'/register/personal-details', CustomerDetails);
   }

  searchAccountByCustomerId(customerId:any){
    console.log(this.http.get(this.baseUrl+'/user-profile/account-details-id/'+ customerId));
    return this.http.get<any[]>(this.baseUrl+'/user-profile/account-details-id/'+ customerId);

  }

   
   insertBranch(BranchDetails : Object): Observable<Object> {
    console.log(this.http.post(`${this.baseUrl}`+'/register/branch-details', BranchDetails))
    return this.http.post(`${this.baseUrl}`+'/register/branch-details', BranchDetails);
   }

   login(loginObj:Object):Observable<Object>
   {
     return this.http.post(`${this.baseUrl}`+'/login',loginObj);
   }


   insertIdentityDocuments(idDoc : Object): Observable<Object> {
  console.log(this.http.post(`${this.baseUrl}`+'/register/identity-details', idDoc))
  return this.http.post(`${this.baseUrl}`+'/register/identity-details', idDoc);
 }

   getIdentityDocumentsById(customerId: any)
   {
    return this.http.get<any[]>(this.baseUrl + '/user-profile/identity-details/' + customerId);
   }
  

   netBankingRegistration(onlineObj : Object): Observable<Object> {
    console.log(this.http.post(`${this.baseUrl}`+'/register/net-banking', onlineObj))
    return this.http.post(`${this.baseUrl}`+'/register/net-banking', onlineObj);
   }


   commitTransaction(transactionObj : Object): Observable<Object> {
    console.log(this.http.post(`${this.baseUrl}`+'/funds-transfer', transactionObj))
    return this.http.post(`${this.baseUrl}`+'/funds-transfer', transactionObj);
   }

   generateSummary(customerId:any)
   {
     console.log(this.http.get<any[]>(this.baseUrl + '/summary/' + customerId));
    return this.http.get<any[]>(this.baseUrl + '/summary/' + customerId);
   }

   isVerified(referenceId:any)
   {
    console.log(this.http.get<any[]>(this.baseUrl + '/check-status/' + referenceId));
    return this.http.get<any[]>(this.baseUrl + '/check-status/' + referenceId);
   }

   resetPassword()
   {
     
   }
  custId:any;
  getCustId():any
  {
    console.log("get" + this.custId);
    return this.custId;
 
  }

  setCustId(custId:any)
  {
    console.log("set b4" + this.custId);
    this.custId=custId;
    console.log("set after" + this.custId);
  }

  accNo:any;
  getAccNo():any
  {
    console.log("get" + this.accNo);
    return this.accNo;
 
  }

  setAccNo(accNo:any)
  {
    console.log("set b4" + this.accNo);
    this.accNo=accNo;
    console.log("set after" + this.accNo);
  }

  data:any;
  getData():any
  {
    console.log("get" + this.data);
    return this.data;
 
  }

  setData(data:any)
  {
    console.log("set b4" + this.data);
    this.data=data;
    console.log("set after" + this.data);
  }

}
