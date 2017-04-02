import { key } from './global';
import { Injectable } from "@angular/core";
import 'rxjs/Rx';
import { Http, Response, Headers, RequestOptions } from '@angular/http';

@Injectable()
export class GlobalService {
    public headers: Headers = new Headers();
    constructor(private http: Http) {
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