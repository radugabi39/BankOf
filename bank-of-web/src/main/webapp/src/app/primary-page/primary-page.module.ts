import { PolymerElement } from '@vaadin/angular2-polymer';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PrimaryPageComponent } from './primary-page.component';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [PrimaryPageComponent,
    PolymerElement('paper-input'),    
    PolymerElement('paper-card'),
    PolymerElement('paper-button'),
    PolymerElement('paper-tabs'),
    PolymerElement('paper-tab'),
    PolymerElement('paper-toolbar'),
     PolymerElement('paper-scroll-header-panel'),
     PolymerElement('paper-icon-button'),
       PolymerElement('app-header'),
       PolymerElement('app-toolbar')
     ],schemas:[CUSTOM_ELEMENTS_SCHEMA]
})
export class PrimaryPageModule { }
