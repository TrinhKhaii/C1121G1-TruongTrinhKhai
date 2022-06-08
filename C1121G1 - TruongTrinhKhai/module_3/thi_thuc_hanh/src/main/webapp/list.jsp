<%--
  Created by IntelliJ IDEA.
  User: truongtrinhkhai
  Date: 24/03/2022
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>C1121G1</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div class="container-fluid-xl">
    <div class="table-responsive">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-6">
                        <a href="book" style="text-decoration: none; color: white;"><h2>Danh sách <b>sách</b>
                            C1121G1 - <b>Trương Trịnh Khải</b></h2></a>
                    </div>
                    <div class="col-sm-6">
                        <form method="get">
                            <input type="hidden" name="action" value="borrow_book_list">
                            <input class="btn btn-success" data-toggle="modal" type="submit" value="Danh sách sách đang mượn">
                        </form>
                    </div>
                </div>
            </div>
            <table class="table table-striped table-hover" id="example">
                <thead>
                <tr>
                    <th>STT</th>
                    <th>Mã sách</th>
                    <th>Tên sách</th>
                    <th>Tác giả</th>
                    <th>Số lượng</th>
                    <th>Mô tả</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="book" items="${bookList}" varStatus="count">
                    <tr>
                        <td>${count.count}</td>
                        <td>${book.getBookId()}</td>
                        <td>${book.getBookName()}</td>
                        <td>${book.getAuthor()}</td>
                        <td>${book.getAmount()}</td>
                        <td>${book.getDescription()}</td>
                        <td>
                            <a href="#borrowBookModal" class="edit" data-toggle="modal" onclick='sendBookInfor("${book.getBookId()}", "${book.getBookName()}", "${book.getAmount()}")'>Mượn</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<!-- Borrow Modal HTML -->
<div id="borrowBookModal" class="modal fade">
    <input type="hidden" name="book_amount" id="bookAmount">
    <div class="modal-dialog">
        <div class="modal-content">
            <c:if test="${bookAmount == 0}">
                <div class="modal" tabindex="-1">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">Lỗi !!!!</h5>
                            </div>
                            <div class="modal-body">
                                <p>Cuốn sách này tạm thời đã cho mượn hết, vui lòng chọn sách khác</p>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-primary">OK</button>
                            </div>
                        </div>
                    </div>
                </div>
            </c:if>
            <c:if test="${bookAmount != 0}">
                <form method="post" action="book?action=borrow" class="needs-validation" novalidate>
                    <input type="hidden" name="book_id" id="bookId">

                    <div class="modal-header">
                        <h4 class="modal-title">Mượn Sách</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label>Mã mượn sách</label>
                            <input type="text" class="form-control" name="library_card_id" id="libraryCardId"
                                   required pattern="^MS-\d{4}$">
                            <div class="valid-feedback">ok</div>
                            <div class="invalid-feedback">Mã mượn sách phải có định dạng MS-XXXX, X là số tự nhiên</div>
                        </div>
                        <div class="form-group">
                            <label>Tên sách</label>
                            <input type="text" class="form-control" name="book_name" id="bookName" required
                                   pattern="" disabled>
                            <div class="valid-feedback">ok</div>
                            <div class="invalid-feedback">Mã bệnh nhân có định dạng BN-XXX, X là số tự nhiên</div>
                        </div>
                        <div class="form-group">
                            <div class="form-group">
                                <label>Tên học sinh</label>
                                <select class="form-control" name="student_id">
                                    <c:forEach items="${studentList}" var="student">
                                        <option value="${student.getStudentId()}">${student.getStudentName()}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label>Ngày mượn</label>
                            <fmt:formatDate var="fmtDate" value="<%=new java.util.Date()%>" pattern="dd/MM/yyyy"/>
                            <input type="text" class="form-control" name="start_date" id="startDate" value="${fmtDate}" placeholder="${fmtDate}" disabled/>
                        </div>
                        <div class="form-group">
                            <label>Ngày trả sách</label>
                            <input type="date" class="form-control" name="end_date" id="endDate" required>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <input type="button" class="btn btn-default" data-dismiss="modal" value="Hủy">
                        <input type="submit" class="btn btn-info" value="Mượn sách">
                    </div>
                </form>
            </c:if>
        </div>
    </div>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<%--script phân trang--%>
<script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.11.5/js/dataTables.bootstrap4.min.js"></script>

<script>
    $(document).ready(function () {
        // Activate tooltip
        $('[data-toggle="tooltip"]').tooltip();

        // Select/Deselect checkboxes
        var checkbox = $('table tbody input[type="checkbox"]');
        $("#selectAll").click(function () {
            if (this.checked) {
                checkbox.each(function () {
                    this.checked = true;
                });
            } else {
                checkbox.each(function () {
                    this.checked = false;
                });
            }
        });
        checkbox.click(function () {
            if (!this.checked) {
                $("#selectAll").prop("checked", false);
            }
        });
    });

    function sendBookInfor(bookId, bookName, bookAmount) {
        document.getElementById('bookId').value = bookId;
        document.getElementById('bookName').value = bookName;

            document.getElementById('bookAmount').value = bookAmount;

    }

    function sendMedicalRecordId(id) {
        document.getElementById('isDelete').value = id;
    }

    // Disable form submissions if there are invalid fields
    (function () {
        'use strict';
        window.addEventListener('load', function () {
            // Get the forms we want to add validation styles to
            var forms = document.getElementsByClassName('needs-validation');
            // Loop over them and prevent submission
            var validation = Array.prototype.filter.call(forms, function (form) {
                form.addEventListener('submit', function (event) {
                    if (form.checkValidity() === false) {
                        event.preventDefault();
                        event.stopPropagation();
                    }
                    form.classList.add('was-validated');
                }, false);
            });
        }, false);
    })();

    // Phan trang
    $.extend(true, $.fn.dataTable.defaults, {
        "searching": false,
        "ordering": false
    });
    $(document).ready(function () {
        $('#example').DataTable({
            "lengthMenu": [[5, 10, 15, -1], [5, 10, 15, "All"]]
        });
    });
</script>
</html>
