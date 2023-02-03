<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="../layout/header.jsp" %>

        <div class="container my-3">
            <div class="container">
                <form action="/join" method="post" onsubmit="return valid()">
                    <div class="form-group mb-2 d-flex">
                        <input type="text" name="username" class="form-control" placeholder="Enter username"
                            id="username" required>
                        <button class="badge bg-secondary ms-2" type="button">중복확인</button>
                    </div>

                    <div class="form-group mb-2">
                        <input type="password" name="password" class="form-control" placeholder="Enter password"
                            id="password" required>
                    </div>

                    <div class="form-group mb-2">
                        <input type="password" class="form-control" placeholder="Enter passwordCheck" id="passwordCheck"
                            required onchange="passwordChecking()">
                    </div>
                    <div id="passwordCheckAlert""></div>
                    <div class=" form-group mb-2">
                        <input type="email" name="email" class="form-control" placeholder="Enter email" id="email"
                            required>
                    </div>

                    <button type="submit" class="btn btn-primary">회원가입</button>
                </form>

            </div>
        </div>

        <script>
            let checkPassword = false;

            function valid() {
                if (checkPassword == true) {
                    return true;
                }
                return false;
            }

            function passwordChecking() {
                let p1 = $("#password").val();
                let p2 = $("#passwordCheck").val();

                if (p1 != p2) {
                    checkPassword = false;
                    $("#passwordCheckAlert").empty();
                    let alertbox = ` <div class="alert alert-warning">
                                    <strong>Checking!</strong> 비밀번호 불일치</div>`;
                    $("#passwordCheckAlert").append(alertbox);
                } else {
                    checkPassword = true;
                    $("#passwordCheckAlert").empty();
                    let alertbox = `<div class="alert alert-info">
                                    <strong>Complete!</strong> 비밀번호 일치</div>`;
                    $("#passwordCheckAlert").append(alertbox);
                }
            }

        </script>

        <%@ include file="../layout/footer.jsp" %>