package com.evaluacion8.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.evaluacion8.procesaConexion.AdministradorConexion;

public class LoginDaoImpl implements LoginDao {
	private Connection conn;

	public LoginDaoImpl() {
		try {
			this.conn = AdministradorConexion.getDataSource().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error al obtener la conexion", e);
		}

	}

	@Override
	public boolean usuarioRegistrado(String correo, String password) {
		boolean usuarioExiste = false;
		String sql = "SELECT * FROM USUARIOS_ADMIN WHERE CORREO = '" + correo + "'" + "AND PASSWORD = '" + password + "'";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				usuarioExiste = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarioExiste;
	}
}