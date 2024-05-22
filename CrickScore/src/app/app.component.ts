import { CommonModule, JsonPipe } from '@angular/common';
import { HttpClientModule,withFetch } from '@angular/common/http';
import { Component, NgModule, Pipe } from '@angular/core';
import { NgModel } from '@angular/forms';
import { RouterModule, RouterOutlet } from '@angular/router';
import { DatePipe  } from '@angular/common';
//import { pipe } from 'rxjs';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule,RouterOutlet,RouterModule,HttpClientModule,DatePipe,JsonPipe],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})


export class AppComponent {
  title = 'CrickScore';
}


