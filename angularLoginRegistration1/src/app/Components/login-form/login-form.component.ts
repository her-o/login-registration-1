import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/Models/user';
import { UserService } from 'src/app/Services/user.service';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  private user = new User();
  private msg = "";
  public loginForm!: FormGroup;
  constructor(private service:UserService,
              private formBuilder:FormBuilder,
              private router: Router) {
                
  }

  ngOnInit(): void {
    
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    })

  }

  get f() { return this.loginForm.controls }

  login() {
    this.service
      .loginUserFromRemote(this.user)
        .subscribe(
          data => {
            console.log("Login successful!");
            this.router.navigate(['loginsuccessful']);
          }, 
          error => {
            this.msg = error.status + " - " + error.message;
            console.log(this.msg);
            
          }
        )

  }

}
