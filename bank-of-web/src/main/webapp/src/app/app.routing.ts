import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './user-authentification/login/login.component';
import { RegisterComponent } from './user-authentification/register/register.component';

 

 
const appRoutes: Routes = [
    { path: '', component: LoginComponent },
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegisterComponent },
 
    // otherwise redirect to home
    { path: '**', redirectTo: '' }
];
 
export const routing = RouterModule.forRoot(appRoutes);