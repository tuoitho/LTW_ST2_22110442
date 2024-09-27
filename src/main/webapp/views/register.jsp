<%@include file="/commons/taglib.jsp" %>


<!-- BEGIN CONTENT -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="col-md-12 col-sm-12">
    <div class="content-form-page">
        <div class="row">
            <div class="col-md-7 col-sm-7">
                <c:if test="${alert != null}">
                    <div class="alert  ${(alert eq "success" )? "alert-success" :"alert-danger"}"
                         role="alert">
                            ${alert== 'success' ? 'Register success' : alert}
                    </div>
                </c:if>
                <form action="${pageContext.request.contextPath}/register" method="post" class="form-horizontal"
                      role="form">
                    <fieldset>
                        <legend>Your account details</legend>
                        <div class="form-group">
                            <label for="username" class="col-lg-4 control-label">Username <span class="require">*</span></label>
                            <div class="col-lg-8">
                                <input type="text" class="form-control" id="username" name="username">
                            </div>
                        </div>
                        <%--                        <div class="form-group">--%>
                        <%--                            <label for="fullname" class="col-lg-4 control-label">Full Name <span--%>
                        <%--                                    class="require">*</span></label>--%>
                        <%--                            <div class="col-lg-8">--%>
                        <%--                                <input type="text" class="form-control" id="fullname">--%>
                        <%--                            </div>--%>
                        <%--                        </div>--%>
                        <div class="form-group">
                            <label for="email" class="col-lg-4 control-label">Email <span
                                    class="require">*</span></label>
                            <div class="col-lg-8">
                                <input type="text" class="form-control" id="email" name="email">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="col-lg-4 control-label">Password <span class="require">*</span></label>
                            <div class="col-lg-8">
                                <input type="password" class="form-control" id="password" name="password">
                            </div>
                        </div>
                        <%--                        radio choose role--%>
                        <div class="form-group">
                            <label class="col-lg-4 control-label">Role <span class="require">*</span></label>
                            <div class="col-lg-8">
                                <div class="radio-group">
                                    <label><input type="radio" name="role" value="1" required> USER</label>
                                    <label><input type="radio" name="role" value="2" required> ADMIN</label>
                                    <label><input type="radio" name="role" value="3" required> MANAGER</label>
                                    <label><input type="radio" name="role" value="4" required> SELLER</label>
                                    <label><input type="radio" name="role" value="5" required> SHIPPER</label>
                                </div>
                            </div>
                        </div>
                    </fieldset>
                    <div class="row">
                        <div class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">
                            <button type="submit" class="btn btn-primary">Create an account</button>
                            <button type="button" class="btn btn-default">Cancel</button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="col-md-4 col-sm-4 pull-right">
                <div class="form-info">
                    <h2><em>Important</em> Information</h2>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>

                    <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
                        consequat.</p>

                    <button type="button" class="btn btn-default">More details</button>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- END CONTENT -->