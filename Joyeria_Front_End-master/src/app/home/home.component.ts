import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { SignupComponent } from '../signup/signup.component';
import { LoginComponent } from '../login/login.component';
import { UserService } from '../services/user.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  constructor(private dialog:MatDialog,
    private userService:UserService,
    private router:Router) { }

    ngOnInit(): void {
      this.userService.checkToken().subscribe((response:any)=>{
        this.router.navigate(['/joyeria/dashboard']);
      },(error:any)=>{
        console.log(error);
      })
    }

  handleSignupAction(){
    const dialogCongig = new MatDialogConfig();
    dialogCongig.width= "550px";
    this.dialog.open(SignupComponent, dialogCongig)
  }

  handleLoginAction(){
    const dialogCongig = new MatDialogConfig();
    dialogCongig.width= "550px";
    this.dialog.open(LoginComponent, dialogCongig)
  }

}
