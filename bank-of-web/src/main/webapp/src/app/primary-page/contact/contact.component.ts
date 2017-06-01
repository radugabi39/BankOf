import { ToastModel } from './../profile/models/toastModel';
import { BranchLocationModel } from './../account/models/branchLocationModel';
import { ContactService } from './contact.component.service';
import { Component, OnInit } from '@angular/core';
import { InputTextarea } from 'primeng/primeng';
import { Message } from "primeng/components/common/api";

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
  overlays: any[] = [];
  msgs: Message[] = [];
  infoWindow: any;
  constructor(private contactService: ContactService) {

  }

  ngOnInit() {
    this.options = {
      center: { lat: 44.426767, lng: 26.102538 },
      zoom: 8
    };


  }
  openLocationDialog() {
    this.openDialogTrigger = true;
    this.infoWindow = new  window["google"].maps.InfoWindow();
    let context = this
    this.contactService.getBranchLocation().subscribe(
      data => {
        for (let obj of data) {
          context.overlays.push(new window["google"].maps.Marker({ position: { lat: obj["lat"], lng: obj["long"] }, title: obj["name"] }));
        }
      },
      err =>    this.contactService.popToast(new ToastModel("Failed to get branch location", true)),
      () => console.log('Random Quote Complete'));

    window.setTimeout(function () {

      context.resetMap = true;



    }, 100)
  }
  closeDialog() {
    this.openDialogTrigger = false;
    this.resetMap = false;
  }

  sendEmail() {
    this.contactService.sendEmail(this.subject, this.body).subscribe(
      data => {
        this.contactService.popToast(new ToastModel("Email sent", false))
      },
      err =>    this.contactService.popToast(new ToastModel("Failed to send the email", true)),
      () => console.log('Random Quote Complete')
    );
  }
  handleOverlayClick(event) {
    this.msgs = [];
    let isMarker = event.overlay.getTitle != undefined;

    if (isMarker) {
      let title = event.overlay.getTitle();
      this.infoWindow.setContent('' + title + '');
      this.infoWindow.open(event.map, event.overlay);
      event.map.setCenter(event.overlay.getPosition());

      this.msgs.push({ severity: 'info', summary: 'Marker Selected', detail: title });
    }
    else {
      this.msgs.push({ severity: 'info', summary: 'Shape Selected', detail: '' });
    }
  }
}
