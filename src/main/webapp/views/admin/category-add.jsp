<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<form action="${pageContext.request.contextPath}/admin/category/insert" method="post" enctype="multipart/form-data">
    <label for="categoryname">Category name:</label><br>
    <input type="text" id="categoryname" name="categoryname"><br>
    <label for="images">Images:</label><br>
    <input type="file" onchange="chooseFile(this)" id="images" name="images" >
    <br>
    <label for="status">Status:</label><br>
    <select id="status" name="status">
        <option value="1">Hoạt động</option>
        <option value="0">Khoá</option>
    </select>
    <br>
    <input type="submit" value="Submit">

</form>