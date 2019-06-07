import { Component, OnInit } from '@angular/core';
import{BrandService} from '../service/brand.service';
import {Brand} from '../models/brand';
import { Observable } from "rxjs";
import {Item} from '../models/item'


@Component({
  selector: 'app-brand',
  templateUrl: './brand.component.html',
  styleUrls: ['./brand.component.css']
})
export class BrandComponent implements OnInit {

  items : Observable<Item[]>
  constructor(private brandService : BrandService) { }
  viewAdd=false;

  ngOnInit() {
  }

  insertBrand(){
    this.brandService.insertBrand().subscribe(data=>{
      console.log(data)
      this.viewAdd=false;
    })
  }

  updateBrand(){
    this.brandService.updateBrand().subscribe(data=>{
      console.log(data);
    },
    err =>{
      console.log(err)
    })
  }

  viewForm(){
    this.viewAdd =true;
  }

}
