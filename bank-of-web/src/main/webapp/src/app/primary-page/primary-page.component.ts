import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-primary-page',
  templateUrl: './primary-page.component.html',
  styleUrls: ['./primary-page.component.css']
})
export class PrimaryPageComponent implements OnInit {

  private customer:Boolean=false;
  constructor() { }

  ngOnInit() {
  }

}
