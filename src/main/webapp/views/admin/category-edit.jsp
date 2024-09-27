<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<form action="${pageContext.request.contextPath}/admin/category/update" method="post" enctype="multipart/form-data">
    <input type="text" id="categoryid" name="categoryid" value="${cate.categoryid}" hidden>
    <label for="categoryname">Category name:</label><br>
    <input type="text" id="categoryname" name="categoryname" value="${cate.categoryname}"><br>
    <label for="images">Images:</label><br>
    <input type="file" onchange="chooseFile(this)" id="images" name="images" >
    <c:if test="${cate.images.substring(0,5)!='https'}">
        <c:url value="/image?fname=${cate.images}" var="imgUrl"></c:url>
    </c:if>
    <c:if test="${cate.images.substring(0,5)=='https'}">
        <c:url value="${cate.images }" var="imgUrl"></c:url>
    </c:if>
    <img id="imagess" height="150" width="200" src="${imgUrl}"/>


    <br>
    <label for="status">Status:</label><br>
<%--    choose Khoa--%>
    <select id="status" name="status"   >
        <option value="1" ${status != null && status.equals('1') ? "selected" : ''}>Hoạt động</option>
        <option  value="0" ${status != null && status.equals('0') ? "selected" : ''}>Khoá</option>
    </select>
    <br>
    <input type="submit" value="Submit">

</form>