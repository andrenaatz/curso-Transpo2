import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ContatoListComponent} from './contatos/contato-list/contato-list.component';
import {ContatoFormComponent} from './contatos/contato-form/contato-form.component';

const routes: Routes = [
  {
    path:'contatos',
    component: ContatoListComponent
  },
  {
    path:'contatos/:id',
    component: ContatoFormComponent
  },
  {
    path:'',
    redirectTo:'contatos',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
