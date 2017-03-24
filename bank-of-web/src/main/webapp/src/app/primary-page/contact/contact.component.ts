import { ContactService } from './contact.component.service';
import { Component, OnInit } from '@angular/core';
import { InputTextarea } from 'primeng/primeng';
@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {
  body: String = "tests";
  subject: String = "";
  openDialogTrigger: Boolean = false; 
  options: any; 
  resetMap: Boolean = false;

  constructor(private contactService:ContactService) { }

  ngOnInit() {
    this.options = {
      center: { lat: 36.890257, lng: 30.707417 },
      zoom: 8
    };
  }
  openLocationDialog() {
    this.openDialogTrigger = true;
    let context = this
    window.setTimeout(function () {
      context.resetMap = true;
    }, 100)
  }
  closeDialog() {
    this.openDialogTrigger = false;
    this.resetMap = false;
  }

    sendEmail() {
        this.contactService.sendEmail(this.subject,this.body).subscribe(
      data => {
        var c=1
      },
      err => console.log("error"),
      () => console.log('Random Quote Complete')
    );
  }
}
