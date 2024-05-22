import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment.development';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ApiCallService {
  
  constructor(private _httpClient:HttpClient) { }

  getAllMatches(){
    return this. _httpClient.get(`${environment.apiUrl}/match`)
    
  }
  
  getLiveMatchScores(){
    return this._httpClient.get(`${environment.apiUrl}/match/live`)

  }
  
  getPoinTable(){
    return this._httpClient.get(`${environment.apiUrl}/match/point-table`)

  }
 
}
