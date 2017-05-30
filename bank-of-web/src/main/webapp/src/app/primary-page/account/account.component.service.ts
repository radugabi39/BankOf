import { CardModel } from './models/cardModel';
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
      .map(res => Account.fromJSONArray(this.globalService.extractData(res)))
        .catch(err => this.globalService.handleError(err));;
  }

   getAccountByNo(accNo:String) {
    return this.http.get(url + 'account/getAccountByNo/'+accNo, { headers: this.globalService.headers })
      .map(res => Account.fromJSONArray(this.globalService.extractData(res)))
           .catch(err => this.globalService.handleError(err));;
  }
  
   getInOutcomeFromLastMonths(months:Number,accNo:String) {
    return this.http.get(url + 'account/getInOutcomeFromLastMonths/'+accNo+'/'+months, { headers: this.globalService.headers })
      .map(res => BalanceModel.fromJSONObj(this.globalService.extractData(res)))
      .catch(err => this.globalService.handleError(err));
      
  }

    getAccountsNo() {
    return this.http.get(url + 'account/getAccountsNo/', { headers: this.globalService.headers })
      .map(this.globalService.extractData)
      .catch(err => this.globalService.handleError(err));
  }
    getActiveAccounts() {
    return this.http.get(url + 'account/getActiveAccounts/', { headers: this.globalService.headers })
      .map(this.globalService.extractData)
      .catch(err => this.globalService.handleError(err));
  }

      getCards() {
    return this.http.get(url + 'card/getCards/', { headers: this.globalService.headers })
       .map(res => CardModel.fromJSONArray(this.globalService.extractData(res)))
      .catch(err => this.globalService.handleError(err));
  }

        saveAccount(accNo:String,limit:Number,smsAlert:Boolean) {
    return this.http.post(url + 'account/saveAccount/',{"accNo":accNo,"limit":limit,"smsAlert":smsAlert}, { headers: this.globalService.headers })
        .map(this.globalService.extractData)
      .catch(err => this.globalService.handleError(err));
  }
  
}