import { Component, OnInit } from '@angular/core';
import {ContatoService} from '../contato.service';
import {Contato} from '../contato';
@Component({
  selector: 'app-contato-list',
  templateUrl: './contato-list.component.html',
  styleUrls: ['./contato-list.component.css']
})
export class ContatoListComponent implements OnInit {

  contatos:Array<Contato> = [];
  constructor(private service:ContatoService) { }

  ngOnInit() {
   this.loadData();
  }

  loadData(){
    this.service.buscarContatos()
    .subscribe(data => this.contatos = data);
  }

  remover(id:any){
    const ok = confirm("Deseja realmente remover o contato com id "+ id+" ?");
    if(ok){
      this.service.remover(id)
      .subscribe(
      ()=>{
        this.loadData();
      }
      );
    }
  }

}
