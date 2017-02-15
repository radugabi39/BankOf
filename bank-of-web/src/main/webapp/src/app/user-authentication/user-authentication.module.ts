import { routing } from './../app.routing';
import { PolymerElement } from '@vaadin/angular2-polymer';
import { SharedModule } from './../shared.module';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserAuthenticationComponent } from './user-authentication.component';

@NgModule({
  imports: [
    CommonModule,routing
  ],
  declarations: [LoginComponent,UserAuthenticationComponent,
    RegisterComponent,    PolymerElement('paper-input'),    
    PolymerElement('paper-card'),
    PolymerElement('paper-button'),
    PolymerElement('paper-tabs'),
    PolymerElement('paper-tab'),
    ],
  schemas: [ CUSTOM_ELEMENTS_SCHEMA ]
})
export class UserAuthenticationModule { }
