import { ToastModel } from './../../primary-page/profile/models/toastModel';
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
  private textToast: String;
  private open: Boolean = false
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
            if (data["data"] == false) {
              this.router.navigateByUrl('/primaryPage/account')
            } else {
              this.router.navigateByUrl('/primaryPage/adminUser')
            }

          },
          err => this.primaryPageService.popToast(new ToastModel("Failed to check user role", true)),
          () => console.log('Random Quote Complete')
        );;

      },
      err => {

        this.textToast = "Login failed! Please check the email and password!"
        this.open = true;

      },
      () => console.log('Random Quote Complete')
    );;
  }

}
