package com.evaluacion8.procesaConexion;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class AdministradorConexion {
private AdministradorConexion() {}

	private static final BasicDataSource dataSource = new BasicDataSource();

	static {
		String user = "postgres";
		String password = "mtg.2029";
		String url = "jdbc:postgresql://localhost:5432/universidad";

		dataSource.setUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword(password);
		dataSource.setDriverClassName("org.postgresql.Driver");

		//Configurar Pool
		dataSource.setInitialSize(5); // define coexiones iniciales.
    	dataSource.setMaxTotal(20); //maximo de conexiones
    	dataSource.setMaxIdle(10); //maximo de conexiones en espera
    	dataSource.setMinIdle(5); // minio de conex en espera
	}

	public static DataSource getDataSource() {
		return dataSource;
	}
}
