package com.evaluacion8.servlet;

import java.io.IOException;
import java.util.List;

import com.evaluacion8.dao.DepartamentoDaoImpl;
import com.evaluacion8.modelo.Departamento;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProcesaDepartamento
 */
@WebServlet("/ProcesaBusquedaDepartamento")
public class ProcesaBusquedaDepartamento extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcesaBusquedaDepartamento() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String numDeptoStr = request.getParameter("numDepto");
        String ubicacionDeptoStr = request.getParameter("ubicacionDepto");

        // Valores por defecto para los filtros
        String defaultNombre = "";
        int defaultNumDepto = 0;
        String defaultUbicacionDepto = "";

        // Validar si los parámetros están presentes
        String nombreFiltro = (nombre != null) ? nombre : defaultNombre;
        int numDepto = (numDeptoStr != null && !numDeptoStr.isEmpty()) ? Integer.parseInt(numDeptoStr) : defaultNumDepto;
        String ubicacionDepto = (ubicacionDeptoStr != null && !ubicacionDeptoStr.isEmpty()) ? ubicacionDeptoStr : defaultUbicacionDepto;

        // Obtener la lista de empleados desde la base de datos
        DepartamentoDaoImpl busqueda = new DepartamentoDaoImpl();
        List<Departamento> listaDepartamentos = busqueda.obtieneDepartamento(nombreFiltro, numDepto, ubicacionDepto);

        // Enviar la lista al JSP
        request.setAttribute("departamentoDao", listaDepartamentos);
        request.getRequestDispatcher("departamento.jsp").forward(request, response);
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
