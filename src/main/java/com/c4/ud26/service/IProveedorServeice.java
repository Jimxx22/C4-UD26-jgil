package com.c4.ud26.service;

import java.util.List;

import com.c4.ud26.dto.Proveedor;

public interface IProveedorServeice {
	
	public List<Proveedor> listarProveedores();
	
	public Proveedor guardarProveedor(Proveedor proveedor);
	
	public Proveedor proveedorXID(String id);
	
	public Proveedor actualizarProveedor(Proveedor proveedor);
	
	public void eliminarProveedor(String id);

}
