import { FullAccount } from './models/fullAccountModel';
import { Account } from '../account/models/accountModel';

import { UserModel } from './../profile/models/userModel';
import { GlobalService } from './../../global.functions';
import { Injectable } from "@angular/core";
import 'rxjs/Rx';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { url } from '../../global';
import { newURL } from '../../global';

@Injectable()
export class AdminAccountService {

    constructor(private http: Http, private globalService: GlobalService) {

    }

    getAccountByNo(accNo: String) {
        return this.http.get(url + 'account/getAccountByNo/' + accNo, { headers: this.globalService.headers })
            .map(res => FullAccount.fromJSONObj(this.globalService.extractData(res)));
    }
    getNomData(nom: String) {
        return this.http.get(url + 'utils/getNomData/' + nom, { headers: this.globalService.headers })
            .map(this.globalService.extractData);
    }
    saveAccountDetails(inp: FullAccount) {
        return this.http.post(url + 'account/saveAccountDetails/', JSON.stringify(inp), { headers: this.globalService.headers })
            .map(this.globalService.extractData);
    }

       removeAccount(accNo: String) {
        return this.http.post(url + 'account/removeAccount/' ,accNo, { headers: this.globalService.headers })
            .map(this.globalService.extractData);
    }
}