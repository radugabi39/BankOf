import { GlobalService } from './../../global.functions';
import { LoginService } from './login.component.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private email: String = "";
  private password: String = "";
  constructor(private loginService: LoginService, private router: Router, private globalService: GlobalService) { }

  ngOnInit() {
  }
  tryLogin() {
    this.loginService.tryLogin(this.email, this.password).subscribe(
      data => { 
              this.globalService.createAuthorizationHeader();
    this.router.navigateByUrl('/primaryPage')
  },
  err => console.log("error"),
      () => console.log('Random Quote Complete')
    );;
  }
}
