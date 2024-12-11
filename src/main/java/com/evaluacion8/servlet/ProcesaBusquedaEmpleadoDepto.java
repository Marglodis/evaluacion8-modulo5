package com.evaluacion8.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.evaluacion8.dao.DepartamentoEmpleadoDaoImpl;
import com.evaluacion8.modelo.DepartamentoEmpleado;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProcesaBusquedaEmpleadoDepto
 */
@WebServlet("/ProcesaBusquedaEmpleadoDepto")
public class ProcesaBusquedaEmpleadoDepto extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcesaBusquedaEmpleadoDepto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nomDepartamento = request.getParameter("nomDepto");
		List<DepartamentoEmpleado> deptosEmpleadosList = new ArrayList<>();

		DepartamentoEmpleadoDaoImpl obtieneDeptoEmpleado = new DepartamentoEmpleadoDaoImpl();

		deptosEmpleadosList = obtieneDeptoEmpleado.obtieneDepartamento(nomDepartamento);

		request.setAttribute("departamentoEmpleado", deptosEmpleadosList);

		request.getRequestDispatcher("ListaUnoMuchos.jsp").forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Redirigir la lógica de GET al método POST
	    doPost(request, response);
	}

}
