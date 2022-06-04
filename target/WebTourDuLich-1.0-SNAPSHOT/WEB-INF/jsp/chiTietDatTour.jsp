<%-- 
    Document   : chiTietDatTour
    Created on : Oct 13, 2021, 8:05:12 AM
    Author     : Acer
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div id="bg-quan-ly" class="">
    <div class="container mr-auto ml-auto">
        <h1 class="text-center">Chi tiết tour</h1>
        <h6></h6>
        <table class="table bg-light">
            <tr class="text-white h5 bg-tb">
                <th class="text-center">Mã tour</th>
                <th class="text-center">Tên tour</th>
                <th class="text-center">Số lượng</th>
                <th class="text-center">Giá</th>
                <th class="text-center">Tổng tiền</th>
            </tr>
            <c:forEach var="nd" items="${chiTietDat}">
                <tr class="">
                    <td class="text-center">${nd[0]}</td>
                    <td class="text-center">${nd[1]}</td>
                    <td class="text-center">${nd[2]}</td>
                    <td class="text-center giaTien">${nd[3]}</td>
                    <td class="text-center giaTien">${nd[4]}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
