
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
      .map(this.globalService.extractData);
  }
}