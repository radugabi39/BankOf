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

    // check if empty, before call json
    if (res.text()) {
        body = res.json();
    }

    return body || {};
}
}