<?php
/**
 * Created by PhpStorm.
 * User: zqq
 * Date: 2016/8/20 0020
 * Time: 10:32
 */

session_start();
require 'ValidateCode.class.php';  //�Ȱ������������ʵ��·������ʵ����������޸ġ�
$_vc = new ValidateCode();  //ʵ����һ������
$_vc->doimg();
$_SESSION['code'] = $_vc->getCode();//��֤�뱣�浽SESSION��