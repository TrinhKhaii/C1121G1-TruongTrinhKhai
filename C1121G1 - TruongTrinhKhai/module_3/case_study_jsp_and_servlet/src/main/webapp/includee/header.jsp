<%--
  Created by IntelliJ IDEA.
  User: truongtrinhkhai
  Date: 18/03/2022
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<header class="container-fluid row">
    <div class="col-5 m-4 float-left">
        <img src="../img/ava.png" alt="thay-linh-dep-trai" style="width: 80px; border-radius: 10%">
    </div>
    <div class="col-5 m-4 float-right d-flex align-items-center ml-5">
        <p>C1121G1 - Trương Trịnh Khải</p>
    </div>
    <%--  nav bar  --%>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">FURAMA RESORT</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="../index.jsp">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="employee">Employee</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="customer">Customer</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="facility">Service</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false">Contract</a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="contract">Contract</a></li>
                            <li><a class="dropdown-item" href="contract-detail">Contract detail</a></li>
                        </ul>
                    </li>
                </ul>
                <form class="d-flex">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>
        </div>
    </nav>
</header>
