import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import  { Router, ActivatedRoute } from '@angular/router';
import {ContatoService} from '../contato.service';

@Component({
  selector: 'app-contato-form',
  templateUrl: './contato-form.component.html',
  styleUrls: ['./contato-form.component.css']
})
export class ContatoFormComponent implements OnInit {

  contatoForm = this.fb.group({
    id:[''],
    nome: ['', Validators.required],
    email:[ '',[Validators.required,Validators.email]],
    telefone:['']
  });
  constructor(
    private fb:FormBuilder,
    private router:Router,
    private route:ActivatedRoute,
    private service:ContatoService
  ) { }

  ngOnInit() {
    const id = this.route.snapshot.paramMap.get('id');
    if(id && id != 'novo'){
      this.service.buscarContatoPorId(id)
      .subscribe(data =>{
        this.contatoForm.patchValue(data);
      })
    }
  }

  onSubmit(){
    console.log(this.contatoForm.value);
  }

}
