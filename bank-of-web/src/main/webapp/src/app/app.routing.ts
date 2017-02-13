import { LoginComponent } from './user-authentification/login/login.component';
import { RegisterComponent } from './user-authentification/register/register.component';
import { Routes, RouterModule } from '@angular/router';
 

 
const appRoutes: Routes = [
    // { path: '', component: HomeComponent, canActivate: [AuthGuard] },
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegisterComponent },
 
    // otherwise redirect to home
    { path: '**', redirectTo: '' }
];
 
export const routing = RouterModule.forRoot(appRoutes);