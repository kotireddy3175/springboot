import { BrowserModule } from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
 import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {MatButtonModule, MatInputModule} from '@angular/material';
import { CommonService } from './common.service';
import { HttpClientModule } from '@angular/common/http'; 
import {MatTableModule} from '@angular/material/table'; 
import { MatPaginatorModule } from '@angular/material';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    MatButtonModule,   
    MatInputModule ,
    HttpClientModule,
    MatTableModule,
    MatPaginatorModule
  ],
  providers: [CommonService],
  bootstrap: [AppComponent]
})
export class AppModule { }
