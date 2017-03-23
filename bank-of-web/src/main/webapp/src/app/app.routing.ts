import { AdminUserComponent } from './primary-page/admin-user/admin-user.component';
import { AdminTransactionComponent } from './primary-page/admin-transaction/admin-transaction.component';
import { AdminInboxComponent } from './primary-page/admin-inbox/admin-inbox.component';
import { AdminAccountComponent } from './primary-page/admin-account/admin-account.component';
import { ProfileComponent } from './primary-page/profile/profile.component';
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
    {
        path: 'user', component: UserAuthenticationComponent, children: [
            { path: 'login', component: LoginComponent },
            { path: 'register', component: RegisterComponent },
        ]
    },
    {
        path: 'primaryPage', component: PrimaryPageComponent, children: [
            { path: 'account', component: AccountComponent },
            { path: 'pay', component: PayComponent },
            { path: 'transaction', component: TransactionComponent },
            { path: 'contact', component: ContactComponent },
            { path: 'profile', component: ProfileComponent },
            { path: 'adminAccount', component: AdminAccountComponent },
            { path: 'adminInbox', component: AdminInboxComponent },
            { path: 'adminTransaction', component: AdminTransactionComponent },
            { path: 'adminUser', component: AdminUserComponent }
        ]
    },

    // otherwise redirect to home
    { path: '**', redirectTo: '' }
];

export const routing = RouterModule.forRoot(appRoutes);