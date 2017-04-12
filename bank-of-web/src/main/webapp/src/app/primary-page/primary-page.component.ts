import { PrimaryPageService } from './primary-page.component.service';
import { Component, OnInit } from '@angular/core';
import { setKey } from './../global';
@Component({
  selector: 'app-primary-page',
  templateUrl: './primary-page.component.html',
  styleUrls: ['./primary-page.component.css']
})
export class PrimaryPageComponent implements OnInit {

  private customer:Boolean=false          ;
  private profileImage:String;
  constructor(private primaryPageService:PrimaryPageService) {

    this.customer=primaryPageService.getUserCustomer();
   }

  ngOnInit() {

         this.primaryPageService.getProfileImage().subscribe(
        data => {
     
          this.profileImage = data["data"]; 

        },
        err => console.log("error"),
        () => console.log('Random Quote Complete')
      );
  }
logout(){
  setKey("")
}
}
