package com.evaluacion8.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.evaluacion8.modelo.Empleado;
import com.evaluacion8.procesaConexion.AdministradorConexion;

public class EmpleadoDaoImpl implements EmpleadoDao{
	private Connection conn;

	public EmpleadoDaoImpl() {
		try {
			this.conn = AdministradorConexion.getDataSource().getConnection();
		}catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error al obtener la conexion", e);
		}

	}

	@Override
	public List<Empleado> obtieneEmpleado(String nombre, int numEmpleado, int numDepartamento) {
		String query = "SELECT * FROM  EMPLEADO WHERE ";
		List<Empleado> empleados = new ArrayList<>();
		 if ((nombre.isEmpty()) && (numEmpleado == 0 && numDepartamento == 0))
		 {
		    query = "SELECT * FROM EMPLEADO ";
		   }
		 else
		 {
		      if ((!nombre.isEmpty() && (numEmpleado > 0) && (numDepartamento > 0)))
		      {
		         query.concat("NOMBRE = '"+nombre+"'"+ "AND" + "NUMEMPLEADO = " +numEmpleado+ " AND " + " NUMDEPTO = " +numDepartamento);
				 query += "NOMBRE = '"+nombre+"'";
				 query += " AND ";
				 query += "NUMEMPLEADO = "+numEmpleado;
				 query += " AND ";
				 query += "NUMDEPTO = "+numDepartamento;
		       }else if (!nombre.isEmpty()) {
		 // query += "NOMBRE = '"+nombre+"'";
		         query += "UPPER (NOMBRE) LIKE UPPER('%"+nombre+"%')";
		 // SELECT * FROM EMPLEADO WHERE UPPER(NOMBRE) LIKE UPPER ('%bob%');
		     }else if (numEmpleado > 0) {
		       query += "NUMEMPLEADO = "+numEmpleado;
		    }else if (numDepartamento > 0) {
		       query += "NUMDEPTO = "+numDepartamento;
		     }
		  }
		try {
			PreparedStatement pstm = conn.prepareStatement(query);
			ResultSet rs = pstm.executeQuery();

			while(rs.next()) {
				 Empleado empleado = new Empleado (rs.getInt("NUMEMPLEADO"),
					      rs.getString("NOMBRE"),
					rs.getInt("NUMDEPTO"));
				empleados.add(empleado);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		return empleados;
	}



}
