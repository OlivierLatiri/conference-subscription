import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http'
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'conference-subscription-app';
  // Object to save the response returned from the service.
  myresponse: any;
 
  // Url to fetch the employee records from the spring application.
  readonly APP_URL = 'http://localhost:8080';
 
  constructor(private _http: HttpClient) { }
 
  // Method to fetch all employees from the database table.
  getAllEmployees() {
    this._http.get(this.APP_URL + '/getconference/list').subscribe(
      data => {
        this.myresponse = data;
      },
      error => {
        console.log('Error occured', error);
      }
    );
  }
}