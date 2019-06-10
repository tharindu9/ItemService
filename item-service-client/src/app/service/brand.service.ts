import { Injectable } from '@angular/core';
import { Brand } from '../models/brand';
import { Item } from '../models/item';

import { Observable } from 'rxjs';
import { HttpClient ,HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class BrandService {

  brand : Brand = new Brand();
  viewUpdate =false;
  brandId;
  viewItemList=false;
  constructor(private httpClient : HttpClient) { }

  private baseUrl = "http://localhost:8080/brand"

  public getAllBrands():Observable<any>{
    return this.httpClient.get(`${this.baseUrl}`);
  }

  insertBrand(): Observable<any>{
    return this.httpClient.post(this.baseUrl,this.brand)
  }

  getBrandToEdit(brand){
    this.viewUpdate=true;
    this.brand =  brand;
    console.log(this.brand)
    return this.brand;
  }

  updateBrand(): Observable<any>{
    this.viewUpdate = false;
   return this.httpClient.put(`${this.baseUrl}`,this.brand)
  }

  resetForm(){
    this.brand.name =""
  }

  fetchBrandItemList(id) : Observable<any>{
    return this.httpClient.get(`${this.baseUrl}/${id}`+"/item");
  }

}
