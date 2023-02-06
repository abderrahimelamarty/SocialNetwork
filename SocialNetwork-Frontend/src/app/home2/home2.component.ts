import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { TokenStorageService } from '../services/token-storage.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home2',
  templateUrl: './home2.component.html',
  styleUrls: ['./home2.component.css']
})
export class Home2Component implements OnInit {
  username?:String

  constructor(private storageService: TokenStorageService,
    private authService: AuthService,private router: Router) { }

  ngOnInit(): void {
    this.username=this.storageService.getUser().firstname;
    if(this.username==null){  
      this.router.navigate(['/login']);
    }
  }


  logout(): void {
   
        this.storageService.signOut();
        window.location.reload();
      
     
  }
}
