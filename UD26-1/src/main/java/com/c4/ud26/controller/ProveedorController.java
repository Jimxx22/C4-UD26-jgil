package com.c4.ud26.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.c4.ud26.dto.Proveedor;
import com.c4.ud26.service.ProveedorServiceImpl;

@RestController
@RequestMapping("/api")
public class ProveedorController {

	@Autowired 
	ProveedorServiceImpl proveedorServiceImpl;
	
	@GetMapping("/proveedores")
	public List<Proveedor> listarProveedores(){
		return proveedorServiceImpl.listarProveedores();
	}
	
	@PostMapping("/proveedores")
	public Proveedor guardarProveedor(@RequestBody Proveedor proveedor) {
		return proveedorServiceImpl.guardarProveedor(proveedor);
	}
	
	@GetMapping("/proveedores/{id}")
	public Proveedor proveedorXID(@PathVariable(name="id") String id) {
		
		Proveedor proveedorXID = new Proveedor();
		
		proveedorXID=proveedorServiceImpl.proveedorXID(id);
		
		return proveedorXID;
	}
	
	@PutMapping("/proveedores/{id}")
	public Proveedor actualizarProveedor(@PathVariable(name="id") String id, @RequestBody Proveedor proveedor) {
		
		Proveedor proveedorSel = new Proveedor();
		Proveedor proveedorAct = new Proveedor();
		
		proveedorSel=proveedorServiceImpl.proveedorXID(id);
		
		proveedorSel.setNombre(proveedor.getNombre());
		
		proveedorAct=proveedorServiceImpl.actualizarProveedor(proveedorSel);
		
		return proveedorAct;
	}
	
	@DeleteMapping("/proveedores/{id}")
	public String eliminarProveedor(@PathVariable(name="id") String id) {
		try {
			proveedorServiceImpl.eliminarProveedor(id);
			return "Proveedor eliminado";
		}catch (Exception e) {
			return "Error: no puedes borrar este proveedor ya que hay pedidos con este";
		}
	}
}
