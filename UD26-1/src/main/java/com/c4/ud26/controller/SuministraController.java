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

import com.c4.ud26.dto.Suministra;
import com.c4.ud26.service.SuministraServiceImpl;

@RestController
@RequestMapping("/api")
public class SuministraController {
	
	@Autowired 
	SuministraServiceImpl suministraServiceImpl;
	
	@GetMapping("/suministros")
	public List<Suministra> listarSuministros(){
		return suministraServiceImpl.listarSuministros();
	}
	
	@PostMapping("/suministros")
	public Suministra guardarSuministro(@RequestBody Suministra suministra) {
		return suministraServiceImpl.guardarSuministro(suministra);
	}
	
	@GetMapping("/suministros/{id}")
	public Suministra suministraXID(@PathVariable(name="id") Long id) {
		
		Suministra suministra = new Suministra();
		
		suministra=suministraServiceImpl.suministroXID(id);
		
		return suministra;
	}

	@PutMapping("/suministros/{id}")
	public Suministra actualizarSuministra(@PathVariable(name="id") Long id, @RequestBody Suministra suministra) {
		
		Suministra suministraSel = new Suministra();
		Suministra suministraAct = new Suministra();
		
		suministraSel=suministraServiceImpl.suministroXID(id);
		
		suministraSel.setPieza(suministra.getPieza());
		suministraSel.setProveedor(suministra.getProveedor());
		suministraSel.setPrecio(suministra.getPrecio());
		
		suministraAct = suministraServiceImpl.actualitzarSuministro(suministraSel);
		
		return suministraAct;		
	}
	
	@DeleteMapping("/suministros/{id}")
	public void eliminsarSuministro(@PathVariable(name="id") Long id) {
		suministraServiceImpl.eliminarSuministro(id);
	}
}
