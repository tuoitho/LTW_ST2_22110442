<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<a href="${pageContext.request.contextPath}/admin/category/add">Add Category</a>

<table border="1" width="100%">
    <tr>
        <th>STT</th>
        <th>Images</th>
        <th>CategoryID</th>
        <th>CategoryName</th>
        <th>Status</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${listcate}" var="cate" varStatus="STT">
        <tr>
            <td>${STT.index+1 }</td>
            <td>
            <c:if test="${cate.images.substring(0,5)!='https'}">
                <c:url value="/image?fname=${cate.images}" var="imgUrl"></c:url>
            </c:if>
                <c:if test="${cate.images.substring(0,5)=='https'}">
                    <c:url value="${cate.images }" var="imgUrl"></c:url>
                </c:if>
                <img height="150" width="200" src="${imgUrl}"/>



            </td>

            <td>${cate.categoryid }</td>
            <td>${cate.categoryname }</td>
            <td>

            <c:if test="${cate.status==1}">
                <span> Hoạt động</span>
            </c:if>
            <c:if test="${cate.status==0}">
                <span> Khoá</span>
            </c:if>
            </td>
            <td>
                <a href="<c:url value='/admin/category/edit?id=${cate.categoryid }'/>">Sửa</a>
                | <a href="<c:url value='/admin/category/delete?id=${cate.categoryid }'/>">Xóa</a>
            </td>
        </tr>
    </c:forEach>
</table>