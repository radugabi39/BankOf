import { PrimaryPageComponent } from './primary-page/primary-page.component';
import { UserAuthenticationComponent } from './user-authentication/user-authentication.component';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './user-authentication/login/login.component';
import { RegisterComponent } from './user-authentication/register/register.component';

 

 
const appRoutes: Routes = [
    { path: '', component: PrimaryPageComponent },
        { path: 'user', component: UserAuthenticationComponent,children:[
            { path: 'login', component: LoginComponent },
            { path: 'register', component: RegisterComponent },
        ] },
     { path: 'primaryPage', component: PrimaryPageComponent },
 
    // otherwise redirect to home
    { path: '**', redirectTo: '' }
];
 
export const routing = RouterModule.forRoot(appRoutes);