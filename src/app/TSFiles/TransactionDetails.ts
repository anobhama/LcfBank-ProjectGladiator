export class TransactionDetails
{
    transactionId:number| undefined;
    benefactorAccNumber:number| undefined;
    beneficiaryAccNumber:number| undefined;
    beneficiaryAccountInfo:string="";
    amount:number| undefined;
    dateOfTransaction:string="";
    modeOfTransaction:string="";
    status:string="Completed";
    remarks:string="";
}