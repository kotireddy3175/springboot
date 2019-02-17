import { Component ,ViewChild} from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { CommonService } from './common.service';
import {MatPaginator, MatTableDataSource} from '@angular/material';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'combinationsApp';
  combinationForm: FormGroup;
  displayedColumns: string[] = ['position', 'MobileNo'];
  ELEMENT_DATA:any[];
  dataSource = new MatTableDataSource<any>(this.ELEMENT_DATA);

  @ViewChild(MatPaginator) paginator: MatPaginator;
  constructor(private commonService:CommonService) {
    this.combinationForm = this.createFormGroup();    
  }
 
  createFormGroup() {
    return new FormGroup({     
      mobileNo: new FormControl('',[Validators.pattern('(([0-9]{7})|([0-9]{10}))'),Validators.required])
    });
  }

  generate(){
    if (this.combinationForm.invalid) {
      return;
  }else{
     this.commonService.getCombinations(this.combinationForm.value).subscribe(result =>
       {
         this.ELEMENT_DATA=result;
         this.dataSource = new MatTableDataSource<any>(this.ELEMENT_DATA);
         this.dataSource.paginator = this.paginator
      });
  }
   }
  ngOnInit() {}
  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator
}
  
}