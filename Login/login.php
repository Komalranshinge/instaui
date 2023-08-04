<?php
$con=mysqli_connect("localhost","root","");
mysqli_select_db($con,"signup");
$username=$_POST['username'];
$password=$_POST['password'];

$qry="select * from signup where username='$username' and password='$password'";
$raw=mysqli_query($con,$qry);
$count=mysqli_num_rows($raw);

if($count>0)
echo "Data found in database";
else 
echo "Data Not Found";

?>