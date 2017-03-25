import { GlobalService } from './../../global.functions';
import { Injectable } from "@angular/core";
import 'rxjs/Rx';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { url } from '../../global';
import { newURL } from '../../global';

@Injectable()
export class PayService {

  constructor(private http: Http,private globalService:GlobalService) {

  }

    tryTransfer(amount:Number,destAcc:String,fromAccount:String,transDescription:String,dateToPay:Date,provider:String) {
    return this.http.post(url + 'transaction/tryTransfer/',{"amount":amount,"fromAccount":fromAccount,"destAccount":destAcc,"transDescription":transDescription,"dateToPay":dateToPay,"provider":provider,}, { headers: this.globalService.headers })
      .map(this.globalService.extractData);
  }
}