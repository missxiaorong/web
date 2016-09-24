<?php
/**
 * Created by PhpStorm.
 * User: Zqq
 * Date: 2016/8/20 0020
 * Time: 14:33
 */


//设置编码格式
header("Content-type:text/html;charset=utf-8");

//定义数据库主机地址
$host="localhost";

//定义mysql数据库登录用户名
$user="root";

//定义mysql数据库登录密码
$pwd="";

//数据表
$mysql_database='w';

//链接数据库
$conn = mysql_connect($host,$user,$pwd);

mysql_query("set names 'utf8'"); //数据库输出编码 应该与你的数据库编码保持一致.南昌网站建设公司百恒网络PHP工程师建议用UTF-8 国际标准编码.
