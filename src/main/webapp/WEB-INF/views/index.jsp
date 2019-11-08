<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<!doctype html>
<html lang="en">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src='http://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js'></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" crossorigin="anonymous"></script>
<script src="<%=application.getContextPath()%>/resources/js/app.js"></script>
<script src="<%=application.getContextPath()%>/resources/js/cmm/router.js"></script> 
<script src="<%=application.getContextPath()%>/resources/js/cmm/auth.js"></script> 
<script src="<%=application.getContextPath()%>/resources/js/vue/auth_vue.js"></script> 
<script src="<%=application.getContextPath()%>/resources/js/brd/brd.js"></script> 
<script src="<%=application.getContextPath()%>/resources/js/cmm/navi.js"></script> 
<script src="<%=application.getContextPath()%>/resources/js/vue/navi_vue.js"></script> 
<script src="<%=application.getContextPath()%>/resources/js/cmm/proxy.js"></script>
<script src="<%=application.getContextPath()%>/resources/js/vue/page_vue.js"></script> 
<script>
	app.run('<%=application.getContextPath()%>'); 
</script>
</html>
