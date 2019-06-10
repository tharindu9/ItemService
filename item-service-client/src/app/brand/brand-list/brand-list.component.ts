import { Component, OnInit } from '@angular/core';
import{BrandService} from '../../service/brand.service';
import {Brand} from '../../models/brand';
import {Item} from '../../models/item';

import { Observable } from "rxjs";

@Component({
  selector: 'app-brand-list',
  templateUrl: './brand-list.component.html',
  styleUrls: ['./brand-list.component.css']
})
export class BrandListComponent implements OnInit {

  brands : Observable<Brand[]>;
  items : Observable<Item[]>;
  p: number = 1;
  viewItemList=false;
  constructor(private brandService : BrandService) { }

  ngOnInit() {
    this.displayBrands();
  }

  displayBrands(){
    this.brands = this.brandService.getAllBrands();
  }

  onEdit(brand){
    this.brandService.getBrandToEdit(Object.assign({}, brand));

  }

  fetchBrandItemList(id){
console.log("brand is is "+id)
    this.items = this.brandService.fetchBrandItemList(id)
    this.items.subscribe(data=>{
      console.log(data);
      this.viewItemList=true;
    })
  }
}
