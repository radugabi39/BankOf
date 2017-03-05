import { AccountComponent } from './primary-page/account/account.component';
import { PayComponent } from './primary-page/pay/pay.component';
import { TransactionComponent } from './primary-page/transaction/transaction.component';
import { ContactComponent } from './primary-page/contact/contact.component';
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
     { path: 'primaryPage', component: PrimaryPageComponent,children:[
            { path: 'account', component: AccountComponent },
            { path: 'pay', component: PayComponent },
            { path: 'transaction', component: TransactionComponent },
            { path: 'contact', component: ContactComponent }
        ] },
 
    // otherwise redirect to home
    { path: '**', redirectTo: '' }
];
 
export const routing = RouterModule.forRoot(appRoutes);