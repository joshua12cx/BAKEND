package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.PerfilproyectoEntity;
import com.example.demo.repository.PerfilproyectoRepository;
import com.example.demo.service.PerfilproyectoService;

@Service
public class PerfilproyectoServiceImpl implements PerfilproyectoService{

	@Autowired
	private PerfilproyectoRepository perfilproyectoRepository;
	
	@Override
	public PerfilproyectoEntity create(PerfilproyectoEntity pp) {
		// TODO Auto-generated method stub
		return perfilproyectoRepository.save(pp);
	}

	@Override
	public PerfilproyectoEntity update(PerfilproyectoEntity pp) {
		// TODO Auto-generated method stub
		return perfilproyectoRepository.save(pp);
	}

	@Override
	public void delete(Long id) {
		perfilproyectoRepository.deleteById(id);
		
	}

	@Override
	public PerfilproyectoEntity read(Long id) {
		// TODO Auto-generated method stub
		return perfilproyectoRepository.findById(id).get();
	}

	@Override
	public List<PerfilproyectoEntity> readAll() {
		// TODO Auto-generated method stub
		return perfilproyectoRepository.findAll();
	}

}
