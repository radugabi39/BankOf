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
    this.transactionService.getTransactionsByAccNo(event.value).subscribe(
      data => {
        this.tableData = data;
      },
      err => console.log("error"),
      () => console.log('Random Quote Complete')
    );
  }
}
