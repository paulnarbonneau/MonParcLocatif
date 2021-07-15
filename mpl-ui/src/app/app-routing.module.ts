import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AccueilComponent } from './components/accueil/accueil.component';
import { ListBiensComponent } from './components/list-biens/list-biens.component';
import { LoginComponent } from './components/login/login.component';


const routes: Routes = [

  {
    path : 'login',
    component : LoginComponent
  },
  {
    path : 'biens',
    component : ListBiensComponent
  },
  {
    path : '',
    component : AccueilComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
