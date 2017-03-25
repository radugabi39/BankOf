import { UserModel } from './models/userModel';
import { GlobalService } from './../../global.functions';
import { Injectable } from "@angular/core";
import 'rxjs/Rx';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { url } from '../../global';
import { newURL } from '../../global';

@Injectable()
export class ProfileService {

    constructor(private http: Http, private globalService: GlobalService) {

    }

    getCurrentUserData() {
        return this.http.get(url + 'user/getCurrentUserData/', { headers: this.globalService.headers })
            .map(res => UserModel.fromJSONObj(this.globalService.extractData(res)));
    }

    saveUserData(address: String, phone: String) {
        return this.http.post(url + 'user/saveUserData/', { "address": address, "phone": phone }, { headers: this.globalService.headers })
            .map(this.globalService.extractData);
    }

     changePassword(newPass: String, oldPass: String) {
        return this.http.post(url + 'user/changePassword/', { "newPass": newPass, "oldPass": oldPass }, { headers: this.globalService.headers })
            .map(this.globalService.extractData);
    }
}