import { ToastModel } from './../profile/models/toastModel';
import { TransactionTableAdminModel } from './model/transactionTableModel';
import { TransactionTableModel } from './../transaction/model/transactionTableModel';

import { Account } from '../account/models/accountModel';

import { UserModel } from './../profile/models/userModel';
import { GlobalService } from './../../global.functions';
import { Injectable } from "@angular/core";
import 'rxjs/Rx';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { url } from '../../global';
import { newURL } from '../../global';

@Injectable()
export class AdminTransactionService {

    constructor(private http: Http, private globalService: GlobalService) {

    }
    getAdminTransactionsByAccNo(accNo: String) {
        return this.http.get(url + 'transaction/getAdminTransactionsByAccNo/' + accNo, { headers: this.globalService.headers })
            .map(res => TransactionTableModel.fromJSONArray(this.globalService.extractData(res)))
            .catch(err => this.globalService.handleError(err));
    }
    reverseTransaction(trans: TransactionTableModel) {
        return this.http.post(url + 'transaction/reverseTransaction/', JSON.stringify(trans), { headers: this.globalService.headers })
            .map(this.globalService.extractData)
            .catch(err => this.globalService.handleError(err));
    }    
     popToast(toastm:ToastModel){
           this.globalService.popToast(toastm); 
    }
}