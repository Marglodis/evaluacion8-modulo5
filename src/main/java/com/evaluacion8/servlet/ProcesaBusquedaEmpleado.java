package com.evaluacion8.servlet;

import java.io.IOException;
import java.util.List;

import com.evaluacion8.dao.EmpleadoDaoImpl;
import com.evaluacion8.modelo.Empleado;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProcesaBusquedaEmpleado
 */
@WebServlet("/ProcesaBusquedaEmpleado")
public class ProcesaBusquedaEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcesaBusquedaEmpleado() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String numEmpleadoStr = request.getParameter("numEmpleado");
        String numDepartamentoStr = request.getParameter("numeroDepto");

        // Valores por defecto para los filtros
        String defaultNombre = "";
        int defaultNumEmpleado = 0;
        int defaultNumDepartamento = 0;

        // Validar si los parámetros están presentes
        String nombreFiltro = (nombre != null) ? nombre : defaultNombre;
        int numEmpleado = (numEmpleadoStr != null && !numEmpleadoStr.isEmpty()) ? Integer.parseInt(numEmpleadoStr) : defaultNumEmpleado;
        int numDepartamento = (numDepartamentoStr != null && !numDepartamentoStr.isEmpty()) ? Integer.parseInt(numDepartamentoStr) : defaultNumDepartamento;

        // Obtener la lista de empleados desde la base de datos
        EmpleadoDaoImpl busqueda = new EmpleadoDaoImpl();
        List<Empleado> listaEmpleados = busqueda.obtieneEmpleado(nombreFiltro, numEmpleado, numDepartamento);

        // Enviar la lista al JSP
        request.setAttribute("empleadoDao", listaEmpleados);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
