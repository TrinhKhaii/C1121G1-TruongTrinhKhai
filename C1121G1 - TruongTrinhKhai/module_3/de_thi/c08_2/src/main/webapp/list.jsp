<%--
  Created by IntelliJ IDEA.
  User: truongtrinhkhai
  Date: 23/03/2022
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>C0821G1</title>
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
                    <div class="col-sm-6">
                        <a href="medicalrecord?action=create" class="btn btn-success"><i class="material-icons">&#xE147;</i> <span>Add New Medical Record</span></a>
                    </div>
                </div>
<%--                <div class="row">--%>
<%--                    <form method="get">--%>
<%--                        <br/>--%>
<%--                        <input type="hidden" name="action" value="search">--%>
<%--                        <input type="text" name="search_by_name" size="25" placeholder="Enter Product Name">--%>
<%--                        <input type="text" name="search_by_price" size="25" placeholder="Enter Price">--%>
<%--                        <input type="text" name="search_by_color" size="25" placeholder="Enter Color">--%>
<%--                        <input type="text" name="search_by_category" size="25" placeholder="Enter Category">--%>
<%--                        <input type="submit" value="tìm kiếm">--%>
<%--                    </form>--%>
<%--                </div>--%>
            </div>
            <table class="table table-striped table-hover" id="example">
                <thead>
                <tr>
                    <th>STT</th>
                    <th>Mã bệnh án</th>
                    <th>Mã bệnh nhân</th>
                    <th>Tên bệnh nhân</th>
                    <th>Ngày nhập viện</th>
                    <th>Ngày ra viện</th>
                    <th>Lý do nhập viện</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="medicalRecord" items="${medicalRecordDTOList}">
                    <tr>
                        <td>${medicalRecord.getId()}</td>
                        <td>${medicalRecord.getCode()}</td>
                        <td>${medicalRecord.getPatientCode()}</td>
                        <td>${medicalRecord.getPatientName()}</td>
                        <td>${medicalRecord.getStartDate()}</td>
                        <td>${medicalRecord.getEndDate()}</td>
                        <td>${medicalRecord.getReason()}</td>
                        <td>
                            <a href="#editEmployeeModal" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit" onclick='sendProductInfor("${product.getId()}", "${product.getName()}", "${product.getPrice()}", "${product.getQuantity()}", "${product.getColor()}", "${product.getCategoryId()}")'>&#xE254;</i></a>
                            <a href="#deleteEmployeeModal" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete" onclick='sendProductId("${product.getId()}")'>&#xE872;</i></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<%--<!-- Add Modal HTML -->--%>
<%--<div id="addEmployeeModal" class="modal fade">--%>
<%--    <div class="modal-dialog">--%>
<%--        <div class="modal-content">--%>
<%--            <form method="post" action="product?action=create" class="needs-validation" novalidate>--%>
<%--                <div class="modal-header">--%>
<%--                    <h4 class="modal-title">Add Product</h4>--%>
<%--                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>--%>
<%--                </div>--%>
<%--                <div class="modal-body">--%>
<%--                    <div class="form-group">--%>
<%--                        <label>Name</label>--%>
<%--                        &lt;%&ndash;                        [A-Za-z0-9]+([A-Za-z0-9]+)*&ndash;%&gt;--%>
<%--                        <input type="text" class="form-control" name="name" required pattern="^\w+( \w+)*$">--%>
<%--                        <div class="valid-feedback">Valid</div>--%>
<%--                        <div class="invalid-feedback">Name cannot have any extra spaces or no characters</div>--%>
<%--                        &lt;%&ndash;                        <small class="error">hihi</small>&ndash;%&gt;--%>
<%--                    </div>--%>
<%--                    <div class="form-group">--%>
<%--                        <label>Price</label>--%>
<%--                        <input type="text" class="form-control" name="price" required pattern="^\d+\.\d+$">--%>
<%--                        <div class="valid-feedback">Valid</div>--%>
<%--                        <div class="invalid-feedback">Price must be greater than 0</div>--%>
<%--                    </div>--%>
<%--                    <div class="form-group">--%>
<%--                        <label>Quantity</label>--%>
<%--                        <input type="text" class="form-control" name="quantity" required pattern="^\d+$">--%>
<%--                        <div class="valid-feedback">Valid</div>--%>
<%--                        <div class="invalid-feedback">Quantity must be greater than 0</div>--%>
<%--                    </div>--%>
<%--                    <div class="form-group">--%>
<%--                        <label>Color</label>--%>
<%--                        <input type="text" class="form-control" name="color" required pattern="^\w+( \w+)*$">--%>
<%--                        <div class="valid-feedback">Valid</div>--%>
<%--                        <div class="invalid-feedback">Color cannot have any extra spaces or no characters</div>--%>
<%--                    </div>--%>
<%--                    <div class="form-group">--%>
<%--                        <label>Category Name</label>--%>
<%--                        <select name="category_id">--%>
<%--                            <c:forEach items="${categoryList}" var="category">--%>
<%--                                <option value="${category.getId()}">${category.getName()}</option>--%>
<%--                            </c:forEach>--%>
<%--                        </select>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="modal-footer">--%>
<%--                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">--%>
<%--                    <input type="submit" class="btn btn-success" value="Add">--%>
<%--                </div>--%>
<%--            </form>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

<%--<!-- Edit Modal HTML -->--%>
<%--<div id="editEmployeeModal" class="modal fade">--%>
<%--    <div class="modal-dialog">--%>
<%--        <div class="modal-content">--%>
<%--            <form method="post" action="product?action=edit">--%>
<%--                <input type="hidden" name="id_modal_edit" id="isEdit">--%>
<%--                <div class="modal-header">--%>
<%--                    <h4 class="modal-title">Edit Employee</h4>--%>
<%--                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>--%>
<%--                </div>--%>
<%--                <div class="modal-body">--%>
<%--                    <div class="form-group">--%>
<%--                        <label>Name</label>--%>
<%--                        <input type="text" class="form-control" name="name" required id="nameEdit" pattern="^\w+( \w+)*$">--%>
<%--                        <div class="valid-feedback">Valid</div>--%>
<%--                        <div class="invalid-feedback">Name cannot have any extra spaces or no characters</div>--%>
<%--                    </div>--%>
<%--                    <div class="form-group">--%>
<%--                        <label>Price</label>--%>
<%--                        <input type="text" class="form-control" name="price" required id="priceEdit" pattern="^\d+\.\d+$">--%>
<%--                        <div class="valid-feedback">Valid</div>--%>
<%--                        <div class="invalid-feedback">Price must be greater than 0</div>--%>
<%--                    </div>--%>
<%--                    <div class="form-group">--%>
<%--                        <label>Quantity</label>--%>
<%--                        <input type="text" class="form-control" name="quantity" required id="quantityEdit" pattern="^\d+$">--%>
<%--                        <div class="valid-feedback">Valid</div>--%>
<%--                        <div class="invalid-feedback">Quantity must be greater than 0</div>--%>
<%--                    </div>--%>
<%--                    <div class="form-group">--%>
<%--                        <label>Color</label>--%>
<%--                        <input type="text" class="form-control" name="color" required id="colorEdit" pattern="^\w+( \w+)*$">--%>
<%--                        <div class="valid-feedback">Valid</div>--%>
<%--                        <div class="invalid-feedback">Color cannot have any extra spaces or no characters</div>--%>
<%--                    </div>--%>
<%--                    <div class="form-group">--%>
<%--                        <label>Category Name</label>--%>
<%--                        <select name="category_id" id="categoryNameEdit">--%>
<%--                            <c:forEach items="${categoryList}" var="category">--%>
<%--                                <option value="${category.getId()}" selected>${category.getName()}</option>--%>
<%--                            </c:forEach>--%>
<%--                        </select>--%>
<%--                        &lt;%&ndash;                        <input type="text" class="form-control" name="category_name" required>&ndash;%&gt;--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="modal-footer">--%>
<%--                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">--%>
<%--                    <input type="submit" class="btn btn-info" value="Save">--%>
<%--                </div>--%>
<%--            </form>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

<!-- Delete Modal HTML -->
<div id="deleteEmployeeModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form method="post" action="product?action=delete">
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

    function sendProductInfor(id, name, price, quantity, color, category_id) {
        document.getElementById('isEdit').value = id;
        document.getElementById('nameEdit').value = name;
        document.getElementById('priceEdit').value = price;
        document.getElementById('quantityEdit').value = quantity;
        document.getElementById('colorEdit').value = color;
        // document.getElementById('categooryNameEdit').value = category_name;
        document.getElementById('categoryNameEdit').value = category_id;
    }

    function sendProductId(id) {
        document.getElementById('isDelete').value = id;
    }

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

    // Phan trang
    $.extend( true, $.fn.dataTable.defaults, {
        "searching": false,
        "ordering": false
    } );
    $(document).ready(function() {
        $('#example').DataTable({
            "lengthMenu": [[5, 10, 15, -1], [5, 10, 15, "All"]]
        });
    } );
</script>
</html>

