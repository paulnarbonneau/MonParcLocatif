import { Component, OnInit } from '@angular/core';
import { FormGroup,FormControl, Validators } from '@angular/forms';

import * as CryptoJs from 'crypto-js';

@Component({
  selector: 'mpl-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginFormGroup = new FormGroup(
    {
      user : new FormControl('',Validators.required),
      password : new FormControl('',Validators.required)
    }
  );

  constructor() { 
  }

  ngOnInit(): void {
    //this.showStatus();
  }

  onSubmit()
  {
    console.log(JSON.stringify(this.loginFormGroup.value));
    console.log(`Username : ${this.loginFormGroup.value.user}`);
    console.log(`password : ${CryptoJs.AES.encrypt(this.loginFormGroup.value.user,"doudou")}`);
  }

  showStatus()
  {
    console.log(this.user);
    console.log(this.user.invalid && (this.user.dirty || this.user.touched));
    console.log(this.user.errors?.required);
  }

  get password() { return this.loginFormGroup.get('password');}

  get user() { return this.loginFormGroup.get('user');}

}
