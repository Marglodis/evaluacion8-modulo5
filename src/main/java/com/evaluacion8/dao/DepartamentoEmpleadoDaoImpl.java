package com.evaluacion8.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.evaluacion8.modelo.Departamento;
import com.evaluacion8.modelo.DepartamentoEmpleado;
import com.evaluacion8.modelo.Empleado;
import com.evaluacion8.procesaConexion.AdministradorConexion;

public class DepartamentoEmpleadoDaoImpl implements DepartamentoEmpleadoDao{

	private Connection conn;

	public DepartamentoEmpleadoDaoImpl() {
		try {
			this.conn = AdministradorConexion.getDataSource().getConnection();
		}catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error al obtener la conexion", e);
		}

	}

	@Override
	public List<DepartamentoEmpleado> obtieneDepartamento(String nomDepto) {

		List<DepartamentoEmpleado> deptosEmpleados = new ArrayList<>();

		 // Consulta base
	    String query = "SELECT EMP.NUMEMPLEADO, EMP.NOMBRE, EMP.NUMDEPTO, "
	                 + "DEP.NUMDEPTO, DEP.NOMDEPTO, DEP.UBICACIONDPTO "
	                 + "FROM EMPLEADO EMP "
	                 + "INNER JOIN DEPARTAMENTO DEP ON DEP.NUMDEPTO = EMP.NUMDEPTO";

	    // Verificar si hay un filtro por departamento
	    boolean tieneFiltro = nomDepto != null && !nomDepto.trim().isEmpty();
	    if (tieneFiltro) {
	        query += " WHERE DEP.NOMDEPTO ILIKE ?";
	    }

		try(PreparedStatement pstm = conn.prepareStatement(query)) {

			 // Agregar el parámetro si existe filtro
	        if (tieneFiltro) {
	            pstm.setString(1, "%" + nomDepto.trim() + "%");
	        }

			try(ResultSet rs = pstm.executeQuery()){
				while(rs.next()) {
					Departamento depto = new Departamento(rs.getInt("NUMDEPTO"),rs.getString("NOMDEPTO"),rs.getString("UBICACIONDPTO"));
					Empleado empleado = new Empleado(rs.getInt("NUMEMPLEADO"),rs.getString("NOMBRE"),rs.getInt("NUMDEPTO"));
					DepartamentoEmpleado deptoEmpl = new DepartamentoEmpleado(depto,empleado);
					deptosEmpleados.add(deptoEmpl);
				}
			}


		} catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error al obtener departamentos y empleados",e);
		}
		return deptosEmpleados;
	}



}
