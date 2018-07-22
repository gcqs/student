<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>


<form method="post" action="">
   <table border="1px" style="width:100%;text-align:center; margin: 0 auto; border-collapse: collapse;">
    <tr>
     <td colspan="5">学生数据</td>
     <td><input type="button" value="添加" onclick="add()"></td>
    </tr>
    <tr>
     <td>id</td>
     <td>姓名</td>
     <td>出生日期</td>
     <td>备注</td>
     <td>平均分</td>
     <td></td>
    </tr>
    <c:if test="${page.page==null}">
     <tr>
     <td colspan="6">
       <input type="button" value="显示数据" onclick="javascript:window.location.href='findServlet?page=1'">
     </td>
    </tr>
    </c:if>
    
    <c:forEach items="${page.students}" var="itms">
    <tr>
     <td>${itms.id}</td>
     <td>${itms.name }</td>
     <td><fmt:formatDate pattern="yyyy-MM-dd" value="${itms.birthday }" type="date"/></td>
     <td>${itms.description }</td>
     <td>${itms.avg }</td>
     <td> 
      <input type="button" value="删除"  onclick="javascript:window.location.href='deleteServlet?id=${itms.id}'">
      <input type="button" value="修改" onclick="alter(${itms.id})">
     </td>
     </tr>
    
    </c:forEach>
    <tr>
    <td colspan="6">
    <span>-共${page.page}页-</span>
    <c:forEach items="${page.pages }" var="itms">
     
      <span><a href="findServlet?page=${itms }">${itms }</a></span>
   
   </c:forEach>
   </td>
   </tr>
   </table>
   
   
   </form>
   <div align="center" id="adddiv" style="display: none; height: 300px;width: 200px;margin:0 auto; text-align: center; ">
   <form method="post" action="addServlet" id="form">
     <table style="margin: 0 auto;text-align: center; width: 400px">
     <tr>
     <td colspan="2" id="td">
     
     </td>
     </tr>
      <tr>
       <td >姓名</td>
       <td><input type="text" name="name" id="name" ></td>
      </tr>
      <tr>
       <td>出生日期</td>
       <td><input type="text" name="birthday" id="birthday" onblur="test()"  placeholder="正确格式 如：2014-01-01" ></td>
      </tr>
      <tr>
       <td>备注</td>
       <td><input type="text" name="description"  id="description"></td>
      </tr>
      <tr>
       <td>平均分</td>
       <td><input type="text" name="avg"  id="avg"></td>
      </tr>
      
      <tr>
       <td colspan="2"><input id="tibtn"  type="button" value="提交" onclick="tijiao()">
       <input type="button" onclick="javascript:document.getElementById('adddiv').style.display='none'" value="取消"></td>
      </tr>
     
     </table>
     </form>
   </div>



</body>
<script type="text/javascript">
   function add() {
	   var form =  document.getElementById("form");
	var div = document.getElementById("adddiv");
	var td = document.getElementById("td");
	td.innerHTML="<h1>添加数据</h1>"
	form.action="addServlet";
	div.style.display="";
}
   function alter(id) {
	 var form =  document.getElementById("form");
	 var div = document.getElementById("adddiv"	);
	 var td = document.getElementById("td");
		td.innerHTML="<h1>修改数据</h1>"
	 form.action = "alterServlet?id="+id;
	 div.style.display = "";
	   
	
}
   function test() {
	   
	   var reg = /^[1-9]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/;
	   var birthday = document.getElementById("birthday");
	   //alert(birthday.value);
	   var regExp = new RegExp(reg);
	   if(!regExp.test(birthday.value)){
		birthday. placeholder="错误 格式为：2014-01-01";
		birthday.value="";
	   　　return;	
	   }
	   
	   
	
}
   
   function tijiao() {
	   var tibtn = document.getElementById("tibtn");
	   var description = document.getElementById("description");
	   var name = document.getElementById("name");
	   var avg = document.getElementById("avg");
	   var birthday = document.getElementById("birthday");
	   var form =  document.getElementById("form");
	   if(name.value!=""&&avg.value!=""&&birthday.value!=""&&description.value!=""){
		   alert("请按格式输入数据");
		   form.submit();
	   }
	
}


</script>
</html>