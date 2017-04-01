import { AdminTransactionService } from './admin-transaction.component.service';
import { TransactionTableModel } from './../transaction/model/transactionTableModel';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin-transaction',
  templateUrl: './admin-transaction.component.html',
  styleUrls: ['./admin-transaction.component.css']
})
export class AdminTransactionComponent implements OnInit {
  tableData: TransactionTableModel[];
  private accNoToSearch: String;
  private dialogTransactionGridDetailsTrigger: boolean = false;
  constructor(private adminTransactionService: AdminTransactionService) { }

  ngOnInit() {

  }
  search(data) {

    this.adminTransactionService.getAdminTransactionsByAccNo(this.accNoToSearch).subscribe(
      data => {
            this.tableData = data;
        this.dialogTransactionGridDetailsTrigger = true;
      },
      err => console.log("error"),
      () => console.log('Random Quote Complete')
    );
  }


  reverseTransaction(data) {

    this.adminTransactionService.reverseTransaction(    data).subscribe(
      data => {

      },
      err => console.log("error"),
      () => console.log('Random Quote Complete')
    );
    // after search wait 1 sec with background image
  }
}
