import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { TokenStorageService } from '../services/token-storage.service';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-home2',
  templateUrl: './home2.component.html',
  styleUrls: ['./home2.component.css']
})
export class Home2Component implements OnInit {
  username?:String
  posts: any =[]
  constructor(private storageService: TokenStorageService,
    private authService: AuthService,private router: Router,private http: HttpClient) { }

  ngOnInit(): void {
    this.username=this.storageService.getUser().firstname;
    if(this.username==null){  
      this.router.navigate(['/login']);
    }
    this.http.get<any>('/assets/posts.json').subscribe(data => {
    this.posts = data;
  });
  }


  logout(): void {
   
        this.storageService.signOut();
        this.router.navigate(['/home1']);

        window.location.reload();

      
     
  }
}
