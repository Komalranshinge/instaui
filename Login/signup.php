<?php
$conn = mysqli_connect("localhost","root","");
mysqli_select_db($conn,"signup");
$fullname=trim($_POST['fullname']);
$username=trim($_POST['username']);
$email=trim($_POST['email']);
$phoneno=trim($_POST['phoneno']);
$password=trim($_POST['password']);

$qry1="select * from signup where email='$email'";
$raw=mysqli_query($conn,$qry1);
$count=mysqli_num_rows($raw);

if($count>0)
{
    $response="User already exists";
}
else{
      $qry2="INSERT INTO `signup` (`fullname`, `username`, `email`, `phoneno`, `password`)
       VALUES ('$fullname', '$username', '$email', '$phoneno', '$password');";
       $res=mysqli_query($conn,$qry2);
       if($res==true)
       $response="Data Inserted Successfully";
       else
       $response="Failed To Insert The Data";

}
echo $response;


?>