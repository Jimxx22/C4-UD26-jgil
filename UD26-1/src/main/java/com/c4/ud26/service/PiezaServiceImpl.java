package com.c4.ud26.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c4.ud26.dao.IPiezaDAO;
import com.c4.ud26.dto.Pieza;

@Service
public class PiezaServiceImpl implements IPiezaService{
	
	@Autowired
	IPiezaDAO iPiezaDAO;

	@Override
	public List<Pieza> listarPiezas() {
		// TODO Auto-generated method stub
		return iPiezaDAO.findAll();
	}

	@Override
	public Pieza guardarPieza(Pieza pieza) {
		// TODO Auto-generated method stub
		return iPiezaDAO.save(pieza);
	}

	@Override
	public Pieza piezaXID(Long id) {
		// TODO Auto-generated method stub
		return iPiezaDAO.findById(id).get();
	}

	@Override
	public Pieza actulizarPieza(Pieza pieza) {
		// TODO Auto-generated method stub
		return iPiezaDAO.save(pieza);
	}

	@Override
	public void eliminarPieza(Long id) {
		iPiezaDAO.deleteById(id);	
	}

}
