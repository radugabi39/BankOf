import { PrimaryPageService } from './primary-page.component.service';
import { AdminInboxService } from './admin-inbox/admin-inbox.component.service';
import { AdminTransactionService } from './admin-transaction/admin-transaction.component.service';
import { AdminAccountService } from './admin-account/admin-account.component.service';
import { AdminUserService } from './admin-user/admin-user.component.service';
import { ProfileService } from './profile/profile.component.service';
import { BrowserModule } from '@angular/platform-browser';
import { ContactService } from './contact/contact.component.service';
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
import { DataTableModule, SharedModule, ListboxModule, StepsModule, InputTextareaModule, DropdownModule,CalendarModule,LightboxModule, FileUploadModule } from 'primeng/primeng';
import { GMapModule } from 'primeng/primeng';
import { ProfileComponent } from './profile/profile.component';
import { AdminUserComponent } from './admin-user/admin-user.component';
import { AdminAccountComponent } from './admin-account/admin-account.component';
import { AdminTransactionComponent } from './admin-transaction/admin-transaction.component';
import { AdminInboxComponent } from './admin-inbox/admin-inbox.component';
import { FormsModule } from "@angular/forms";
@NgModule({
  imports: [
    CommonModule, routing,BrowserModule ,FormsModule, DataTableModule, ListboxModule, InputTextareaModule, GMapModule, StepsModule, DropdownModule,CalendarModule ,LightboxModule, FileUploadModule
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
        PolymerElement('paper-menu-button'),
    PolymerElement('paper-icon-item'), PolymerElement('paper-radio-button'),
    PolymerElement('paper-radio-group'), PolymerElement('gold-cc-cvc-input'), PolymerElement('gold-cc-input'), PolymerElement('paper-toggle-button'),
    ContactComponent,
    AccountComponent,
    PayComponent,
    TransactionComponent,
    ProfileComponent,
    AdminUserComponent,
    AdminAccountComponent,
    AdminTransactionComponent,
    AdminInboxComponent
  ], schemas: [CUSTOM_ELEMENTS_SCHEMA], providers: [AccountService, TransactionService, PayService, ContactService,ProfileService,AdminUserService,AdminAccountService,AdminTransactionService,AdminInboxService,PrimaryPageService]
})
export class PrimaryPageModule { }
