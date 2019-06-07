import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import{Category} from '../models/category';
import { HttpClient ,HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  category : Category = new Category();
  viewUpdate = false;
  constructor(private httpClient : HttpClient) { }

  private baseUrl = "http://localhost:8080/category";


  public getAllCategories():Observable<any>{
    return this.httpClient.get(`${this.baseUrl}`);
  }

  removeCategory(id) : Observable<void>{
    console.log(`${this.baseUrl}/${id}`)
    return this.httpClient.delete<void>(`${this.baseUrl}/${id}`);
}

fetchOneCategory(id) : Observable<any>{
  return this.httpClient.get<void>(`${this.baseUrl}/${id}`);

}

insertCategory(): Observable<any>{
  return this.httpClient.post(this.baseUrl,this.category)
}


getCategoryToEdit(category){
  this.viewUpdate=true;
  this.category =  category;
  return this.category;

}


}
