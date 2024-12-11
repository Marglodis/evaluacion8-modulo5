package com.evaluacion8.modelo;

public class Empleado {
	private int numEmpleado;
	private String nombreEmpleado;
	private int numDepto;
	public Empleado() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Empleado(int numEmpleado, String nombreEmpleado, int numDepto) {
		super();
		this.numEmpleado = numEmpleado;
		this.nombreEmpleado = nombreEmpleado;
		this.numDepto = numDepto;
	}
	public int getNumEmpleado() {
		return numEmpleado;
	}
	public void setNumEmpleado(int numEmpleado) {
		this.numEmpleado = numEmpleado;
	}
	public String getNombreEmpleado() {
		return nombreEmpleado;
	}
	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}
	public int getNumDepto() {
		return numDepto;
	}
	public void setNumDepto(int numDepto) {
		this.numDepto = numDepto;
	}
}
