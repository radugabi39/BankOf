import { CardModel } from './models/cardModel';
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

  items: Array<Account> = new Array<Account>(); cardItems: Array<CardModel> = new Array<CardModel>();
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
  selectedAccToSave: Account;
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

  settingsAccount(data) {
    this.selectedAccToSave = data.detail;
this.openSettingsDialogTrigger=true;


  }
saveAccount(data){
    this.accountService.saveAccount(this.selectedAccToSave.number,this.selectedAccToSave.limit,this.selectedAccToSave.smsAlert).subscribe(
      data => {
          this.openSettingsDialogTrigger=false;
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
    this.accountService.getCards().subscribe(
      data => {
        this.cardItems = data;
      },
      err => console.log("error"),
      () => console.log('Random Quote Complete')
    );
    
  }
}
