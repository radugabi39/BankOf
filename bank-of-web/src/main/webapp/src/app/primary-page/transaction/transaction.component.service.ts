import { TransactionTableModel } from './model/transactionTableModel';
import { Injectable } from '@angular/core';
import 'rxjs/Rx';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { url } from '../../global';
import { newURL } from '../../global';
import { GlobalService } from './../../global.functions';

@Injectable()
export class TransactionService {

    
  constructor(private http: Http,private globalService:GlobalService) {

  }
  getTransactionsByAccNo(accNo:String) {
    return this.http.get(url + 'transaction/getTransactionsByAccNo/'+accNo, { headers: this.globalService.headers })
      .map(res => TransactionTableModel.fromJSONArray(this.globalService.extractData(res)));
  }
}