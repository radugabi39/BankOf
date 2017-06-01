import { ToastModel } from './models/toastModel';
import { Observable } from 'rxjs/Observable';
import { UserModel } from './models/userModel';
import { GlobalService } from './../../global.functions';
import { Injectable } from "@angular/core";
import 'rxjs/Rx';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { url } from '../../global';
import { newURL } from '../../global';
import { BehaviorSubject } from "rxjs/BehaviorSubject";

@Injectable()
export class ProfileService {

    constructor(private http: Http, private globalService: GlobalService) {

    }
subject = new BehaviorSubject<String>("");
  obs = this.subject
              .asObservable()
              .do(changes => {}); 
    getCurrentUserData() {
        return this.http.get(url + 'user/getCurrentUserData/', { headers: this.globalService.headers })
            .map(res => UserModel.fromJSONObj(this.globalService.extractData(res)))
      .catch(err => this.globalService.handleError(err));
    }

    saveUserData(address: String, phone: String) {
        return this.http.post(url + 'user/saveUserData/', { "address": address, "phone": phone }, { headers: this.globalService.headers })
            .map(this.globalService.extractData)
      .catch(err => this.globalService.handleError(err));
    }

     changePassword(newPass: String, oldPass: String) {
        return this.http.post(url + 'user/changePassword/', { "newPass": newPass, "oldPass": oldPass }, { headers: this.globalService.headers })
            .map(this.globalService.extractData)
      .catch(err => this.globalService.handleError(err));
    }
         popToast(toastm:ToastModel){
           this.globalService.popToast(toastm); 
    }
}