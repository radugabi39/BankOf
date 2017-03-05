import { Router } from '@angular/router';
import { PayService } from './pay.component.service';
import { AccountService } from './../account/account.component.service';
import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { StepsModule, MenuItem, SelectItem } from 'primeng/primeng';
@Component({
  selector: 'app-pay',
  templateUrl: './pay.component.html',
  styleUrls: ['./pay.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class PayComponent implements OnInit {

  constructor(private accountService: AccountService, private payService: PayService, private r: Router) { }
  private items: MenuItem[];
  private destinationAcc: String;
  private transactionDescr: String;
  private selItem: String;
  private amount: Number;
  private transIndex: any = 0;
  private accounts: SelectItem[];
  private firstPage: Boolean = true;
  private donePage: Boolean = false;
  private status: String;

  ngOnInit() {
    this.items = [
      { label: 'Payment info' },
      { label: 'Payment details' }
    ];
    this.accountService.getActiveAccounts().subscribe(
      data => {
        this.accounts = [];
        this.accounts.push({ label: "", value: "" });
        for (let obj in data["data"]) {
          this.accounts.push({ label: data["data"][obj], value: data["data"][obj] });
        }

      },
      err => console.log("error"),
      () => console.log('Random Quote Complete')
    );
  }
  done() {
    this.destinationAcc = "";
    this.selItem = "";
    this.transactionDescr = "";
        this.status = "";
    this.amount = null;
    this.firstPage = true;
    this.donePage = false;
    this.transIndex = 0;
  }
  next() {
    this.firstPage = false;
    this.transIndex = 1;
  }
  back() {
    this.firstPage = true;
    this.transIndex = 0;
  } finish() {
    this.payService.tryTransfer(this.amount, this.destinationAcc, this.selItem, this.transactionDescr).subscribe(
      data => {
        this.donePage = true;
        this.status = data["data"];
      },
      err => {
        this.donePage = true;
        this.status = "Error while transfering";
        console.log("error")
      },
      () =>
        console.log('Random Quote Complete')
    );;
  }

  accountChanged(event) {
    this.selItem = event.value;
  }
}
