import { CountryCityModel } from './models/CountryCityModel';
import { BalanceModel } from './../account/models/balance.model';
import { AdminUserService } from './admin-user.component.service';
import { UserModel } from './../profile/models/userModel';

import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin-user',
  templateUrl: './admin-user.component.html',
  styleUrls: ['./admin-user.component.css']
})
export class AdminUserComponent implements OnInit {
  private dialogUserDetailsTrigger: boolean = false;
  private cnpToSearch: String;
  private countryItems: Array<String> = new Array<String>();
  private cityItems: Array<String> = new Array<String>();
  private obj: UserModel;
  private cityMapping: CountryCityModel[];
  private items: BalanceModel[];
  private testasdasd: Boolean = true;
  constructor(private adminUserService: AdminUserService) { }

  ngOnInit() {
    this.items = [];


  }
  search(data) {
    this.countryItems = []
    this.cityItems = []
    // after search wait 1 sec with background image
    let context = this;

    this.adminUserService.getUserDataByCNP(this.cnpToSearch).subscribe(
      data => {
        this.obj = data;

        this.adminUserService.getCountryCityMapping().subscribe(
          data => {
            this.cityMapping = data;
            for (let obj of this.cityMapping) {
              context.cityItems.push(obj.city);
              context.countryItems.push(obj.country);
            }
            this.countryItems = this.countryItems.filter(function (elem, index, self) {
              return index == self.indexOf(elem);
            })
            this.cityItems = this.deepClone(this.cityItems);
            this.countryItems = this.deepClone(this.countryItems);
            this.dialogUserDetailsTrigger = true;

          },
          err => console.log("error"),
          () => console.log('Random Quote Complete')
        );
      },
      err => console.log("error"),
      () => console.log('Random Quote Complete')
    );
  }
  saveChanges() {
    this.adminUserService.saveUserDataAdm(this.obj).subscribe(
      data => {
      },
      err => console.log("error"),
      () => console.log('Random Quote Complete')
    );
  }

  resetPassword() {
    this.adminUserService.resetPassword(this.cnpToSearch).subscribe(
      data => {
      },
      err => console.log("error"),
      () => console.log('Random Quote Complete')
    );
  } deepClone(oldArray: Object[]) {
    let newArray: Array<String> = new Array<String>();
    oldArray.forEach((item) => {
      newArray.push(item.toString());
    });
    return newArray;
  }
  deepClone2(oldArray: Object) {
    let newArray: Object;

    newArray = Object.assign({}, oldArray)
    return newArray;
  }
  setCity(data) {
    let city: string = data.detail;
    this.obj.city = city;
  } setCountry(data) {
    let cnt: string = data.detail, resetCnt = true;

    this.cityItems = []
    for (let obj of this.cityMapping) {
      if (obj.country == cnt) {
        if (this.obj.city == obj.city) {
          resetCnt = false;
        }
        this.cityItems.push(obj.city);
      }

    }

    if (resetCnt) {
      this.obj.city = ""
    }
  }
}
