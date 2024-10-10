import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AutomoveisService {

  httpClient = inject(HttpClient);
  pathUrl = "https://6707b16d8e86a8d9e42c8435.mockapi.io/automoveis"
  constructor() { }

  list() {
    return this.httpClient.get(`${this.pathUrl}`);
  }
  detail(id: number) {
    return this.httpClient.get(`${this.pathUrl}/${id}`);
  }
}
