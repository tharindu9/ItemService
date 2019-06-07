import { Component, OnInit } from '@angular/core';
import { TypesService } from '../service/types.service'

@Component({
  selector: 'app-types',
  templateUrl: './types.component.html',
  styleUrls: ['./types.component.css']
})
export class TypesComponent implements OnInit {

  constructor(private typeService : TypesService) { }

  ngOnInit() {
  }

}
