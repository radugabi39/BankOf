import { ProfileService } from './profile/profile.component.service';
import { ProfileComponent } from './profile/profile.component';
import { PrimaryPageService } from './primary-page.component.service';
import { Component, OnInit } from '@angular/core';
import { setKey } from './../global';
@Component({
  selector: 'app-primary-page',
  templateUrl: './primary-page.component.html',
  styleUrls: ['./primary-page.component.css']
})
export class PrimaryPageComponent implements OnInit {

  private customer: Boolean = false;
  private profileImage: String;
  private textToast: String;
  private open: Boolean = false;
  private textToastE: String;
  private openE: Boolean = false;

  constructor(private primaryPageService: PrimaryPageService, private profileService: ProfileService) {

    this.customer = primaryPageService.getUserCustomer();
  }

  ngOnInit() {
    this.profileService.obs.subscribe(value => {
      this.profileImage = value;
    })
    this.profileService.obs.subscribe(value => {
      this.profileImage = value;
    })

    let context = this;
    this.primaryPageService.observ.subscribe(value => {
      if (value) {
        if(value.error){
        context.textToastE = value.text;
        context.openE = true;
        }else{
        context.textToast = value.text;
        context.open = true;
        }
      }
    })
    this.primaryPageService.getProfileImage().subscribe(
      data => {

        this.profileImage = data["data"];

      },
      err => console.log("error"),
      () => console.log('Random Quote Complete')
    );
  }
  logout() {
    setKey("")
  }
}
