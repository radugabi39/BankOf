import { GlobalService } from './../../global.functions';
import { LoginService } from './login.component.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PrimaryPageService } from "app/primary-page/primary-page.component.service";
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private email: String = "";
  private password: String = "";
  constructor(private loginService: LoginService, private router: Router, private globalService: GlobalService, private primaryPageService: PrimaryPageService) { }

  ngOnInit() {
  }
  tryLogin() {
    this.loginService.tryLogin(this.email, this.password).subscribe(
      data => {

        this.globalService.createAuthorizationHeader();
        this.loginService.checkIfUserIsEmp(this.email).subscribe(
          data => {
                    this.primaryPageService.setUserCustomer(data["data"])
     this.router.navigateByUrl('/primaryPage')
       
          },
          err => console.log("error"),
          () => console.log('Random Quote Complete')
        );;

      },
      err => console.log("error"),
      () => console.log('Random Quote Complete')
    );;
  }

}
