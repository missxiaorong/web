<?php
/**
 * Created by PhpStorm.
 * User: zqq
 * Date: 2016/9/24 0024
 * Time: 20:59
 */

require_once 'config.php';//�����ļ�
session_start();
$id=$_GET['id'];
mysql_select_db($mysql_database); //�����ݿ�

//ɾ�����Լ�¼����

$sql="delete from message where id=$id";
var_dump($sql);
$query=mysql_query($sql);
echo mysql_error();
if($query){
    echo '�ɹ�ɾ��~';
    echo "<script language=\"javascript\">location.href='index.php';</script>";
}
else{
    echo 'ɾ��ʧ��~';
}

