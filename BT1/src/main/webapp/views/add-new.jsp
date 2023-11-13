<%--
  Created by IntelliJ IDEA.
  User: manht
  Date: 12/11/2023
  Time: 10:47 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.tailwindcss.com"></script>

    <title>Title</title>
</head>
<body>
<div class="w-full min-h-[1500px] pt-[100px] bg-zinc-200 flex justify-center">
    <div class="w-[400px]">
        <form action="/" method="POST" class="w-full bg-white flex flex-col items-center rounded-xl overflow-hidden shadow shadow-xl">
            <div class="h-[80px] flex items-center text-2xl font-semibold bg-stone-500 w-full text-center text-white mb-6 justify-center">
                <h1>Thêm sản phẩm</h1>
            </div>

            <div class="w-[80%]">
                <div class="mb-6">
                    <label class="mb-[8px] inline-block font-semibold">Tên sản phẩm</label>
                    <br/>
                    <input type="text" name="productName" class="w-full outline-none border-b border-zinc-700 px-2">
                </div>

                <div class="mb-6">
                    <label class="mb-[8px] inline-block font-semibold">Mô tả sản phẩm</label>
                    <br/>
                    <input type="text" name="description" class="w-full outline-none border-b border-zinc-700 px-2">
                </div>

                <div class="mb-6">
                    <label class="mb-[8px] inline-block font-semibold">Giá sản phẩm</label>
                    <br/>
                    <input type="text" name="price" class="w-full outline-none border-b border-zinc-700 px-2">
                </div>

                <div class="flex justify-end my-5">
                    <button type="submit" class="py-1 px-2 bg-stone-500 text-white font-semibold
                    text-lg hover:bg-stone-700 duration-300 rounded-lg">
                        Thêm mới
                    </button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
