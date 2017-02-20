import { AccountService } from './account/account.component.service';
import { routing } from './../app.routing';
import { PolymerElement } from '@vaadin/angular2-polymer';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PrimaryPageComponent } from './primary-page.component';
import { ContactComponent } from './contact/contact.component';
import { AccountComponent } from './account/account.component';
import { CardComponent } from './card/card.component';
import { TransactionComponent } from './transaction/transaction.component';

@NgModule({
  imports: [
    CommonModule, routing
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
    PolymerElement('app-toolbar'),
    PolymerElement('iron-list'),
    PolymerElement('paper-dialog'),

    ContactComponent,
    AccountComponent,
    CardComponent,
    TransactionComponent
  ], schemas: [CUSTOM_ELEMENTS_SCHEMA], providers: [AccountService]
})
export class PrimaryPageModule { }
