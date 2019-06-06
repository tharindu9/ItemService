import { Injectable } from '@angular/core';
import { HttpClient ,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import{Item} from '../models/item'


@Injectable({
  providedIn: 'root'
})


export class ItemService {

  constructor(private httpClient : HttpClient) { }

  private baseUrl = "http://localhost:8080/item"

  public getAllItems():Observable<any>{
    
    return this.httpClient.get(`${this.baseUrl}`);
  }

  removeItem(id:number) {
    console.log(id);
    console.log(`${this.baseUrl}/${id}`);
    return this.httpClient.delete(`${this.baseUrl}/${id}` , { responseType: 'text' });
  }
}
