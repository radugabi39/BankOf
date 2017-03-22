import { PayService } from './pay/pay.component.service';
import { TransactionService } from './transaction/transaction.component.service';
import { AccountService } from './account/account.component.service';
import { routing } from './../app.routing';
import { PolymerElement } from '@vaadin/angular2-polymer';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PrimaryPageComponent } from './primary-page.component';
import { ContactComponent } from './contact/contact.component';
import { AccountComponent } from './account/account.component';
import { PayComponent } from './pay/pay.component';
import { TransactionComponent } from './transaction/transaction.component';
import { DataTableModule, SharedModule, ListboxModule, StepsModule, InputTextareaModule, DropdownModule,CalendarModule } from 'primeng/primeng';
import { GMapModule } from 'primeng/primeng';
import { ProfileComponent } from './profile/profile.component';
@NgModule({
  imports: [
    CommonModule, routing, DataTableModule, ListboxModule, InputTextareaModule, GMapModule, StepsModule, DropdownModule,CalendarModule
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
    PolymerElement('paper-slider'),
    PolymerElement('paper-listbox'),
    PolymerElement('paper-dropdown-menu'),
    PolymerElement('paper-item'),
    PolymerElement('paper-icon-item'), PolymerElement('paper-radio-button'),
    PolymerElement('paper-radio-group'), PolymerElement('gold-cc-cvc-input'), PolymerElement('gold-cc-input'),
    ContactComponent,
    AccountComponent,
    PayComponent,
    TransactionComponent,
    ProfileComponent
  ], schemas: [CUSTOM_ELEMENTS_SCHEMA], providers: [AccountService, TransactionService, PayService]
})
export class PrimaryPageModule { }
