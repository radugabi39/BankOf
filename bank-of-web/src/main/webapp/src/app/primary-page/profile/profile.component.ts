import { User } from './models/userModel';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

private obj:User=new User("adasd","adasd","adasd","adasd","adasd","adasd");
  constructor() { }

  ngOnInit() {
  }

}
