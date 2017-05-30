

import { setKey } from './../../global';
import { Injectable } from "@angular/core";
import 'rxjs/Rx';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { GlobalService } from "app/global.functions";

@Injectable()
export class LoginService {

  constructor(private http: Http,private globalService:GlobalService) { }

  tryLogin(username: String, password: String) {
  return  this.http.post('http://localhost:8080/bank-of-rest/login', { "username": username, "password": password })
      .map(this.loginHeader);

  }

    checkIfUserIsEmp(username: String) {
  return  this.http.get('http://localhost:8080/bank-of-rest/user/checkIfUserIsEmployee/'+username, { headers: this.globalService.headers })
      .map(this.globalService.extractData);

  }


    public loginHeader(res: Response) {
        let body;
        let key:String=res.headers.get("Authorization")
       setKey(key.substr(7,key.length))
        // check if empty, before call json

        if (res.text()) {
            body = res.json();
        }

        return body || {};
    }
 
}