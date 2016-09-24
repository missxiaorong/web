<?php
/**
 * Created by PhpStorm.
 * User: zqq
 * Date: 2016/9/24 0024
 * Time: 10:57
 */
require_once 'config.php';//配置文件
session_start();
$username=$_SESSION['username'];
$content=$_POST['content'];
$img=$_POST['face'];
mysql_select_db($mysql_database); //打开数据库
$sql="select * from message";
$query=mysql_query($sql);//执行语句
$count=mysql_num_rows($query);//总条数
if($username==''){
    $username='zozo'.$count+1;
}
//增加留言
else{
    $sql="insert into message (username,img,leave_time,leave_content)values('$username','$img',now(),'$content')";
}
var_dump($sql);
die();
$query=mysql_query($sql);
echo mysql_error();
if($query){
    echo "<script language=\"javascript\">location.href='index.php';</script>";
}
else{
    echo 'error';
}

