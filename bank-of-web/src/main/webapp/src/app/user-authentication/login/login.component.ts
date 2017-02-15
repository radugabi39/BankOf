import { LoginService } from './login.component.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private email:String="";
  private password:String="";
  constructor(private loginService:LoginService) { }

  ngOnInit() {
  }
  tryLogin(){
    this.loginService.tryLogin(this.email,this.password);
  }
}
