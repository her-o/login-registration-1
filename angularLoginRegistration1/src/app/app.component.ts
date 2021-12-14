import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from './Services/user.service';
import { finalize } from "rxjs/operators";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'angularLoginRegistration1';
  
  
  constructor(private http: HttpClient, 
              private router:Router, 
              private service: UserService) {
 
  }
}
