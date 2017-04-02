import { GlobalService } from './../global.functions';

import { Injectable } from "@angular/core";
import 'rxjs/Rx';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { url } from './../global';

@Injectable()
export class PrimaryPageService {

    constructor(private http: Http, private globalService: GlobalService) {

    }

        getProfileImage() {
        return this.http.get(url + 'user/getProfileImage/' , { headers: this.globalService.headers })
            .map(this.globalService.extractData);
    }

  
}