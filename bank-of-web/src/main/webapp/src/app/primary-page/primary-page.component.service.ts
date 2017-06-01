import { ToastModel } from './profile/models/toastModel';
import { Observable } from 'rxjs/Observable';
import { GlobalService } from './../global.functions';

import { Injectable } from "@angular/core";
import 'rxjs/Rx';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { url } from './../global';

@Injectable()
export class PrimaryPageService {
     userCustomer:Boolean;
     observ:Observable<ToastModel>;
    constructor(private http: Http, private globalService: GlobalService) {
        this.observ=globalService.obs;
        
    }

        getProfileImage() {
        return this.http.get(url + 'user/getProfileImage/' , { headers: this.globalService.headers })
            .map(this.globalService.extractData)
      .catch(err => this.globalService.handleError(err));
    }

    setUserCustomer(val:Boolean){
        this.userCustomer=val;
    }

    getUserCustomer(){
        return !this.userCustomer;
    }
     popToast(toastm:ToastModel){
           this.globalService.popToast(toastm); 
    }
}