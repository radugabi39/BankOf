import { routing } from './app.routing';
import { AppComponent } from './app.component';
import { NgModule,CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { PolymerElement } from '@vaadin/angular2-polymer';
import { LoginComponent } from './user-authentification/login/login.component';
import { RegisterComponent } from './user-authentification/register/register.component';

@NgModule({
  imports: [ BrowserModule,routing ],
  declarations: [
    AppComponent,
    PolymerElement('paper-input'),
    LoginComponent,
    RegisterComponent
    
  ],
  providers: [  ],
  bootstrap: [ AppComponent ],
  schemas: [ CUSTOM_ELEMENTS_SCHEMA ]
})
export class AppModule { }