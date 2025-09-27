import { Component } from '@angular/core';
import { UserService } from '../../services/user.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.css',
})
export class SignupComponent {

  constructor(private userService:UserService, private snack : MatSnackBar){}

  public user = {
    username:'',
    password:'',
    firstName:'',
    lastName:'',
    email:'',
    phone:''
  }

  register(){
    if(this.user.username =='' || this.user.username == null){
      this.snack.open("User Name is required !!",'X',{duration:2000,panelClass:['success']});
      return;
    }

    this.userService.addUser(this.user).subscribe(
      (data)=>{
        // alert("User Created Successfully");
        Swal.fire("Success","User Successfully created!!",
          "success"
        )
      },
      (error)=>{
        console.log(error);
        this.snack.open("Something went wrong !!",'X',{duration:2000});
      }
    )
  }

}
