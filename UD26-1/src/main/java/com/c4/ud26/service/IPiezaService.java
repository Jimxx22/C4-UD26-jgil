package com.c4.ud26.service;

import java.util.List;

import com.c4.ud26.dto.Pieza;

public interface IPiezaService {

	public List<Pieza> listarPiezas();
	
	public Pieza guardarPieza(Pieza pieza);
	
	public Pieza piezaXID(Long id);
	
	public Pieza actulizarPieza(Pieza pieza);
	
	public void eliminarPieza(Long id);
}
