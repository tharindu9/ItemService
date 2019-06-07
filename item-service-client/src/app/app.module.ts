import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CategoryComponent } from './category/category.component';
import { ItemComponent } from './item/item.component';
import { TypesComponent } from './types/types.component';
import { FormsModule }   from '@angular/forms';
import { ItemListComponent } from './item/item-list/item-list.component';
import { HttpClientModule } from '@angular/common/http';
import { CategoryListComponent } from './category/category-list/category-list.component';
import { TypeListComponent } from './types/type-list/type-list.component';
import { BrandComponent } from './brand/brand.component';
import { UomComponent } from './uom/uom.component';
import { BrandListComponent } from './brand/brand-list/brand-list.component';
import { UomListComponent } from './uom/uom-list/uom-list.component';
import {NgxPaginationModule} from 'ngx-pagination';


@NgModule({
  declarations: [
    AppComponent,
    CategoryComponent,
    ItemComponent,
    TypesComponent,
    ItemListComponent,
    CategoryListComponent,
    TypeListComponent,
    BrandComponent,
    UomComponent,
    BrandListComponent,
    UomListComponent,
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgxPaginationModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
