import { Injectable } from '@angular/core';
import {ItemType } from '../models/type';
import { Observable } from 'rxjs';
import { HttpClient ,HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TypesService {

  type : ItemType = new ItemType();

  viewUpdate = false;
  constructor(private httpClient : HttpClient) { }

  private baseUrl = "http://localhost:8080/category";

}
