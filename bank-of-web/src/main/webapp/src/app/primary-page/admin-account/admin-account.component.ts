import { FullAccount } from './models/fullAccountModel';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin-account',
  templateUrl: './admin-account.component.html',
  styleUrls: ['./admin-account.component.css']
})
export class AdminAccountComponent implements OnInit {
  private dialogAccountDetailsTrigger:boolean=false;
  constructor() { }
  obj:FullAccount=new FullAccount("23","23",12,"23",true,"23",1312)
  ngOnInit() {
   
  }
search(data){
this.dialogAccountDetailsTrigger=true
  // after search wait 1 sec with background image
}
}
