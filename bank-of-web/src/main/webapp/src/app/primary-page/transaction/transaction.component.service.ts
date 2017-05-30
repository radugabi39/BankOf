import { Observable } from 'rxjs/Observable';
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
      .map(res => TransactionTableModel.fromJSONArray(this.globalService.extractData(res)))
      .catch(err => this.globalService.handleError(err));
  }

    downloadExcell(accNo:String) : Observable<Object[]> {
        return Observable.create(observer => {
            let xhr = new XMLHttpRequest();
                  let formData: any = new FormData()
            xhr.open('GET', url + 'utils/downloadExcell/'+accNo, true);
            xhr.setRequestHeader('Content-type', 'application/json');
             xhr.setRequestHeader('Authorization', this.globalService.getKey());
            xhr.responseType='blob';

            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4) {
                    if (xhr.status === 200) {

                        var contentType = 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet';
                        var blob = new Blob([xhr.response], { type: contentType });
                        observer.next(blob);
                        observer.complete();
                    } else {
                        observer.error(xhr.response);
                    }
                }
            }
            xhr.send();

        });
      
  }


}