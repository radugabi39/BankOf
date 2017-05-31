import { AdminInboxService } from './admin-inbox.component.service';
import { TaskModel } from './models/taskModel';
import { Component, OnInit, OnDestroy } from '@angular/core';
import { $WebSocket } from 'angular2-websocket/angular2-websocket'
import { Subject } from "rxjs/Subject";
import * as SockJS from 'sockjs-client';
import * as Stomp from 'stompjs';


@Component({
  selector: 'app-admin-inbox',
  templateUrl: './admin-inbox.component.html',
  styleUrls: ['./admin-inbox.component.css']
})



export class AdminInboxComponent implements OnInit, OnDestroy {
  stompClient: any;
  private tableData: TaskModel[]; ws: $WebSocket; public messages: Subject<any>;
  constructor(private adminInboxService: AdminInboxService) {

    this.adminInboxService.getUserName().subscribe(
      data => {

        let userName = data["data"];
        let key = this.adminInboxService.getKey();
        console.log("trying to subscribe to ws");
        this.ws = new $WebSocket("ws://localhost:8080/bank-of-rest/reloadTasks?token=" + key + "&userName=" + userName);
        this.ws.send("Hello");
        this.ws.getDataStream().subscribe(
          res => {
            this.tableData = TaskModel.fromJSONArrayWS(JSON.parse(res.data));
          },
          function (e) { console.log('Error: ' + e.message); },
          function () { console.log('Completed'); }
        );
      },
      err => console.log("error"),
      () => console.log('Random Quote Complete')
    );


  }
  ngOnDestroy() {
    if (this.ws)
      this.ws.close();
  }
  ngOnInit() {

    this.adminInboxService.getPendingTasks().subscribe(
      data => {

        this.tableData = data;

      },
      err => console.log("error"),
      () => console.log('Random Quote Complete')
    );
  }
  claimTask(obj: TaskModel) {
    this.adminInboxService.claimTask(obj.id).subscribe(
      data => {

        obj.taskStatus = "CLAIMED";

      },
      err => console.log("error"),
      () => console.log('Random Quote Complete')
    );

  }
  approveTask(obj: TaskModel) {
    this.adminInboxService.approveTask(obj.id).subscribe(
      data => {

        obj.taskStatus = "COMPLETED";

      },
      err => console.log("error"),
      () => console.log('Random Quote Complete')
    );

  }
   rejectTask(obj: TaskModel) {
    this.adminInboxService.rejectTask(obj.id).subscribe(
      data => {

        obj.taskStatus = "REJECTED";

      },
      err => console.log("error"),
      () => console.log('Random Quote Complete')
    );

  }
}
