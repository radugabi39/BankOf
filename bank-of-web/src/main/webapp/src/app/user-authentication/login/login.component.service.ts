

import { setKey } from './../../global';
import { Injectable } from "@angular/core";
import 'rxjs/Rx';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
@Injectable()
export class LoginService {

  constructor(private http: Http) { }

  tryLogin(username: String, password: String) {
  return  this.http.post('http://localhost:8080/bank-of-rest/login', { "username": username, "password": password })
      .map(this.extractData);

  }
  private extractData(res: Response) {
    let body;

    if(res.status==200){
        let authToken=res.headers.get("Authorization")
        setKey(authToken.substring(7,authToken.length))

    }
    if (res.text()) {
        body = res.json();
    }

    return body || {};
}
}