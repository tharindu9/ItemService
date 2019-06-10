import { Component, OnInit } from '@angular/core';
import {Category} from '../models/category';
import { CategoryService} from '../service/category.service'

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {

  category : Category = new Category();
  
  constructor(private categoryService : CategoryService) {  }

  ngOnInit() {
  
  }

  insertCategory(){
    console.log(this.category.name)
    this.categoryService.insertCategory().subscribe(data=>{
      console.log(data)
    },err=>{
      console.log(err)
    })
  }

}
