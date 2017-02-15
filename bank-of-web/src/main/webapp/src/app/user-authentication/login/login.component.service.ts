import { Injectable } from "@angular/core";
import 'rxjs/Rx';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
@Injectable()


export class LoginService {
    private commentsUrl = 'http://localhost:8080/bank-of-rest/login';
    constructor(private http: Http) { }
    tryLogin(username: String, password: String): any{




  this.http.post('http://localhost:8080/bank-of-rest/login', { "username": username, "password": password  })
    .map(res => res.text())
    .subscribe(
      data => console.log("gata"),
      err => console.log("error"),
      () => console.log('Random Quote Complete')
    );
    }
}