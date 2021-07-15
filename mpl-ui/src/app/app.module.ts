import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {ReactiveFormsModule} from '@angular/forms'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { ListBiensComponent } from './components/list-biens/list-biens.component';
import { AccueilComponent } from './components/accueil/accueil.component';
import { MenuComponent } from './layouts/menu/menu.component';
import { ListeLocataireComponent } from './components/liste-locataire/liste-locataire.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ListBiensComponent,
    AccueilComponent,
    MenuComponent,
    ListeLocataireComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
