package model;

import java.io.Serializable;

public class Producto implements Serializable{

	private int codigo, grupo, otros, stockActual, stockMinimo, stockMaximo;
	private float pvp;
	private String nombre, proveedor, comentarios;

	public Producto(int codigo, int grupo, int otros, int stockActual, int stockMinimo, int stockMaximo, String proveedor,
			float pvp, String nombre, String comentarios) {
		super();
		this.codigo = codigo;
		this.grupo = grupo;
		this.otros = otros;
		this.stockActual = stockActual;
		this.stockMinimo = stockMinimo;
		this.stockMaximo = stockMaximo;
		this.proveedor = proveedor;
		this.pvp = pvp;
		this.nombre = nombre;
		this.comentarios = comentarios;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getGrupo() {
		return grupo;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public void setGrupo(int grupo) {
		this.grupo = grupo;
	}

	public int getOtros() {
		return otros;
	}

	public void setOtros(int otros) {
		this.otros = otros;
	}

	public int getStockActual() {
		return stockActual;
	}

	public void setStockActual(int stockActual) {
		this.stockActual = stockActual;
	}

	public int getStockMinimo() {
		return stockMinimo;
	}

	public void setStockMinimo(int stockMinimo) {
		this.stockMinimo = stockMinimo;
	}

	public int getStockMaximo() {
		return stockMaximo;
	}

	public void setStockMaximo(int stockMaximo) {
		this.stockMaximo = stockMaximo;
	}


	public float getPvp() {
		return pvp;
	}

	public void setPvp(float pvp) {
		this.pvp = pvp;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", grupo=" + grupo + ", otros=" + otros + ", stockActual=" + stockActual
				+ ", stockMinimo=" + stockMinimo + ", stockMaximo=" + stockMaximo + ", proveedor=" + proveedor
				+ ", pvp=" + pvp + ", nombre=" + nombre + ", comentarios=" + comentarios + "]";
	}
	
	

}
