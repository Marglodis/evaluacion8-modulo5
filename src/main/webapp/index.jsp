<%@ page import="java.util.List"%>
<%@ page import="com.evaluacion8.modelo.Empleado"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Evaluación 8 - Filtros</title>

<!-- Custom fonts for this template-->
<link href="assets/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="assets/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">
	<%
	String correo = "no existe usuario";
	HttpSession misesion = request.getSession();
	if (misesion != null) {
		correo = (String) misesion.getAttribute("correo");
	} else {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	%>
	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<ul
			class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
			id="accordionSidebar">

			<!-- Sidebar - Brand -->
			<a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.jsp">
				<div class="sidebar-brand-icon rotate-n-15">
					<i class="fas fa-laugh-wink"></i>
				</div>
				<div class="sidebar-brand-text mx-3">
					Evaluación <sup>8</sup>
				</div>
			</a>
			
			<!-- Nav Item - Dashboard -->
			<li class="nav-item active"><a class="nav-link" href="departamento.jsp">
					<i class="fas fa-fw fa-tachometer-alt"></i> <span>Departamentos</span>
			</a></li>
			<li class="nav-item active"><a class="nav-link" href="index.jsp">
					<i class="fas fa-fw fa-tachometer-alt"></i> <span>Empleados</span>
			</a></li>


		</ul>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

					<!-- Sidebar Toggle (Topbar) -->
					<button id="sidebarToggleTop"
						class="btn btn-link d-md-none rounded-circle mr-3">
						<i class="fa fa-bars"></i>
					</button>

				
					<!-- Topbar Navbar -->
					<ul class="navbar-nav ml-auto">

						<div class="topbar-divider d-none d-sm-block"></div>

						<!-- Nav Item - User Information -->
						<li class="nav-item dropdown no-arrow"><a
							class="nav-link dropdown-toggle" href="#" id="userDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <span
								class="mr-2 d-none d-lg-inline text-gray-600 small"><%=correo%>></span>
								<img class="img-profile rounded-circle"
								src="assets/img/undraw_profile.svg" alt="">
						</a> <!-- Dropdown - User Information -->
							<div
								class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
								aria-labelledby="userDropdown">
								<a class="dropdown-item" href="#"> <i
									class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i> Profile
								</a> <a class="dropdown-item" href="#"> <i
									class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
									Settings
								</a> <a class="dropdown-item" href="#"> <i
									class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
									Activity Log
								</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="#" data-toggle="modal"
									data-target="#logoutModal"> <i
									class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
									Logout
								</a>
							</div></li>

					</ul>

				</nav>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<div
						class="d-sm-flex align-items-center justify-content-between mb-4">
						<h1 class="h3 mb-0 text-gray-800">Consulta Empleado</h1>
						<a href="#"
							class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
							class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>
					</div>
					<form action="ProcesaBusquedaEmpleado" method="get">
						<!-- Content Row -->
						<div class="row">

							<!-- NOMBRE EMPLEADO -->
							<div class="col-xl-4 col-md-6 mb-4">
								<div class="card border-left-primary shadow h-100 py-2">
									<div class="card-body">
										<div class="row no-gutters align-items-center">
											<div class="col mr-2">
												<div
													class="text-xs font-weight-bold text-primary text-uppercase mb-1">
													Nombre Empleado</div>

												<div class="h5 mb-0 font-weight-bold text-gray-800">
													<input type="text" class="form-control" id="nombre"
														name="nombre">
												</div>
											</div>
											<div class="col-auto">
												<i class="fas fa-calendar fa-2x text-gray-300"></i>
											</div>
										</div>
									</div>
								</div>
							</div>

							<!-- NUMERO DE EMPLEADO -->
							<div class="col-xl-4 col-md-6 mb-4">
								<div class="card border-left-success shadow h-100 py-2">
									<div class="card-body">
										<div class="row no-gutters align-items-center">
											<div class="col mr-2">
												<div
													class="text-xs font-weight-bold text-success text-uppercase mb-1">
													N° Empleado</div>
												<div class="h5 mb-0 font-weight-bold text-gray-800">
													<input type="text" class="form-control" id="numeroEmpleado"
														name="numEmpleado">
												</div>
											</div>
											<div class="col-auto">
												<i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
											</div>
										</div>
									</div>
								</div>
							</div>

							<!-- NUMERO DEPARTAMENTO -->
							<div class="col-xl-4 col-md-6 mb-4">
								<div class="card border-left-info shadow h-100 py-2">
									<div class="card-body">
										<div class="row no-gutters align-items-center">
											<div class="col mr-2">
												<div
													class="text-xs font-weight-bold text-info text-uppercase mb-1">N°
													Departamento</div>
												<div class="row no-gutters align-items-center">
													<div class="col-auto">
														<div class="h5 mb-0 mr-3 font-weight-bold text-gray-800">
															<input type="text" class="form-control" id="numDepto"
																name="numeroDepto">
														</div>
													</div>
													
												</div>
											</div>
											<div class="col-auto">
												<i class="fas fa-clipboard-list fa-2x text-gray-300"></i>
											</div>
										</div>
									</div>
								</div>
							</div>


						</div>

						<div class="row">

							<div class="col-lg-6">
								<button type="submit" class="btn btn-primary btn-lg w-100">BUSCAR</button>

							</div>
							<div class="col-lg-6">
								<a href="index.jsp" class="btn btn-secondary btn-lg w-100">LIMPIAR</a>
							</div>
						</div>


					</form>
					<div class="row">
						<!-- Area Chart -->
						<div class="col-xl-8 col-lg-7">
							<div class="card shadow mb-4">
							</div>
						</div>
					</div>
					<!-- Content Row -->
					<div class="row">
						<div class="container-fluid">
							<!-- DataTales Example -->
							<div class="card shadow mb-4">
								<div class="card-header py-3">
									<h6 class="m-0 font-weight-bold text-primary">DataTables
										Example</h6>
								</div>
								<div class="card-body">
									<div class="table-responsive">
										<table class="table table-bordered" id="dataTable">
											<thead>
												<tr>
													<th>Nombre</th>
													<th>ID Empleado</th>
													<th>Departamento</th>
												</tr>
											</thead>
											
											<tbody>
											
												<%
												  if (request.getAttribute("empleadoDao") == null) {
												        response.sendRedirect("ProcesaBusquedaEmpleado");
												    }
												List<Empleado> empleados = (List<Empleado>) request.getAttribute("empleadoDao");
												if (empleados != null && !empleados.isEmpty()) {
													for (Empleado empleado : empleados) {
												%>
												<tr>
													<td><%=empleado.getNombreEmpleado()%></td>
													<td><%=empleado.getNumEmpleado()%></td>
													<td><%=empleado.getNumDepto()%></td>
												</tr>
												<%
												}
												} else {
												%>
												<tr>
													<td colspan="3">No hay empleados registrados.</td>
												</tr>
												<%
												}
												%>
											</tbody>

										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- Footer -->
				<footer class="sticky-footer bg-white">
					<div class="container my-auto">
						<div class="copyright text-center my-auto">
							<span>Copyright &copy; Your Website 2021</span>
						</div>
					</div>
				</footer>
				<!-- End of Footer -->

			</div>
			<!-- End of Content Wrapper -->

		</div>
		<!-- End of Page Wrapper -->

		<!-- Scroll to Top Button-->
		<a class="scroll-to-top rounded" href="#page-top"> <i
			class="fas fa-angle-up"></i>
		</a>

		<!-- Logout Modal-->
		<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Ready to
							Leave?</h5>
						<button class="close" type="button" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">Ã—</span>
						</button>
					</div>
					<div class="modal-body">Select "Logout" below if you are
						ready to end your current session.</div>
					<div class="modal-footer">
						<button class="btn btn-secondary" type="button"
							data-dismiss="modal">Cancel</button>
						<a class="btn btn-primary" href="login.jsp">Logout</a>
					</div>
				</div>
			</div>
		</div>

		<!-- Bootstrap core JavaScript-->
		<script src="assets/vendor/jquery/jquery.min.js"
			type="text/javascript"></script>
		<script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"
			type="text/javascript"></script>

		<!-- Core plugin JavaScript-->
		<script src="assets/vendor/jquery-easing/jquery.easing.min.js"
			type="text/javascript"></script>

		<!-- Custom scripts for all pages-->
		<script src="assets/js/sb-admin-2.min.js" type="text/javascript"></script>

		<!-- Page level plugins -->
		<script src="assets/vendor/chart.js/Chart.min.js"
			type="text/javascript"></script>

		<!-- Page level custom scripts -->
		<script src="assets/js/demo/chart-area-demo.js" type="text/javascript"></script>
		<script src="assets/js/demo/chart-pie-demo.js" type="text/javascript"></script>
	</div>
</body>

</html>