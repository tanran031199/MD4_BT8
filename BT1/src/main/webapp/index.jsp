<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.tailwindcss.com"></script>

    <title>JSP - Hello World</title>
</head>
<body>
<div class="w-full min-h-[1500px] pt-[100px] bg-zinc-500 flex justify-center">
    <div class="w-[650px]">
        <table class="w-full bg-white">
            <thead class="bg-stone-600 text-white font-semibold text-lg h-[50px]">
            <tr>
                <td class="p-2">ID</td>
                <td class="p-2">Tên sản phẩm</td>
                <td class="p-2">Mô tả sản phẩm</td>
                <td class="p-2">Giá sản phẩm</td>
                <td class="p-2" colspan="2">Hành động</td>
            </tr>
            </thead>

            <tbody>
            <c:set var="count" scope="session" value="0"/>
            <c:forEach items="${products}" var="p">
                <c:set var="count" scope="session" value="${count + 1}"/>
                <tr class="even:bg-stone-200 hover:bg-stone-300">
                    <td class="p-2">${count}</td>
                    <td class="p-2">${p.getName()}</td>
                    <td class="p-2">${p.getDescription()}</td>
                    <td class="p-2">
                        <fmt:setLocale value="vi_VN"/>
                        <fmt:formatNumber value="${p.getPrice()}" type="currency"/>
                    </td>
                    <td class="p-2">
                        <a href="${req.getContextPath()}?action=update&id=${p.getId()}" class="p-1.5 bg-lime-400 font-semibold text-white inline-block rounded-lg cursor-pointer hover:bg-lime-600 duration-300">Edit</a>
                    </td>
                    <td class="p-2">
                        <a href="${req.getContextPath()}?action=delete&id=${p.getId()}"
                           class="p-1.5 bg-lime-400 font-semibold text-white inline-block rounded-lg cursor-pointer hover:bg-lime-600 duration-300">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <div class="flex justify-end mt-3">
            <a href="${req.getContextPath()}/views/add-new.jsp"
               class="p-1.5 bg-lime-400 font-semibold text-white inline-block rounded-lg cursor-pointer hover:bg-lime-600 duration-300">Thêm
                mới sản phẩm</a>
        </div>
    </div>
</div>
</body>
</html>