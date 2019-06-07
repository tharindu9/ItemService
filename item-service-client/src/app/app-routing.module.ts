import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CategoryComponent } from './category/category.component';
import {ItemComponent} from './item/item.component';
import {TypesComponent} from './types/types.component';
import {BrandComponent} from './brand/brand.component'

const routes: Routes = [ {path : "categories" , component : CategoryComponent},
{path : "items" , component : ItemComponent},
{path : "types" , component : TypesComponent},
{path : "brands" , component : BrandComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
