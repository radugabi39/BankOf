import { BalanceModel } from './models/balance.model';
import { AccountService } from './account.component.service';
import { ViewChild, Component, OnInit, Output, EventEmitter, ElementRef } from '@angular/core';
import { Account } from './models/accountModel';
@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {

  items: Array<Account> = new Array<Account>();
  @Output()
  refresh: EventEmitter<any> = new EventEmitter();
  @Output()
  openDetails: EventEmitter<any> = new EventEmitter();
  openAccount: Account;
  openDialogTrigger: Boolean = false;
  balanceModel: BalanceModel;
  constructor(private accountService: AccountService) { }

  ngOnInit() {
    this.accountService.getAccounts().subscribe(
      data => {
        this.items = data;
      },
      err => console.log("error"),
      () => console.log('Random Quote Complete')
    );

  }
  refreshAccount(data) {
    let acc: Account = data.detail;
    this.accountService.getAccountByNo(acc.number).subscribe(
      data => {

        let clone = this.deepClone(this.items);
        let itemFound: Account = clone.filter(obj => acc.number === obj["number"])[0];
        let indexFound = clone.indexOf(itemFound);

        clone[indexFound] = data[0]
        this.items = clone;
      },
      err => console.log("error"),
      () => console.log('Random Quote Complete')
    );

  }


  openDetailsDialog(data) {
    let acc: Account = data.detail;
    this.openAccount = acc;

    this.accountService.getInOutcomeFromLastMonths(1, acc.number).subscribe(
      data => {
        this.balanceModel = data;
        this.openDialogTrigger = true;
      },
      err => console.log("error"),
      () => console.log('Random Quote Complete')
    );

  }

  deepClone(oldArray: Object[]) {
    let newArray: any = [];
    oldArray.forEach((item) => {
      newArray.push(Object.assign({}, item));
    });
    return newArray;
  }
}
