<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <%@ include file="../layout/header.jsp" %>

        <div class="container my-3">
            <form class="mb-1">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Enter title" name="title" id="title">
                </div>

                <div class="form-group">
                    <textarea class="form-control summernote" rows="5" id="content" name="content"></textarea>
                </div>
                <button type="button" class="btn btn-primary" onclick="saveBoard()">글쓰기완료</button>
            </form>


        </div>

        <script>
            $('.summernote').summernote({
                tabsize: 2,
                height: 400
            });


            function saveBoard() {
                let data = {
                    title: $("#title").val(),
                    content: $("#content").val()
                };

                $.ajax({
                    type:"post",
                    url:"/board",
                    data : JSON.stringify(data),
                    dataType :"Json", // 기입하지 않으면 디폴트로 응답의 mime 타입으로 유추함
                    headers : {
                    "Content-Type": "application/json; charset=UTF-8"
                     }
                }).done((res) => {
                    location.href = "/";
                }).fail((err) => {
                    alert(err.responseJSON.msg);
                });
            }
        </script>

        <%@ include file="../layout/footer.jsp" %>