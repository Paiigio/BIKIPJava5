<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

    <title>Title</title>
</head>
<body>
<div class="container">
    <form action="/khach-hang/search">
        <p>Search</p>
        <input type="text" name="ten">
        <h3>Mã hạng</h3>
        <select name="hang" class="form-control" >
            <c:forEach var="l" items="${list_Hang}">
                <option value="${l.maHang}">${l.tenHang}</option>
            </c:forEach>
        </select>
        <button type="submit">Search</button>
    </form>
</div>
<div class="container">
    <%--@elvariable id="s" type=""--%>
    <form:form action="/khach-hang/add" modelAttribute="s">
<%--        <div class="form-group">--%>

<%--            <h3>Mã</h3>--%>
<%--            <form:input path="maKhachHang" type="text" class="form-control" value="${s.maKhachHang}"/>--%>
<%--            <p style="color: red">${LoiMa}</p>--%>
<%--        </div>--%>
        <div class="form-group">
            <h3>Tên </h3>
            <form:input path="tenKhachHang" type="text" class="form-control" value="${s.tenKhachHang}"/>
            <p style="color: red">${loiten}</p>
        </div>
        <div class="form-group">
            <h3>SDT</h3>
            <form:input  path="soDienThoai" type="text" class="form-control" value="${s.soDienThoai}"/>
            <p style="color: red">${loisdt}</p>
        </div>
        <div class="form-group">
            <h3>Mã hạng</h3>
            <form:select path="hangKhachHang.maHang" class="form-control" onclick="loadTen()">
                <c:forEach var="l" items="${listHang}">
                    <form:option value="${l.maHang}">${l.maHang}</form:option>
                </c:forEach>
            </form:select>
            <p id="tenKH" style="color: red"></p>
        </div>
        <div class="form-group">
            <form:radiobutton  path="gioiTinh"  value="false"/>Nam
            <form:radiobutton  path="gioiTinh"  value="true"/>Nữ

        </div>
        <button class="btn btn-primary">ADD</button>
    </form:form>

    <div class="container">
        <table class="table table-stripped">
            <thead>
            <th>#</th>
            <th>Tên khách hàng</th>
            <th>SDT</th>
            <th>Giới Tính</th>
            <th>Tên hạng</th>
            <th>Action</th>

            </thead>
            <c:forEach var="o" items="${list.content}" varStatus="stt">
                <tr>
                    <td>${stt.index+1}</td>
                    <td>${o.tenKhachHang}</td>
                    <td>${o.soDienThoai}</td>
                    <td>${o.gioiTinh==false?"Nam":"Nữ"}</td>
                    <td>${o.hangKhachHang.tenHang}</td>
                    <td>
                        <a href="/khach-hang/delete/${o.maKhachHang}" onclick="return confirm('Bạn có muốn xóa không?')" class="btn btn-danger">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <c:if test="${list.totalPages>0}">
            <nav aria-label="Page navigation example">
                <ul class="pagination">
                    <c:forEach begin="0" end="${list.totalPages -1}" varStatus="loop">
                        <li class="page-item">
                            <a class="page-link" href="/khach-hang/hien-thi?page=${loop.index}">
                                    ${loop.index +1 }
                            </a>
                        </li>
                    </c:forEach>
                </ul>
            </nav>
        </c:if>
    </div>
</div>

<c:if test="${not empty ThongBao}">
    <script>
        alert("${ThongBao}")
    </script>
</c:if>
<script>
    function loadTen() {
        var ma=event.target.value;
        <c:forEach var="l" items="${listHang}">
        var maK='${l.maHang}';
        if(ma==maK){
            var ten='${l.tenHang}';
            document.getElementById("tenKH").innerHTML=ten;
        }
        </c:forEach>
    }
</script>
</body>
</html>