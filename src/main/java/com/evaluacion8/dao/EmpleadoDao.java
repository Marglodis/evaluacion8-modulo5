package com.evaluacion8.dao;

import java.util.List;

import com.evaluacion8.modelo.Empleado;

public interface EmpleadoDao {
	public List<Empleado> obtieneEmpleado(String nombre, int numEmpleado,int numDepartamento);
}
