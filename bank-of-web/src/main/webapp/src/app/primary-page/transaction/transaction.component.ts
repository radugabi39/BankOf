import { ToastModel } from './../profile/models/toastModel';
import { AccountService } from './../account/account.component.service';
import { TransactionService } from './transaction.component.service';
import { TransactionTableModel } from './model/transactionTableModel';
import { Component, OnInit } from '@angular/core';
import { SelectItem } from 'primeng/primeng'

@Component({
  selector: 'app-transaction',
  templateUrl: './transaction.component.html',
  styleUrls: ['./transaction.component.css']
})
export class TransactionComponent implements OnInit {
  accounts: SelectItem[];
  accNoSelected:String;
  tableData: TransactionTableModel[];
  constructor(private transactionService: TransactionService, private accountService: AccountService) { }

  ngOnInit() {
    this.accountService.getAccountsNo().subscribe(
      data => {
        this.accounts = [];
        for (let obj in data["data"]) {
          this.accounts.push({ label: data["data"][obj], value: data["data"][obj] });
        }

      },
      err => console.log("error"),
      () => console.log('Random Quote Complete')
    );

  }
  accountChanged(event) {
    this.accNoSelected=event.value;
    this.transactionService.getTransactionsByAccNo(event.value).subscribe(
      data => {
        this.tableData = data;
      },
      err => console.log("error"),
      () => console.log('Random Quote Complete')
    );
  }  downloadFile(data){
    var blob = new Blob([(<any>data)], { type: 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet'});
    var url= window.URL.createObjectURL(blob);
    window.open(url);
    console.log();
}
  downloadExcell(){
        this.transactionService.downloadExcell(this.accNoSelected).subscribe(
 data => 
 this.downloadFile(data)),//console.log(data),
                  error =>
                  this.transactionService.popToast(new ToastModel("Failed to download file", true)),
                  () => console.log('Completed file download.');
  }
}
