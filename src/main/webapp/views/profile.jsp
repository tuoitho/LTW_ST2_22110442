<%@ page import="com.ldt.models.UserModel" %>
<%@include file="/commons/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:url value="/" var="URL"></c:url>

<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet"
      type="text/css">
<link href="${URL}assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="${URL}assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css">
<link href="${URL}assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="${URL}assets/global/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css">
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN PAGE LEVEL STYLES -->
<link href="${URL}assets/global/plugins/bootstrap-fileinput/bootstrap-fileinput.css" rel="stylesheet" type="text/css"/>
<link href="${URL}assets/admin/pages/css/profile.css" rel="stylesheet" type="text/css"/>
<link href="${URL}assets/admin/pages/css/tasks.css" rel="stylesheet" type="text/css"/>
<!-- END PAGE LEVEL STYLES -->
<!-- BEGIN THEME STYLES -->
<link href="${URL}assets/global/css/components-rounded.css" id="style_components" rel="stylesheet" type="text/css">
<link href="${URL}assets/global/css/plugins.css" rel="stylesheet" type="text/css">
<link href="${URL}assets/admin/layout3/css/layout.css" rel="stylesheet" type="text/css">
<link href="${URL}assets/admin/layout3/css/themes/default.css" rel="stylesheet" type="text/css" id="style_color">
<link href="${URL}assets/admin/layout3/css/custom.css" rel="stylesheet" type="text/css">
<!-- END THEME STYLES -->
<link rel="shortcut icon" href="favicon.ico"/>
<div class="page-content">
    <div class="container">
        <!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
        <div class="modal fade" id="portlet-config" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
             aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                        <h4 class="modal-title">Modal title</h4>
                    </div>
                    <div class="modal-body">
                        Widget settings form goes here
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn blue">Save changes</button>
                        <button type="button" class="btn default" data-dismiss="modal">Close</button>
                    </div>
                </div>
                <!-- /.modal-content -->
            </div>
            <!-- /.modal-dialog -->
        </div>
        <!-- /.modal -->
        <!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->


        <!-- BEGIN PAGE CONTENT INNER -->
        <div class="row margin-top-10">
            <div class="col-md-12">
                <!-- BEGIN PROFILE CONTENT -->
                <div class="profile-content">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="portlet light">
                                <div class="portlet-body">
                                        <!-- CHANGE AVATAR TAB -->
                                        <div class="tab-pane" id="tab_1_2">

                                            <form action="${pageContext.request.contextPath}/profile" role="form" method="post" enctype="multipart/form-data">
                                                <div class="form-group">
                                                    <label class="control-label">Username</label>
                                                    <input type="text" placeholder="Username" class="form-control" name="username" value="${user.username}">
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label">Fullname</label>
                                                    <input type="text" placeholder="Fullname" class="form-control" name="fullname" value="${user.fullname}">
                                                </div>
<%--                                                email--%>
                                                <div class="form-group">
                                                    <label class="control-label">Email</label>
                                                    <input type="text" placeholder="Email" class="form-control" name="email" value="${user.email}">
                                                </div>
<%--                                                phone--%>
                                                <div class="form-group">
                                                    <label class="control-label">Phone</label>
                                                    <input type="text" placeholder="Phone" class="form-control" name="phone" value="${user.phone}">
                                                </div>
                                                <div class="form-group">
<%--                                                    <div class="fileinput fileinput-new" data-provides="fileinput">--%>
<%--                                                        <div class="fileinput-new thumbnail"--%>
<%--                                                             style="width: 200px; height: 150px;">--%>
<%--                                                            <c:if test="${user.images != null}">--%>
<%--                                                                <img src="${pageContext.request.contextPath}image?fname=${user.avatar}"--%>
<%--                                                                     alt=""/>--%>
<%--                                                            </c:if>--%>
<%--                                                            <c:if test="${user.images == null}">--%>
<%--                                                                <img src="http://www.placehold.it/200x150/EFEFEF/AAAAAA&amp;text=no+image"--%>
<%--                                                                     alt=""/>--%>
<%--                                                            </c:if>--%>
<%--&lt;%&ndash;                                                            <img src="http://www.placehold.it/200x150/EFEFEF/AAAAAA&amp;text=no+image"&ndash;%&gt;--%>
<%--&lt;%&ndash;                                                                 alt=""/>&ndash;%&gt;--%>
<%--                                                        </div>--%>
<%--                                                        <div class="fileinput-preview fileinput-exists thumbnail"--%>
<%--                                                             style="max-width: 200px; max-height: 150px;">--%>
<%--                                                        </div>--%>
<%--                                                        <div>--%>
<%--																<span class="btn default btn-file">--%>
<%--																<span class="fileinput-new">--%>
<%--																Select image </span>--%>
<%--																<span class="fileinput-exists">--%>
<%--																Change </span>--%>
<%--																<input type="file" name="...">--%>
<%--																</span>--%>
<%--                                                            <a href="#" class="btn default fileinput-exists"--%>
<%--                                                               data-dismiss="fileinput">--%>
<%--                                                                Remove </a>--%>
<%--                                                        </div>--%>

                                                        <label for="images">Images:</label><br>

                                                        <input type="file" onchange="chooseFile(this)" id="images" name="images" >
                                                        <c:if test="${user.images.substring(0,5)!='https'}">
                                                            <c:url value="/image?fname=${user.images}" var="imgUrl"></c:url>
                                                        </c:if>
                                                        <c:if test="${user.images.substring(0,5)=='https'}">
                                                            <c:url value="${user.images }" var="imgUrl"></c:url>
                                                        </c:if>
                                                        <img id="imagess" height="150" width="200" src="${imgUrl}"/>
                                                    </div>
                                                    <div class="clearfix margin-top-10">
                                                        <span class="label label-danger">NOTE! </span>
                                                        <span>Attached image thumbnail is supported in Latest Firefox, Chrome, Opera, Safari and Internet Explorer 10 only </span>
                                                    </div>
                                                </div>
                                                <div class="margin-top-10">
                                                    <input type="submit"  class="btn green-haze" value="Submit">
                                                </div>
                                            </form>
                                        </div>
                                        <!-- END CHANGE AVATAR TAB -->

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- END PROFILE CONTENT -->
            </div>
        </div>
        <!-- END PAGE CONTENT INNER -->
    </div>
</div>
<script src="${URL}assets/global/plugins/jquery.min.js" type="text/javascript"></script>
<script src="${URL}assets/global/plugins/jquery-migrate.min.js" type="text/javascript"></script>
<!-- IMPORTANT! Load jquery-ui-1.10.3.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
<script src="${URL}assets/global/plugins/jquery-ui/jquery-ui-1.10.3.custom.min.js" type="text/javascript"></script>
<script src="${URL}assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${URL}assets/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js"
        type="text/javascript"></script>
<script src="${URL}assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="${URL}assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="${URL}assets/global/plugins/jquery.cokie.min.js" type="text/javascript"></script>
<script src="${URL}assets/global/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<script src="${URL}assets/global/plugins/bootstrap-fileinput/bootstrap-fileinput.js" type="text/javascript"></script>
<script src="${URL}assets/global/plugins/jquery.sparkline.min.js" type="text/javascript"></script>
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${URL}assets/global/scripts/metronic.js" type="text/javascript"></script>
<script src="${URL}assets/admin/layout3/scripts/layout.js" type="text/javascript"></script>
<script src="${URL}assets/admin/layout3/scripts/demo.js" type="text/javascript"></script>
<script src="${URL}assets/admin/pages/scripts/profile.js" type="text/javascript"></script>
<!-- END PAGE LEVEL SCRIPTS -->
<script>
    jQuery(document).ready(function () {
        // initiate layout and plugins
        Metronic.init(); // init metronic core components
        Layout.init(); // init current layout
        Demo.init(); // init demo features\
        Profile.init(); // init page demo
    });
</script>