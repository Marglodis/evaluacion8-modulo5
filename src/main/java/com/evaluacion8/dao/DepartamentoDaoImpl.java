package com.evaluacion8.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.evaluacion8.modelo.Departamento;
import com.evaluacion8.procesaConexion.AdministradorConexion;

public class DepartamentoDaoImpl implements DepartamentoDao {
	private Connection conn;

	public DepartamentoDaoImpl() {
		try {
			this.conn = AdministradorConexion.getDataSource().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error al obtener la conexion", e);
		}

	}

	@Override
	public List<Departamento> obtieneDepartamento(String nomDepto, int numDepto, String ubicacionDepto) {
	    StringBuilder sql = new StringBuilder("SELECT * FROM DEPARTAMENTO WHERE 1=1");
	    List<Departamento> deptos = new ArrayList<>();

	    // Lista para almacenar los parámetros de la consulta
	    List<Object> parametros = new ArrayList<>();

	    // Condicionales para agregar filtros según los valores recibidos
	    if (nomDepto != null && !nomDepto.isEmpty()) {
	        sql.append(" AND LOWER(nomdepto) LIKE LOWER(?)");
	        parametros.add("%" + nomDepto + "%");
	    }
	    if (numDepto > 0) {
	        sql.append(" AND numdepto = ?");
	        parametros.add(numDepto);
	    }
	    if (ubicacionDepto != null && !ubicacionDepto.isEmpty()) {
	        sql.append(" AND LOWER(ubicaciondpto) LIKE LOWER(?)");
	        parametros.add("%" + ubicacionDepto + "%");
	    }

	    sql.append(" ORDER BY NUMDEPTO ASC");

	    try (PreparedStatement pstm = conn.prepareStatement(sql.toString())) {
	        // Establecer los parámetros dinámicamente
	        for (int i = 0; i < parametros.size(); i++) {
	            pstm.setObject(i + 1, parametros.get(i)); // Los índices en PreparedStatement comienzan desde 1
	        }

	        try (ResultSet rs = pstm.executeQuery()) {
	            while (rs.next()) {
	                Departamento depto = new Departamento(
	                    rs.getInt("numdepto"),
	                    rs.getString("nomdepto"),
	                    rs.getString("ubicaciondpto")
	                );
	                deptos.add(depto);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return deptos;
	}


}
