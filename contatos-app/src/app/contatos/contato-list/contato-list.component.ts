import { Component, OnInit } from '@angular/core';
import {ContatoService} from '../contato.service';
@Component({
  selector: 'app-contato-list',
  templateUrl: './contato-list.component.html',
  styleUrls: ['./contato-list.component.css']
})
export class ContatoListComponent implements OnInit {

  contatos = [];
  constructor(private service:ContatoService) { }

  ngOnInit() {
    this.service.buscarContatos()
    .subscribe(data => this.contatos = data);
  }

}
