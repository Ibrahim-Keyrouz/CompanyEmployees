<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="X-UA-Compatible" content="IE=11">
<title>All X Employees</title>
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/favicon.ico" />
<link href="https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel="stylesheet">  
      <script src="https://code.jquery.com/jquery-1.10.2.js"></script>  
      <script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>  
    



<style>
a:visited {
	color: blue;
}
</style>

<script language="javascript">
	function addRow(tableID, maxEmpId, link) {

		 document.getElementById("messageerror").style.visibility= "hidden";
		
		document.getElementById("savelink").style.visibility= "visible"  ;
		
		var table = document.getElementById(tableID);

		var rowCount = table.rows.length;

		var row = table.insertRow(rowCount - 1);

		var cell1 = row.insertCell(0);
		var element1 = document.createElement("input");
		element1.setAttribute("name", "empId");
		element1.setAttribute("type", "text");
		element1.setAttribute("autocomplete", "off");	
		element1.setAttribute("class", "round default-width-input");
		element1.setAttribute("readonly", "readonly");
		element1.value = maxEmpId
		cell1.appendChild(element1);

		var cell2 = row.insertCell(1);
		var element2 = document.createElement("input");
		//element2.type = "text";
		//element2.name = "name";
		element2.setAttribute("name", "name");
		element2.setAttribute("autocomplete", "off");	
		element2.setAttribute("type", "text");
		element2.setAttribute("class", "round default-width-input");
		cell2.appendChild(element2);

		

		var cell3 = row.insertCell(2);
		var element3 = document.createElement("input");
		//element2.type = "text";
		//element2.name = "name";
		element3.setAttribute("name", "familyName");
		element3.setAttribute("autocomplete", "off");	
		element3.setAttribute("type", "text");
		element3.setAttribute("class", "round default-width-input");
		cell3.appendChild(element3);

		

		var cell4 = row.insertCell(3);
		var element4 = document.createElement("select");
		//element2.type = "text";
		//element2.name = "name";
		element4.setAttribute("name", "gender");
		element4.setAttribute("id", "gender");

		var element41 = document.createElement("option");
		element41.setAttribute("value", "");
		element41.textContent="";
		var element42 = document.createElement("option");
		element42.setAttribute("value", "M");
		element42.textContent="M";
		var element43 = document.createElement("option");
		element43.setAttribute("value", "F");
		element43.textContent="F";
		element4.appendChild(element41);
		element4.appendChild(element42);
		element4.appendChild(element43);
		
		cell4.appendChild(element4);


		var cell5 = row.insertCell(4);
		var element5 = document.createElement("input");
		//element2.type = "text";
		//element2.name = "name";
		element5.setAttribute("name", "age");
		element5.setAttribute("autocomplete", "off");	
		element5.setAttribute("type", "text");
		element5.setAttribute("class", "round default-width-input");
		cell5.appendChild(element5);
		
		var cell6 = row.insertCell(5);
		var element6 = document.createElement("input");
		//element2.type = "text";
		//element2.name = "name";
		element6.setAttribute("name", "startDate");
		element6.setAttribute("type", "text");
		element6.setAttribute("id", "datepicker-2");
		element6.setAttribute("readonly", "true");
		//element6.setAttribute("class", "round default-width-input");
		cell6.appendChild(element6);
		 $( "#datepicker-2" ).datepicker({
			 
			 dateFormat:"dd-M-yy"

			 });  
		

		var cell7 = row.insertCell(6);
		var element7 = document.createElement("input");
		//element2.type = "text";
		//element2.name = "name";
		element7.setAttribute("name", "salary");
		element7.setAttribute("autocomplete", "off");	
		element7.setAttribute("type", "text");
		element7.setAttribute("class", "round default-width-input");

		var element71 = document.createElement("form:errors");
		//element2.type = "text";
		//element2.name = "name";
		element71.setAttribute("path", "salary");
		element71.setAttribute("cssClass", "error");
		
		cell7.appendChild(element7);
		cell7.appendChild(element71);

		

		

		var cell8 = row.insertCell(7);
		var element8 = document.createElement("a");
		var linkText = document.createTextNode("Delete");
		element8.appendChild(linkText);
		element8.title = "Delete";
		element8.href = "${pageContext.request.contextPath}/employee/deleteemployee/" + maxEmpId;

		cell8.appendChild(element8);

		// disable subsequent clicks
		link.onclick = function(event) {
			event.preventDefault();
		}
	}
</script>
</head>
<body>
	<%@include file="menu.html"%>
	<div id="header"></div>
	<div align="center">
		<h1 class="h1color">All X Employees</h1>

		<br /> <br />
		
		<form:form action="${pageContext.request.contextPath}/employee/fetchspecificemps/${maxEmpId}"
			
			modelAttribute="searchemployees" method="post">
			<table>
			<tbody>
				<tr>
				<td>Filter By Name :</td>
				<td> <form:input id="simplesearchname" type="text"  path="name" autocomplete="off"></form:input>  </td>
				<td> <a  href="#" onclick="document.getElementById('searchfilterby').style.visibility= 'visible';return false;">Advanced Search</a>	</td>
				</tr>
			
			
			
			</tbody>
			
			
			</table>
			 
				<div id="searchfilterby" style="visibility: hidden">
				
			<table>
			<tbody>
				<tr>
				
				<td>Family Name </td>
				<td> <form:input id="filterbyfamilyName" type="text" name = "filterbyfamilyName" path="familyName" autocomplete="off"></form:input>  </td>
				</tr>
				
				<tr>
				
				<td>Gender</td>
				<td> 
				<form:select path="gender">
				<form:option value=""></form:option>
				<form:option value="M">Male</form:option>
				<form:option value="F">Female</form:option>
				</form:select>
				 </td>
				 <td>					</td>
				 <td>Age</td>
				<td> <form:input id="filterbyage" type="text" name = "filterbyage" path="age" autocomplete="off"></form:input>  </td>
				</tr>
				
				
				
				<tr>
				
				<td>Start Date</td>
				<td> 
				<form:input id="datepicker-1" type="text" name = "filterbystartdate" path="startDate" readonly="true"></form:input>
				<script language="javascript"> 
				 $( "#datepicker-1" ).datepicker({
			 
			 dateFormat:"dd-M-yy"

			 }); 
				 </script>
				 </td>
				 <td>					</td>
				 <td>Salary</td>
				<td> <form:input id="filterbysalary" type="text" name = "filterbysalary" path="salary" autocomplete="off"></form:input>  </td>
				</tr>
			
			
			
			
			</tbody>
			
			
			</table>
			
			
			</div>
		
			
			<a  href="#"
							onclick="document.forms[0].submit();return false;">Search</a>
			</form:form>
		
		<br /> <br />
<form:form
			action="${pageContext.request.contextPath}/employee/insertemployee"
			modelAttribute="newemployee" method="post">



			<table id="dataTable" border="1" cellpadding="10"
				style="border-color: #4A135D;">
				<thead>
					<tr>
						<th>Employee ID</th>
						<th>Name</th>
						<th>Family Name</th>
						<th>Gender</th>
						<th>Age</th>
						<th>Start Date</th>
						<th>Salary</th>
						<th>Action</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach var="employee" items="${listAllEmployees}">
						<tr>
							<td><c:out value="${employee.empId}" /></td>
							<td><c:out value="${employee.name}" /></td>
							<td><c:out value="${employee.familyName}" /></td>
							<td><c:out value="${employee.gender}" /></td>
							<td><c:out value="${employee.age}" /></td>
							<td><c:out value="${employee.startDate}" /></td>
							<td><c:out value="${employee.salary}" /></td>

							<td><a
								href="<c:url value="/employee/deleteemployee/${employee.empId}"/>">Delete</a>
							</td>
						</tr>
					</c:forEach>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td><a id="savelink" href="#"
							onclick="document.getElementById('messageerror').style.visibility= 'visible';document.forms[1].submit();return false;"
							style="visibility: hidden;">Save</a></td>
							
						<td><a href="#"
							onclick="addRow('dataTable',${maxEmpId},this);">Add New </a></td>
					</tr>

				</tbody>
			</table>
			<div id="messageerror">
			<c:if test="${not empty hasErrors}">
				<p style="color:red;">${hasErrors}</p>
			</c:if>
			</div>
			
			
		</form:form>
		
	</div>


</body>
</html>