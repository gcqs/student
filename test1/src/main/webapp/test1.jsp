<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>


<form method="get" action="">
   <table border="1px">
    <tr>
     <td colspan="5">学生数据</td>
     <td>添加</td>
    </tr>
    <tr>
     <td>id</td>
     <td>姓名</td>
     <td>出生日期</td>
     <td>备注</td>
     <td>平均分</td>
     <td></td>
    </tr>
    
    
   </table>
   
   </form>
   <div>
   <form method="get" action="addServlet">
     <table>
      <tr>
       <td>姓名</td>
       <td><input type="text" name="name"></td>
      </tr>
      <tr>
       <td>出生日期</td>
       <td><input type="text" name="birthday"></td>
      </tr>
      <tr>
       <td>备注</td>
       <td><input type="text" name="description"></td>
      </tr>
      <tr>
       <td>平均分</td>
       <td><input type="text" name="avg"></td>
      </tr>
      
      <tr>
       <td><input type="submit">提交</td>
       <td><input type="button">取消</td>
      </tr>
     
     </table>
     </form>
   </div>



</body>
</html>