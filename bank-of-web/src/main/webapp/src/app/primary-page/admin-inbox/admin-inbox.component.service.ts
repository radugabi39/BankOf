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
        return this.http.get(url + 'task/getPendingTasks/' , { headers: this.globalService.headers })
            .map(res => TaskModel.fromJSONArray(this.globalService.extractData(res)));
    }
    claimTask(id:Number) {
        return this.http.post(url + 'task/claimTask/',id , { headers: this.globalService.headers })
            .map(this.globalService.extractData);
    }
        approveTask(id:Number) {
        return this.http.post(url + 'task/approveTask/',id , { headers: this.globalService.headers })
            .map(this.globalService.extractData);
    }

  
}