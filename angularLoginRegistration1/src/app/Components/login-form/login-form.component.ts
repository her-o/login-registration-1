import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/Models/user';
import { UserService } from 'src/app/Services/user.service';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

 username!:string;
 password!:string;
 authenticated!:boolean;

  constructor(private service:UserService,
              private router: Router) {
                
  }

  ngOnInit(): void {
  }

  login() {

    this.service.loginUserFromRemote(this.username, this.password).subscribe(result => {
      
      this.authenticated = true;
      alert(this.authenticated);
      this.router.navigateByUrl("http://localhost:8083/users");

    },
    error => {
      this.authenticated = false;
      alert(this.authenticated);
    });
  }
}
