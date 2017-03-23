import { User } from './../profile/models/userModel';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin-user',
  templateUrl: './admin-user.component.html',
  styleUrls: ['./admin-user.component.css']
})
export class AdminUserComponent implements OnInit {
  private dialogUserDetailsTrigger:boolean=false;
    private obj: User = new User("adasd", "adasd", "adasd", "adasd", "adasd", "adasd","c","city");
  constructor() { }

  ngOnInit() {
  }
search(data){
this.dialogUserDetailsTrigger=true
  // after search wait 1 sec with background image
}
}
