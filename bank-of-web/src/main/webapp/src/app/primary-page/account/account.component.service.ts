import { BalanceModel } from './models/balance.model';
import { GlobalService } from './../../global.functions';
import { Account } from './models/accountModel';
import { Injectable } from "@angular/core";
import 'rxjs/Rx';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { url } from '../../global';
import { newURL } from '../../global';

@Injectable()
export class AccountService {

  constructor(private http: Http,private globalService:GlobalService) {

  }

  getAccounts() {
    return this.http.get(url + 'account/getAccounts/', { headers: this.globalService.headers })
      .map(res => Account.fromJSONArray(this.globalService.extractData(res)));
  }

   getAccountByNo(accNo:String) {
    return this.http.get(url + 'account/getAccountByNo/'+accNo, { headers: this.globalService.headers })
      .map(res => Account.fromJSONArray(this.globalService.extractData(res)));
  }
   getInOutcomeFromLastMonths(months:Number,accNo:String) {
    return this.http.get(url + 'account/getInOutcomeFromLastMonths/'+accNo+'/'+months, { headers: this.globalService.headers })
      .map(res => BalanceModel.fromJSONObj(this.globalService.extractData(res)));
  }
}