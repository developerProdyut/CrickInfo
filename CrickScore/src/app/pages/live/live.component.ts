import { Component, OnInit } from '@angular/core';
import { ApiCallService } from '../../services/api-call.service';
import { error } from 'console';
import { CommonModule, JsonPipe } from '@angular/common';
import { MatchCardComponent } from '../../components/match-card/match-card.component';
import { HttpClientModule,withFetch } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
@Component({
  selector: 'app-live',
  standalone: true,
  imports: [CommonModule, JsonPipe,MatchCardComponent,HttpClientModule,BrowserModule,FormsModule],
  templateUrl: './live.component.html',
  styleUrl: './live.component.css'
})
export class LiveComponent implements OnInit{
  livematches:any

  constructor(private _api:ApiCallService){

  }
  ngOnInit(): void {
    this.loadLiveMatches();
    
  }


  private loadLiveMatches() {
    this._api.getLiveMatchScores().subscribe({
      next: (data) => {
        console.log(data);  
        this.livematches=data 
      },
      error: (error) => {
        console.log(error);
      }
    });
  }
}
