import { ToastModel } from './../profile/models/toastModel';
import { TaskModel } from './models/taskModel';

import { Account } from '../account/models/accountModel';

import { UserModel } from './../profile/models/userModel';
import { GlobalService } from './../../global.functions';
import { Injectable } from "@angular/core";
import 'rxjs/Rx';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { url } from '../../global';
import { newURL } from '../../global';

@Injectable()
export class AdminInboxService {

    constructor(private http: Http, private globalService: GlobalService) {

    }

    getPendingTasks() {
        return this.http.get(url + 'task/getPendingTasks/', { headers: this.globalService.headers })
            .map(res => TaskModel.fromJSONArray(this.globalService.extractData(res)))
            .catch(err => this.globalService.handleError(err));
    }
    getUserName() {
        return this.http.get(url + 'user/getUserName/', { headers: this.globalService.headers })
            .map(this.globalService.extractData)
            .catch(err => this.globalService.handleError(err));
    }
    claimTask(id: Number) {
        return this.http.post(url + 'task/claimTask/', id, { headers: this.globalService.headers })
            .map(this.globalService.extractData)
            .catch(err => this.globalService.handleError(err));
    }
    approveTask(id: Number) {
        return this.http.post(url + 'task/approveTask/', id, { headers: this.globalService.headers })
            .map(this.globalService.extractData)
            .catch(err => this.globalService.handleError(err));
    }
    rejectTask(id: Number) {
        return this.http.post(url + 'task/rejectTask/', id, { headers: this.globalService.headers })
            .map(this.globalService.extractData)
            .catch(err => this.globalService.handleError(err));
    }

    getKey() {
        return this.globalService.getKey();
    }
     popToast(toastm:ToastModel){
           this.globalService.popToast(toastm); 
    }
}