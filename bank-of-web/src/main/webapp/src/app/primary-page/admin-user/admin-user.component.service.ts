import { CountryCityModel } from './models/CountryCityModel';
import { UserModel } from './../profile/models/userModel';
import { GlobalService } from './../../global.functions';
import { Injectable } from "@angular/core";
import 'rxjs/Rx';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { url } from '../../global';
import { newURL } from '../../global';

@Injectable()
export class AdminUserService {

    constructor(private http: Http, private globalService: GlobalService) {

    }

    getUserDataByCNP(cnp: String) {
        return this.http.get(url + 'user/getUserDataByCNP/' + cnp, { headers: this.globalService.headers })
            .map(res => UserModel.fromJSONObj(this.globalService.extractData(res)));
    }

    saveUserDataAdm(outObj: UserModel) {
        return this.http.post(url + 'user/saveUserDataAdm/', JSON.stringify(outObj), { headers: this.globalService.headers })
            .map(this.globalService.extractData);
    }
    resetPassword(cnp: String) {
        return this.http.get(url + 'user/resetPassword/' + cnp, { headers: this.globalService.headers })
            .map(this.globalService.extractData);
    }

      getCountryCityMapping() {
        return this.http.get(url + 'utils/getCountryCityMapping/', { headers: this.globalService.headers })
            .map(res => CountryCityModel.fromJSONArray(this.globalService.extractData(res)));
    }
}