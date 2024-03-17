import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-foodie-home',
  templateUrl: './foodie-home.component.html',
  styleUrl: './foodie-home.component.css'
})
export class FoodieHomeComponent {
  gotoLogin() :void{
    this.route.navigate(['/login']);
  }
  
  constructor( private route: Router) {
  }
  
  ngOnInit(): void {
  }
}
