import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-authentication',
  templateUrl: './user-authentication.component.html',
  styleUrls: ['./user-authentication.component.css']
})
export class UserAuthenticationComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit() {
  }
   onTabSelect(event, details){    
   this.router.navigate(['/user','login']); };

}
