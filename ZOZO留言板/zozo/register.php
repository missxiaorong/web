<?php
/**
 * Created by PhpStorm.
 * User: zqq
 * Date: 2016/8/20 0020
 * Time: 16:11
 */

require_once 'config.php';//配置文件
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
$username=$_POST['username'];
$password=md5($_POST['password']);
$id=time();
////链接数据库
//$conn = mysql_connect($host,$user,$pwd);
mysql_select_db($mysql_database); //打开数据库
$sql="select * from user where username=$username";//数据库查询是否用用户
$result = mysql_query($sql);
@$result_row=mysql_fetch_row($result);
if(!is_resource($result_row)){
    $sql = "insert into user (id,username,password) values ('$id','$username','$password')";
//    var_dump($sql);
    if (!mysql_query($sql)) {//插入数据
        echo('注册失败!');
    } else {
        echo('注册成功!');
    }
}
else{
    echo '该账户已存在！';
    die;
}
mysql_close();
