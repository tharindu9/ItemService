import { Component, OnInit } from '@angular/core';
import{Item} from '../models/item'



@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css']
})
export class ItemComponent implements OnInit {

item : Item = new Item();

  constructor() { }

  ngOnInit() {
  }

}
