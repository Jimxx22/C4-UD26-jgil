package com.c4.ud26.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c4.ud26.dao.IProveedorDAO;
import com.c4.ud26.dto.Proveedor;

@Service
public class ProveedorServiceImpl implements IProveedorServeice{
	
	@Autowired
	IProveedorDAO iProveedorDAO;

	@Override
	public List<Proveedor> listarProveedores() {
		// TODO Auto-generated method stub
		return iProveedorDAO.findAll();
	}

	@Override
	public Proveedor guardarProveedor(Proveedor proveedor) {
		// TODO Auto-generated method stub
		return iProveedorDAO.save(proveedor);
	}

	@Override
	public Proveedor proveedorXID(String id) {
		// TODO Auto-generated method stub
		return iProveedorDAO.findById(id).get();
	}

	@Override
	public Proveedor actualizarProveedor(Proveedor proveedor) {
		// TODO Auto-generated method stub
		return iProveedorDAO.save(proveedor);
	}

	@Override
	public void eliminarProveedor(String id) {
		// TODO Auto-generated method stub
		iProveedorDAO.deleteById(id);
	}

}
