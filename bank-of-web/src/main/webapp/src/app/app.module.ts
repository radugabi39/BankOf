import { routing } from './app.routing';
import { AppComponent } from './app.component';
import { NgModule,CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { PolymerElement } from '@vaadin/angular2-polymer';
import { LoginComponent } from './user-authentication/login/login.component';
import { RegisterComponent } from './user-authentication/register/register.component';
import { UserAuthenticationComponent } from './user-authentication/user-authentication.component';

@NgModule({
  imports: [ BrowserModule,routing ],
  declarations: [
    AppComponent,
    PolymerElement('paper-input'),    
    PolymerElement('paper-card'),
    PolymerElement('paper-button'),
    PolymerElement('paper-tabs'),
    PolymerElement('paper-material'),
   PolymerElement('paper-toolbar'),
   PolymerElement('paper-tab'),
      PolymerElement('iron-pages'),
    LoginComponent,
    RegisterComponent,
    UserAuthenticationComponent
    
  ],
  providers: [  ],
  bootstrap: [ AppComponent ],
  schemas: [ CUSTOM_ELEMENTS_SCHEMA ]
})
export class AppModule { }