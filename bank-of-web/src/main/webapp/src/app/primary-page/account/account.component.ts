import { Card } from './models/cardModel';
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

  items: Array<Account> = new Array<Account>(); cardItems: Array<Card> = new Array<Card>();
  @Output()
  refresh: EventEmitter<any> = new EventEmitter();
  @Output()
  openDetails: EventEmitter<any> = new EventEmitter();
  openAccount: Account;
  openDialogTrigger: Boolean = false;
  balanceModel: BalanceModel;
  sliderValue: Number = 1; private showAc: Boolean = true;
  private showCa: Boolean = false;
  openSettingsDialogTrigger:Boolean=false;
  constructor(private accountService: AccountService) { }

  ngOnInit() {        this.items.push(new Account("23","23",12,"23",true,"23"));      this.items.push(new Account("23","23",12,"23",true,"23"));
    this.accountService.getAccounts().subscribe(
      data => {
        this.items = data;
      },
      err => console.log("error"),
      () => console.log('Random Quote Complete')
    );
    
        this.cardItems.push(new Card('Random Quote Complete', new Date(), 33, 'Random Quote Complete', 'ad','type-image')); 
            this.cardItems.push(new Card('Random Quote Complete', new Date(), 33, 'Random Quote Complete', 'Random Quote Complete','123')); 
                this.cardItems.push(new Card('Random Quote Complete', new Date(), 33, 'Random Quote Complete', 'Random Quote Complete','type-image')); 
                    this.cardItems.push(new Card('Random Quote Complete', new Date(), 33, 'Random Quote Complete', 'Random Quote Complete','123')); 
                        this.cardItems.push(new Card('Random Quote Complete', new Date(), 33, 'Random Quote Complete', 'Random Quote Complete','123')); 
                            this.cardItems.push(new Card('Random Quote Complete', new Date(), 33, 'Random Quote Complete', 'Random Quote Complete','123')); 
                            
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

  settingsAccount(data) {
    let acc: Account = data.detail;
this.openSettingsDialogTrigger=true;

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
  recalculateIncome() {
    if (this.sliderValue != 0) {
      this.accountService.getInOutcomeFromLastMonths(this.sliderValue, this.openAccount.number).subscribe(
        data => {
          this.balanceModel = data;
        },
        err => console.log("error"),
        () => console.log('Random Quote Complete')
      );
    } else {
      this.balanceModel = null;
    }
  }
  deepClone(oldArray: Object[]) {
    let newArray: any = [];
    oldArray.forEach((item) => {
      newArray.push(Object.assign({}, item));
    });
    return newArray;
  }
  showAccounts() {
    if (this.showAc == false) {
      this.showCa = false;
      this.showAc = true;
    }

  }
  showCards() {
    if (this.showCa == false) {
      this.showCa = true;
      this.showAc = false;
    }

  }
}
