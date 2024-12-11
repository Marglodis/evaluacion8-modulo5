package com.evaluacion8.servlet;

import java.io.IOException;

import com.evaluacion8.dao.LoginDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ProcesaLogin
 */
@WebServlet("/ProcesaLogin")
public class ProcesaLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProcesaLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean usuarioExiste = false;
		String correo = request.getParameter("email");
		String password = request.getParameter("password");
		LoginDaoImpl loginDao = new LoginDaoImpl();
		usuarioExiste = loginDao.usuarioRegistrado(correo, password);
		request.setAttribute("usuarioExiste", usuarioExiste);
		if (usuarioExiste) {
			HttpSession sesionUsuario = request.getSession(true);
			sesionUsuario.setAttribute("correo", correo);
			request.setAttribute("correo", correo);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
