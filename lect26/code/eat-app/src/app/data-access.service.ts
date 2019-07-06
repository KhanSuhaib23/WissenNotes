import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class DataAccessService {

  constructor(private _http: HttpClient) { }


  getItems() {
	  let apiUrl = 'http://localho	st:8181/api/products';

	  return this._http.get(apiUrl);
  }

  getReviews(id) {
	let apiUrl = `http://localhost:8181/api/products/${id}/reviews`;

    return this._http.get(apiUrl);
  }
}
