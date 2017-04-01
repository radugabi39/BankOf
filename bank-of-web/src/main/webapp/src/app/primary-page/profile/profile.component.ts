import { ProfileService } from './profile.component.service';
import {  UserModel } from './models/userModel';
import { Component, OnInit } from '@angular/core';
import { Lightbox, LightboxModule } from 'primeng/primeng';
@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  private obj: UserModel;
  constructor(private profileService: ProfileService) { }
  private images: any[] = []; openDialogTrigger: Boolean = false;
  private currPass: String;
  private newPass: String;
  private repPass: String;
  private message: String;
  ngOnInit() {
    this.images = [];
    this.images.push({ source: 'assets/images/me.jpg', thumbnail: 'assets/images/me.jpg', title: 'Sopranos 1' });
    this.profileService.getCurrentUserData().subscribe(
      data => {
        this.obj = data
      },
      err => console.log("error"),
      () => console.log('Random Quote Complete')
    );

  }

  openDetailsDialog(data) {
    this.openDialogTrigger = true;
  }

  saveUserData() {
    this.profileService.saveUserData(this.obj.address, this.obj.phone).subscribe(
      data => {

      },
      err => console.log("error"),
      () => console.log('Random Quote Complete')
    );
  }

  changePass() {
    if (this.newPass !== this.repPass) {
      this.message = "Passwords dosen't match";
    } else
    { this.message = ""; }
    this.profileService.changePassword(this.newPass, this.currPass).subscribe(
      data => {
          this.message=data["data"];
      },
      err => console.log("error"),
      () => console.log('Random Quote Complete')
    );
  }

}
