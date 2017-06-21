import { ToastModel } from './models/toastModel';
import { Observable } from 'rxjs/Observable';
import { ProfileService } from './profile.component.service';
import { UserModel } from './models/userModel';
import { Component, OnInit } from '@angular/core';
import { Lightbox, LightboxModule } from 'primeng/primeng';
import { key } from './../../global';
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
        this.profileService.popToast(new ToastModel("User details saved", false))
      },
      err => this.profileService.popToast(new ToastModel("Failed to save user details", true)),
      () => console.log('Random Quote Complete')
    );
  }
  customizeRequest(data) {
    data["xhr"].setRequestHeader('Authorization', key());
    this.profileService.popToast(new ToastModel("Failed to change profiel picture", false))
  }
  onComplete(data) {
    this.obj["imageURL"] = JSON.parse(data["xhr"].responseText)["data"];
    this.profileService.subject.next(this.obj["imageURL"]);
    this.profileService.popToast(new ToastModel("Profile picture changed", false))
  }


  changePass() {
    if (this.newPass !== this.repPass) {
      this.profileService.popToast(new ToastModel("Passwords dosen't match", true))
    } else
    { this.message = ""; }
    this.profileService.changePassword(this.newPass, this.currPass).subscribe(
      data => {
        this.message = data["data"];
        if (data["data"] == "") {
          this.profileService.popToast(new ToastModel("Password changed", false))
        }
        else {
          this.profileService.popToast(new ToastModel("Failed to change the password", true))
        }
      },
      err => this.profileService.popToast(new ToastModel("Failed to change the password", true)),
      () => console.log('Random Quote Complete')
    );
  }

}
