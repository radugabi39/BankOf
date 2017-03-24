import { GlobalService } from './global.functions';
import { PrimaryPageModule } from './primary-page/primary-page.module';
import { SharedModule } from './shared.module';
import { UserAuthenticationModule } from './user-authentication/user-authentication.module';
import { LoginService } from './user-authentication/login/login.component.service';
import { routing } from './app.routing';
import { AppComponent } from './app.component';
import { NgModule,CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { PolymerElement } from '@vaadin/angular2-polymer';import { FormsModule } from '@angular/forms';
import { LoginComponent } from './user-authentication/login/login.component';
import { RegisterComponent } from './user-authentication/register/register.component';
import { UserAuthenticationComponent } from './user-authentication/user-authentication.component';
import { HttpModule } from '@angular/http';
@NgModule({
  imports: [ BrowserModule,FormsModule ,routing,HttpModule,UserAuthenticationModule,PrimaryPageModule ],
  declarations: [
    AppComponent
    
  ],
  providers: [ LoginService,GlobalService ],
  bootstrap: [ AppComponent ],
  schemas: [ CUSTOM_ELEMENTS_SCHEMA ]
})
export class AppModule { }