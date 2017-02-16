import { Component, OnInit } from '@angular/core';
import {Account} from './models/accountModel';
@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {
items:Array<Account>=new Array<Account>();
test:String="asdasd";
  constructor() { }

  ngOnInit() {
    let sad= new Account("nume",123,"currency",321,"type");
    let sad2= new Account("nume",123,"currency",321,"type");
    this.items.push(sad);
    this.items.push(sad2);
  }

}
