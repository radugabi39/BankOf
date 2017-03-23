import { User } from './models/userModel';
import { Component, OnInit } from '@angular/core';
import { Lightbox, LightboxModule } from 'primeng/primeng';
@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  private obj: User = new User("adasd", "adasd", "adasd", "adasd", "adasd", "adasd","c","city");
  constructor() { }
  private images: any[] = [];  openDialogTrigger: Boolean = false;
  ngOnInit() {
  this.images = [];
    this.images.push({ source: 'assets/images/me.jpg', thumbnail: 'assets/images/me.jpg', title: 'Sopranos 1' });
  }
openDetailsDialog(data) {

        this.openDialogTrigger = true;
}

}
