import { UserAuthenticationComponent } from './user-authentication/user-authentication.component';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './user-authentication/login/login.component';
import { RegisterComponent } from './user-authentication/register/register.component';

 

 
const appRoutes: Routes = [
    { path: '', component: UserAuthenticationComponent },
        { path: 'user', component: UserAuthenticationComponent,children:[
            { path: 'login', component: LoginComponent },
            { path: 'register', component: RegisterComponent },
        ] },

 
    // otherwise redirect to home
    { path: '**', redirectTo: '' }
];
 
export const routing = RouterModule.forRoot(appRoutes);