import { Component, OnInit } from '@angular/core';
import { ApiCallService } from '../../services/api-call.service';
import { error } from 'console';
import { CommonModule, JsonPipe } from '@angular/common';
import { pipe } from 'rxjs';
import { MatchCardComponent } from '../../components/match-card/match-card.component';
import { HttpClientModule ,withFetch} from '@angular/common/http';

@Component({
  selector: 'app-point-table',
  standalone: true,
  imports: [CommonModule,JsonPipe,HttpClientModule],
  templateUrl: './point-table.component.html',
  styleUrl: './point-table.component.css'
})
export class PointTableComponent implements OnInit {
  pointTable: any
  tableHeading:any
  constructor(private _api:ApiCallService){

  }
  ngOnInit(): void {
    this._api.getPoinTable().subscribe({
      next:data=>{
        this.pointTable=data
        this.tableHeading=[...this.pointTable[0]]
      },
      error:error=>{
        console.log(error)
      }
    })
  }

}
