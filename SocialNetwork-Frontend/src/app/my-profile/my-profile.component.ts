import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/auth.service';

import { TokenStorageService } from '../services/token-storage.service';

@Component({
  selector: 'app-profile',
  templateUrl: './my-profile.component.html',
  styleUrls: ['./my-profile.component.css']
})
export class MyProfileComponent implements OnInit {
  currentUser: any;
  form: any = {};
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';
 
 


  constructor(private token: TokenStorageService,private authService: AuthService) { }

  ngOnInit() {
    this.currentUser = this.token.getUser();
  
  }
  
  
  
}
