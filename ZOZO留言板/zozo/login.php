<?php
/**
 * Created by PhpStorm.
 * User: zqq
 * Date: 2016/8/18 0018
 * Time: 13:38
 */

require_once 'config.php';//数据库配置文件
session_start();


/**
 * 是否是POST提交
 * @return int
 */
function isPost() {
    return ($_SERVER['REQUEST_METHOD'] == 'POST'  && (empty($_SERVER['HTTP_REFERER']) || preg_replace("~https?:\/\/([^\:\/]+).*~i", "\\1", $_SERVER['HTTP_REFERER']) == preg_replace("~([^\:]+).*~", "\\1", $_SERVER['HTTP_HOST']))) ? 1 : 0;
}
if(isPost()==0){
    exit('访问路径出错');
}


$username=$_POST['username']; //账号
$password=md5($_POST['password']);//密码
$code=$_POST['code'];//验证码


//
////链接数据库
//$conn = mysql_connect($host,$user,$pwd);
mysql_select_db($mysql_database); //打开数据库
$sql ="select * from user where username=$username "; //SQL语句
$result = mysql_query($sql); //查询
$result_row=mysql_fetch_row(($result));
if($result_row){
    $name=$result_row[1];
    $psw=$result_row[2];
    mysql_close();//关闭数据库链接
}
else{
    echo '错误：账号不存在！';
    die;
}
//后台对提交数据验证
if(empty($username)){
    echo '错误：账号不能为空';
    die;
}
if(empty($password)){
    echo '错误：密码不能为空';
}
if(empty($code)){
    echo '错误：验证码不能为空';
}
if($username!=$name){
    echo '错误：账号不存在！';
   die;
}
if($password!=$psw){
    echo '错误:密码错误！';
    die;
}
if($code!=$_SESSION['code']){
    echo '错误：验证码错误！';
    die;
}
if($username==$name&&$password==$psw&&$code==$_SESSION['code']){
    $_SESSION['username']=$username;
    echo '登录成功';

}