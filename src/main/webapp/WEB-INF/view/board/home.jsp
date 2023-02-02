<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>home</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script src="https://kit.fontawesome.com/32aa2b8683.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" / </head>


<body>

    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="/">Blog</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse justify-content-between" id="collapsibleNavbar">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="/loginForm">로그인</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/joinForm">회원가입</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/board/writeForm">글쓰기</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/user/updateForm">회원정보</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/logout">로그아웃</a>
                    </li>
                </ul>
                <div>
                    <a href="/user/profileUpdate"><img src="images/profile.jfif" style="width: 35px;"
                            class="rounded-circle" alt="Cinque Terre"></a>
                </div>
            </div>

        </div>
    </nav>

    <div class="container my-3">
        <div class="my-board-box row">
            <div class="card col-lg-3">
                <img class="card-img-top" style="height: 250px;" src="images/profile.jfif" alt="Card image">
                <div class="card-body">
                    <h4 class="card-title my-text-ellipsis">제목입니다제목입니다제목입니다제목입니다제목입니다제목입니다</h4>
                    <a href="#" class="btn btn-primary">상세보기</a>
                </div>
            </div>
            <div class="card col-lg-3">
                <img class="card-img-top" style="height: 250px;" src="images/profile.jfif" alt="Card image">
                <div class="card-body">
                    <h4 class="card-title my-text-ellipsis">제목입니다제목입니다제목입니다제목입니다제목입니다제목입니다</h4>
                    <a href="#" class="btn btn-primary">상세보기</a>
                </div>
            </div>
            <div class="card col-lg-3">
                <img class="card-img-top" style="height: 250px;" src="images/profile.jfif" alt="Card image">
                <div class="card-body">
                    <h4 class="card-title my-text-ellipsis">제목입니다제목입니다제목입니다제목입니다제목입니다제목입니다</h4>
                    <a href="#" class="btn btn-primary">상세보기</a>
                </div>
            </div>
            <div class="card col-lg-3">
                <img class="card-img-top" style="height: 250px;" src="images/profile.jfif" alt="Card image">
                <div class="card-body">
                    <h4 class="card-title my-text-ellipsis">제목입니다제목입니다제목입니다제목입니다제목입니다제목입니다</h4>
                    <a href="#" class="btn btn-primary">상세보기</a>
                </div>
            </div>
        </div>
        <ul class="pagination mt-3 d-flex justify-content-center">
            <li class="page-item disabled"><a class="page-link" href="#">Previous</a></li>
            <li class="page-item"><a class="page-link" href="#">Next</a></li>
        </ul>
    </div>

    <div class="mt-4 p-5 bg-dark text-white rounded text-center" style="margin-bottom: 0">
        <p>Created by MetaCoding</p>
        <p>📞 010-2222-7777</p>
        <p>🏴 부산 수영구 XX동</p>
    </div>
</body>

</html>