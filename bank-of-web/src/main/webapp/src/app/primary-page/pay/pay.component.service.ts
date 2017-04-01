import { SchedulerModel } from './models/schedulerModel';
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
      getSchedulers() {
    return this.http.get(url + 'transaction/getSchedulers/', { headers: this.globalService.headers })
      .map(res => SchedulerModel.fromJSONArray(this.globalService.extractData(res)));
  }
        inactiveSchedule(id:Number) {
    return this.http.post(url + 'transaction/inactiveSchedule/',id, { headers: this.globalService.headers })
            .map(this.globalService.extractData);
  }
}