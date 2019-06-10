import { Component, OnInit } from '@angular/core';
import{CategoryService} from '../../service/category.service';
import {Category} from '../../models/category';
import { Observable } from "rxjs";



@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrls: ['./category-list.component.css']
})
export class CategoryListComponent implements OnInit {

  //category : Category = new Category();
  constructor(private categoryService : CategoryService) { }

  categories : Observable<Category[]>;
  ngOnInit() {
    this.displayCategories();
    this.fetchOneCategory();
  }

  displayCategories(){
    this.categories = this.categoryService.getAllCategories();
    this.categories.forEach(el=>{
      console.log(el)
    })
    console.log(this.categories)

  }

  onDelete(id){
    console.log(id)
    this.categoryService.removeCategory(id);
  }

  fetchOneCategory(){
    this.categoryService.fetchOneCategory(1).subscribe(data=>{
      console.log("fetch one "+data.name);
    });
  }

  onEdit(category: Category) {
    this.categoryService.getCategoryToEdit(Object.assign({}, category));
    console.log(category)
  }
}
