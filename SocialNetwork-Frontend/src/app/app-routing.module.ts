import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { Home1Component } from './home1/home1.component';
import { Home2Component } from './home2/home2.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
  
const routes: Routes = [

  { path: '', component:Home1Component},
  { path: 'home2', component:Home2Component},
  { path: 'login', component:LoginComponent},
   { path: 'register', component:RegisterComponent }

];
  
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: []
})
export class AppRoutingModule { }