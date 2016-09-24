<?php
require("config.php");//配置文件i
?>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
  <title>留言板</title>
  <link href="css/css.css" rel="stylesheet" type="text/css" />
  <link rel="stylesheet" type="text/css" href="css/lrtk.css" />
  <link href="css/bootstrap.min.css" rel="stylesheet">

  <style type="text/css">
    body { background-color: #E8FAFF; }
  </style>
  <script type="text/javascript" src="js/jquery.js"></script>
</head>
<body>
<!-- 代码 开始 -->
<div class="Upper">

  <table style="width:100%" border="0" cellspacing="0" cellpadding="0" align="center">

    <tr>
      <td>
        <table style="width:600px" border="0" cellspacing="0" cellpadding="0" align="center">

          <tr>
            <td style="padding:70px 0 0" align="left" width="385">
              <h1 style="color:#f4f2ed"></h1>
              <p style="color:#d3f1a0"></p>
            </td>
            <td style="padding:15px 0 0" align="right" width="215">
              <img src="images/Autom-Leaf.png"> </td>
          </tr>
          <tr>
            <td style="padding:10px 0" colspan="2" align="right"></td>
          </tr>
        </table>
        <table style="width:600px" border="0" cellspacing="0" cellpadding="0" align="center">
          <tr>
            <td class="content" style align="left" valign="top" width="600">
              <table border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td style="padding:20px 0 25px 95px" align="left">

                  </td>
                </tr>

              </table>
            </td>
          </tr>
        </table>

      </td>
    </tr>
  </table>

</div>

<table  style="width:80%;margin: 0 auto" class="table table-bordered" >
  <caption>ZOZO留言板
    <div class="box">
      <span><a href="login.html">登录</a> </span>
      <span class="reg"><a href="register.html">注册</a> </span>
    </div>

  </caption>
  <tbody>
  <?php
  mysql_select_db($mysql_database); //打开数据库
  $sql="select * from message";
  $query=mysql_query($sql);//执行语句
  $count=mysql_num_rows($query);//总条数
  $i=0;
  while($rows=mysql_fetch_array($query)) {
    $i++;
    ?>
    <tr>
      <td rowspan="2" width="15%"><img src="images/face/face<?php echo $rows["img"]?>.gif"/></td>
      <td>发表于：<?php echo $rows['leave_time']?>.gif</td>
      <td width="25%">第<?php echo $i?>楼 <a class="del" href="delete.php?id=<?php echo $rows['id']?>" onclick="delcfm()">删除</a> </td>
    </tr>
    <tr>
      <td colspan="2" rowspan="2"><?php echo $rows['leave_content']?></td>
    </tr>
    <tr>
      <td>昵称：<?php echo $rows['username']?></td>
    </tr>
    <?php
  }
  ?>
  <form id="form1" name="form1" method="post" action="leaveMsg.php" onsubmit=return(CheckInput()) style="margin-top:0px;">

    <tr>
      <th colspan="3" class="ms_title">添加留言</th>
    </tr>

    <tr>
      <td height="60">留言头像:</td>
      <td bgcolor="#FFFFFF" colspan="2">
        <input type="radio" value="1" name="face" checked="checked" />
        <img src="images/face/face1.GIF" border="0" />
        <input type="radio" value="2" name="face" />
        <img src="images/face/face2.GIF" border="0" />
        <input type="radio" value="3" name="face" />
        <img src="images/face/face3.GIF" border="0" />
        <input type="radio" value="4" name="face" />
        <img src="images/face/face4.GIF" border="0" />
        <input type="radio" value="5" name="face" />
        <img src="images/face/face5.GIF" border="0" />
        <input type="radio" value="6" name="face" />
        <img src="images/face/face6.GIF" border="0" />
        <input type="radio" value="7" name="face" />
        <img src="images/face/face7.GIF" border="0" />
      </td>
    </tr>

    <tr>
      <td colspan="3">留言内容:		</td>
    </tr>
    <tr>
      <td colspan="3"><textarea class="form-control" name="content" width="10%" rows="5"></textarea></td>
    </tr>
    <tr>
      <td colspan="3" align="center"><input type="submit" class="btn btn-info" name="Submit" value="发表" />
        <input   type="reset" name="Submit2"class="btn btn-default" value="重置" /></td>
    </tr>

  </form>

  </tbody>
</table>

<script type="text/javascript">
  $.AutomLeafStart({
    leafsfolder:"images/",
    howmanyimgsare:8,
    initialleafs:20,
    maxYposition:-10,
    multiplyclick:true,
    multiplynumber:10,
    infinite:true,
    fallingsequence:4000
  });
  $(function(){
    $("#botAgregar").bind("add",function(){
      $.AutomLeafAdd({leafsfolder:"images/",add:30,})});
    $("#botAgregar").trigger("add");
  })
  function delcfm() {
    if (!confirm("确认要删除？")) {
      window.event.returnValue = false;
    }
  }
</script>
</body>
</html>
