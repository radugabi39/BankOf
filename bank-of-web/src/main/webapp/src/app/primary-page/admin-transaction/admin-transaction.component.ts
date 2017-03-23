import { TransactionTableModel } from './../transaction/model/transactionTableModel';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin-transaction',
  templateUrl: './admin-transaction.component.html',
  styleUrls: ['./admin-transaction.component.css']
})
export class AdminTransactionComponent implements OnInit {
    tableData: TransactionTableModel[];
 private dialogTransactionGridDetailsTrigger:boolean=false;
  constructor() { }

  ngOnInit() {
    this.tableData=[];
    this.tableData.push(new TransactionTableModel("fr","toacc",new Date(),"descr","transstatus","transtype",123));
    this.tableData.push(new TransactionTableModel("fr","toacc",new Date(),"descr","transstatus","transtype",123));
  }
search(data){
this.dialogTransactionGridDetailsTrigger=true;
  // after search wait 1 sec with background image
}

  
testFunc(data){
this.dialogTransactionGridDetailsTrigger=true;
  // after search wait 1 sec with background image
}
}
