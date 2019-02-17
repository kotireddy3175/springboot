import { Injectable } from '@angular/core';
import { Observable, Subject,of } from 'rxjs';
import { map, catchError, tap } from 'rxjs/operators';
import { HttpClient,HttpHeaders, HttpErrorResponse} from '@angular/common/http'; 

@Injectable({
  providedIn: 'root'
})
export class CommonService {
  apiUrl:string = 'http://localhost:8080/';
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
    };
  constructor(private http:HttpClient) { }
 
  getCombinations (data:string): Observable<any> { 
    return this.http.post<any>(this.apiUrl + 'all', JSON.stringify(data),this.httpOptions).pipe(
      tap((data) => console.log(`got the combinations`))
     );
  }
}
