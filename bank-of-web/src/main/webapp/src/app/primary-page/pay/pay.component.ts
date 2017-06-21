import { ToastModel } from './../profile/models/toastModel';
import { SchedulerModel } from './models/schedulerModel';
import { TransactionTableModel } from './../transaction/model/transactionTableModel';
import { Router } from '@angular/router';
import { PayService } from './pay.component.service';
import { AccountService } from './../account/account.component.service';
import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { StepsModule, MenuItem, SelectItem, CalendarModule } from 'primeng/primeng';
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
  private showTransf: Boolean = true;
  private showBi: Boolean = false;
  private showSched: Boolean = false;
  private monthlyDate: Date;
  private monthlyPay: String = "one"; private provider: String = ""; private en: any;
  private tableData: SchedulerModel[];
  private notAll: Boolean = false;
  ngOnInit() {
    this.en = {
      firstDayOfWeek: 0,
      dayNames: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"],
      dayNamesShort: ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"],
      dayNamesMin: ["Su", "Mo", "Tu", "We", "Th", "Fr", "Sa"],
      monthNames: ["", "", "", "", "", "", "", "", "", "", "", "",],
      monthNamesShort: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"]
    };
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
      err => this.payService.popToast(new ToastModel("Failed to get accounts", true)),
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
  showTransfer() {
    if (this.showTransf == false) {
      this.showBi = false;
      this.showTransf = true;
      this.showSched = false;
    }
    this.notAll = false;
    this.done()
  }
  showBills() {
    if (this.showBi == false) {
      this.showBi = true;
      this.showTransf = false;
      this.showSched = false;
    }
    this.notAll = false;
    this.done()
  }
  showSchedules() {
    if (this.showSched == false) {

      this.payService.getSchedulers().subscribe(
        data => {
          this.showSched = true;
          this.showBi = false;
          this.showTransf = false;
          this.tableData = data;
          this.done()

        },
        err => this.payService.popToast(new ToastModel("Failed to get schedules", true)),
        () => console.log('Random Quote Complete')
      );
    }



  }
  inactivateSchedule(sc: SchedulerModel) {
    this.payService.inactiveSchedule(sc.id).subscribe(
      data => {
        sc["active"] = false;
        this.payService.popToast(new ToastModel("Schedule disabled", false))
      },
      err => this.payService.popToast(new ToastModel("Failed inactivate schedule", true)),
      () => console.log('Random Quote Complete')
    );
  }
  next() {
    if (!this.showBi)
      if (this.selItem && this.destinationAcc && this.amount && this.transactionDescr) {
        this.firstPage = false;
        this.transIndex = 1;
      } else {
        this.notAll = true;
      } else {
      if (this.selItem && this.provider && this.amount && this.transactionDescr) {
        if(this.monthlyPay=="one" || this.monthlyDate){
        this.firstPage = false;
        this.transIndex = 1;
        }else{
        this.notAll = true;  
        }
      } else {
        this.notAll = true;
      }
    }
  }
  back() {
    this.firstPage = true;
    this.transIndex = 0;
  } finish() {
    if (this.monthlyPay == "one") {
      this.monthlyDate = null;
    }
    if (this.showTransf == true) {
      this.monthlyDate = null;
      this.provider = null;
    }
    this.payService.tryTransfer(this.amount, this.destinationAcc, this.selItem, this.transactionDescr, this.monthlyDate, this.provider).subscribe(
      data => {
        this.donePage = true;
        this.status = data["data"];
        if(data["status"]=="OK"){
            this.payService.popToast(new ToastModel("Transfer completed", false)) 
        }else{
            this.payService.popToast(new ToastModel("Failed to complete the transfer", true))
        }
        
      },
      err => {
        this.donePage = true;
        
      
      },
      () =>
        console.log('Random Quote Complete')
    );;
  }

  accountChanged(event) {
    this.selItem = event.value;
  }

}
