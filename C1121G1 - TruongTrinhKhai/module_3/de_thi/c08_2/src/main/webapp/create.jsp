<%--
  Created by IntelliJ IDEA.
  User: truongtrinhkhai
  Date: 23/03/2022
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>C0921G1</title>
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
                        <a href="medicalrecord" style="text-decoration: none; color: white;"><h2>Manage <b>Products</b>   C1121G1 - <b>Trương Trịnh Khải</b></h2></a>
                    </div>
                </div>
            </div>
<%--            here--%>
            <form method="post" action="medicalrecord?action=create">
                <div class="form-group row">
                    <label for="exampleFormControlInput1" class="col-sm-2 col-form-label">Mã bệnh án</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="exampleFormControlInput1" name="medical_record_code" placeholder="Nhập mã bệnh án" value="${medicalRecordDTO.getCode()}">
                        <c:choose>
                            <c:when test="${code != null}">
                                <small class="text-danger">${code}</small>
                            </c:when>
                            <c:otherwise>
                                <small class="text-danger">${error.get("code")}</small>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="exampleFormControlInput2" class="col-sm-2 col-form-label">Mã bệnh nhân</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="exampleFormControlInput2" name="patient_code" placeholder="Nhập mã bệnh nhân" value="${medicalRecordDTO.getPatientCode()}">
                        <small class="text-danger">${error.get("patientCode")}</small>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="exampleFormControlInput3" class="col-sm-2 col-form-label">Tên bệnh nhân</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="exampleFormControlInput3" name="patient_name" placeholder="Nhập tên bệnh nhân" value="${medicalRecordDTO.getPatientName()}">
                        <small class="text-danger">${error.get("patientName")}</small>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="exampleFormControlInput4" class="col-sm-2 col-form-label">Ngày nhập viện</label>
                    <div class="col-sm-10">
                        <input type="date" class="form-control" id="exampleFormControlInput4" name="startDate" value="${medicalRecordDTO.getStartDate()}">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="exampleFormControlInput5" class="col-sm-2 col-form-label">Ngày xuất viện</label>
                    <div class="col-sm-10">
                        <input type="date" class="form-control" id="exampleFormControlInput5" name="endDate" value="${medicalRecordDTO.getEndDate()}">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="exampleFormControlInput6" class="col-sm-2 col-form-label">Lý do nhập viện</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="exampleFormControlInput6" name="reason" placeholder="Nhập lý do nhập viện" value="${medicalRecordDTO.getReason()}">
                        <small class="text-danger">${error.get("reason")}</small>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-10">
                        <button type="submit" class="btn btn-primary">Add</button>
                        <p>
                            <c:if test='${messenger != null}'>
                                <span class="text-success">${messenger}</span>
                            </c:if>
                        </p>
                    </div>
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
    $(document).ready(function(){
        // Activate tooltip
        $('[data-toggle="tooltip"]').tooltip();

        // Select/Deselect checkboxes
        var checkbox = $('table tbody input[type="checkbox"]');
        $("#selectAll").click(function(){
            if(this.checked){
                checkbox.each(function(){
                    this.checked = true;
                });
            } else{
                checkbox.each(function(){
                    this.checked = false;
                });
            }
        });
        checkbox.click(function(){
            if(!this.checked){
                $("#selectAll").prop("checked", false);
            }
        });
    });

    // Disable form submissions if there are invalid fields
    (function() {
        'use strict';
        window.addEventListener('load', function() {
            // Get the forms we want to add validation styles to
            var forms = document.getElementsByClassName('needs-validation');
            // Loop over them and prevent submission
            var validation = Array.prototype.filter.call(forms, function(form) {
                form.addEventListener('submit', function(event) {
                    if (form.checkValidity() === false) {
                        event.preventDefault();
                        event.stopPropagation();
                    }
                    form.classList.add('was-validated');
                }, false);
            });
        }, false);
    })();
</script>
</html>

