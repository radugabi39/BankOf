import { TransactionTableModel } from './../transaction/model/transactionTableModel';
import { AdminAccountService } from './admin-account.component.service';
import { FullAccount } from './models/fullAccountModel';
import { Component, OnInit } from '@angular/core';
import { Observable } from "rxjs/Observable";

@Component({
  selector: 'app-admin-account',
  templateUrl: './admin-account.component.html',
  styleUrls: ['./admin-account.component.css']
})
export class AdminAccountComponent implements OnInit {
  private dialogAccountDetailsTrigger: boolean = false;
  private accNoToSearch: String;
  constructor(private adminAccountService: AdminAccountService) { }
  private obj: FullAccount;
  private currencyItems: String[];
  private accountStatusItems: String[];
  private accountTypeItems: String[];
  c: Number;
  ngOnInit() {

  }
  search(data) {

    // after search wait 1 sec with background image 
    // this.adminAccountService.getNomData("Currency").subscribe(
    //   data => {
    //   this.currencyItems=data["data"];

    //   },
    //   err => console.log("error"),
    //   () => console.log('Random Quote Complete')
    // );
    // this.adminAccountService.getNomData("AccountType").subscribe(
    //   data => {
    //   this.accountTypeItems=data["data"];
    //   },
    //   err => console.log("error"),
    //   () => console.log('Random Quote Complete')
    // );
    // this.adminAccountService.getNomData("AccountStatus").subscribe(
    //   data => {
    //     this.accountStatusItems=data["data"];
    //   },
    //   err => console.log("error"),
    //   () => console.log('Random Quote Complete')
    // );
    // this.adminAccountService.getAccountByNo(this.accNoToSearch).subscribe(
    //   data => {
    //     this.obj = data;
    //     this.dialogAccountDetailsTrigger = true;

    //   },
    //   err => console.log("error"),
    //   () => console.log('Random Quote Complete')
    // );




    Observable.forkJoin(

      this.adminAccountService.getAccountByNo(this.accNoToSearch),
      this.adminAccountService.getNomData("AccountStatus"),
      this.adminAccountService.getNomData("AccountType"), this.adminAccountService.getNomData("Currency")
    ).subscribe(res => {
      this.obj = res[0];
      this.accountTypeItems = res[2]["data"];
      this.accountStatusItems = res[1]["data"];
      this.currencyItems = res[3]["data"];
      this.dialogAccountDetailsTrigger = true;

    }
      );






  }

  setCurrency(data) {
    let curr: string = data.detail;
    this.obj.currency = curr;
  }
  setType(data) {
    let type: string = data.detail;
    this.obj.type = type;
  }
  setStatus(data) {
    let status: string = data.detail;
    this.obj.status = status;
  }

   saveChanges() {
   
    this.adminAccountService.saveAccountDetails(this.obj).subscribe(
      data => {
      },
      err => console.log("error"),
      () => console.log('Random Quote Complete')
    );
  }

     removeAccount() {
   
    this.adminAccountService.removeAccount(this.accNoToSearch).subscribe(
      data => {
      },
      err => console.log("error"),
      () => console.log('Random Quote Complete')
    );
  }
}
