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

import com.c4.ud26.dto.Pieza;
import com.c4.ud26.service.PiezaServiceImpl;

@RestController
@RequestMapping("/api")
public class PiezaController {

	@Autowired
	PiezaServiceImpl piezaServiceImpl;
	
	@GetMapping("/piezas")
	public List<Pieza> listarPiezas(){
		return piezaServiceImpl.listarPiezas();
	}
	
	@PostMapping("/piezas")
	public Pieza guardarPieza(@RequestBody Pieza pieza) {
		return piezaServiceImpl.guardarPieza(pieza);
	}
	
	@GetMapping("/piezas/{id}")
	public Pieza piezaXID(@PathVariable(name="id") Long id) {
		return piezaServiceImpl.piezaXID(id);
	}
	
	@PutMapping("/piezas/{id}")
	public Pieza actualizarPieza(@PathVariable(name="id") Long id, @RequestBody Pieza pieza) {
		Pieza piezaSel= new Pieza();
		Pieza piezaAct= new Pieza();
		
		piezaSel=piezaServiceImpl.piezaXID(id);
		
		piezaSel.setNombre(pieza.getNombre());
		
		piezaAct= piezaServiceImpl.actulizarPieza(piezaSel);
		
		return piezaAct;
		
	}
	
	@DeleteMapping("/piezas/{id}")
	public String eliminarPieza(@PathVariable(name="id") Long id) {
		try {
			piezaServiceImpl.eliminarPieza(id);
			return "Pieza eliminada";
		}catch (Exception e) {
			return "Error: no puedes borrar esta pieza ya que hay pedidos con esta.";
		}
		
	}
}
