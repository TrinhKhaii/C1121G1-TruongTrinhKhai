<%--
  Created by IntelliJ IDEA.
  User: truongtrinhkhai
  Date: 27/03/2022
  Time: 19:13
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
                </div>
            </div>
            <table class="table table-striped table-hover" id="example">
                <thead>
                <tr>
                    <th>Mã mượn sách</th>
                    <th>Tên sách</th>
                    <th>Tác giả</th>
                    <th>Tên học sinh</th>
                    <th>Lớp</th>
                    <th>Ngày mượn</th>
                    <th>Ngày trả</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="libraryCard" items="${libraryCardDTOList}">
                    <tr>
                        <td>${libraryCard.getLibraryCardId()}</td>
                        <td>${libraryCard.getBookName()}</td>
                        <td>${libraryCard.getBookAuthor()}</td>
                        <td>${libraryCard.getStudentName()}</td>
                        <td>${libraryCard.getStudentClassName()}</td>
                        <td>${libraryCard.getStartDate()}</td>
                        <td>${libraryCard.getEndDate()}</td>
                        <td>
                            <a href="#deleteEmployeeModal" class="delete" data-toggle="modal"><i
                                    class="material-icons" data-toggle="tooltip" title="Delete"
                                    onclick='sendLibraryCardId("${libraryCard.getLibraryCardId()}")'>&#xE872;</i></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<div id="deleteEmployeeModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form method="post" action="book?action=delete">
                <input type="hidden" name="id_modal_delete" id="isDelete">
                <div class="modal-header">
                    <h4 class="modal-title">Delete Employee</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <p>Are you sure you want to delete these Records?</p>
                    <p class="text-warning"><small>This action cannot be undone.</small></p>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-danger" value="Delete">
                </div>
            </form>
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
        document.getElementById('idEdit').value = bookId;
        document.getElementById('bookName').value = bookName;
        document.getElementById('bookAmount').value = bookAmount;

    }

    function sendLibraryCardId(id) {
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

