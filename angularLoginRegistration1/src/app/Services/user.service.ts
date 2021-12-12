import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../Models/user';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})

export class UserService {

  private apiUrl:String;

  constructor( private http: HttpClient ) { 
    this.apiUrl = environment.apiUrl;
  }

  public loginUserFromRemote(user: User): Observable<any> {
    return this.http.post<any>(this.apiUrl + '/login', user);
  }
  public registerUserFromRemote(user: User): Observable<any> {
    return this.http.post<any>(this.apiUrl + '/registerUser', user);

  }

}




