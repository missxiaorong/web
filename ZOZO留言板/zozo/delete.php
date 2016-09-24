<?php
/**
 * Created by PhpStorm.
 * User: zqq
 * Date: 2016/9/24 0024
 * Time: 20:59
 */

require_once 'config.php';//配置文件
session_start();
$id=$_GET['id'];
mysql_select_db($mysql_database); //打开数据库

//删除留言记录操作

$sql="delete from message where id=$id";
var_dump($sql);
$query=mysql_query($sql);
echo mysql_error();
if($query){
    echo '成功删除~';
    echo "<script language=\"javascript\">location.href='index.php';</script>";
}
else{
    echo '删除失败~';
}

