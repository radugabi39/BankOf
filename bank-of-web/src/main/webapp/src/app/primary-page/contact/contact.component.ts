import { Component, OnInit } from '@angular/core';
import { InputTextarea } from 'primeng/primeng';
@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {
  body: String = "";
  subject: String = "";
  openDialogTrigger: Boolean = false; 
  options: any; 
  resetMap: Boolean = false;

  constructor() { }

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
}
