import { Observable } from 'rxjs/Observable';
import { Router } from '@angular/router';
import { key } from './global';
import { Injectable } from "@angular/core";
import 'rxjs/Rx';
import { Http, Response, Headers, RequestOptions } from '@angular/http';

@Injectable()
export class GlobalService {
    public headers: Headers = new Headers();
    constructor(private http: Http, private router: Router) {
        this.createAuthorizationHeader()
    }
    public extractData(res: Response) {
        let body;

        // check if empty, before call json

        if (res.text()) {
            body = res.json();
        }

        return body || {};
    }
     handleError (error: any) {
        let errMsg = error.message || 'Server error';
        console.error(errMsg); // log to console instead
        if(error.status==403){
                this.router.navigateByUrl('/user/login')
        }
        return Observable.throw(errMsg);
    }
    createAuthorizationHeader() {
          this.headers=new Headers();
        this.headers.append('Authorization', key());
        this.headers.append('Accept', 'application/json');
        this.headers.append('Content-Type', 'application/json');
    }
    getKey():string{
        return key();
    }
}