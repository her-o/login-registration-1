import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../Models/user';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})

export class UserService {

  private apiUrl:string;

  constructor( private http: HttpClient ) { 
    this.apiUrl = environment.apiUrl;
  }
  
  public loginUserFromRemote(username:string, password:string)  {
    const header = {
      headers: new HttpHeaders({
        'Authorization': `Basic ${btoa(username + ':' + password)}`,
        'Access-Control-Allow-Headers': 'Content-Type',
        'Access-Control-Allow-Methods': 'GET',
        'Access-Control-Allow-Origin': '*'
      })     
    }
    return this.http.get(this.apiUrl, header);
  }

  public registerUserFromRemote(user: User): Observable<any> {
    return this.http.post<any>(this.apiUrl + '/registerUser', user);
  }

}




