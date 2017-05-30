import { BranchLocationModel } from './../account/models/branchLocationModel';

import { Injectable } from '@angular/core';
import 'rxjs/Rx';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { url } from '../../global';
import { newURL } from '../../global';
import { GlobalService } from './../../global.functions';

@Injectable()
export class ContactService {

    
  constructor(private http: Http,private globalService:GlobalService) {

  }
  sendEmail(subject:String,body:String) {
    return this.http.post(url + 'utils/sendEmail/',{"subject":subject,"body":body}, { headers: this.globalService.headers })
      .map(this.globalService.extractData)
      .catch(err => this.globalService.handleError(err));
  }
    getBranchLocation() {
    return this.http.get(url + 'contact/getBranchesLocation/', { headers: this.globalService.headers })
          .map(res => BranchLocationModel.fromJSONArray(this.globalService.extractData(res)))
      .catch(err => this.globalService.handleError(err));
  }
}