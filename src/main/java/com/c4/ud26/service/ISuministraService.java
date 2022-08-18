package com.c4.ud26.service;

import java.util.List;

import com.c4.ud26.dto.Suministra;

public interface ISuministraService {

	public List<Suministra> listarSuministros();
	
	public Suministra guardarSuministro(Suministra suministra);
	
	public Suministra suministroXID (Long id);
	
	public Suministra actualitzarSuministro(Suministra suministra);
	
	public void eliminarSuministro(Long id);
}
