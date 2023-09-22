package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ProyectosEntity;
import com.example.demo.repository.ProyectosRepository;
import com.example.demo.service.ProyectosService;

@Service
public class ProyectosServiceImpl implements ProyectosService{

	@Autowired
	private ProyectosRepository proyectosRepository;
	@Override
	public ProyectosEntity create(ProyectosEntity proyecto) {
		// TODO Auto-generated method stub
		return proyectosRepository.save(proyecto);
	}

	@Override
	public List<ProyectosEntity> readAll() {
		// TODO Auto-generated method stub
		return proyectosRepository.findAll();
	}

	@Override
	public ProyectosEntity update(ProyectosEntity proyecto) {
		// TODO Auto-generated method stub
		return proyectosRepository.save(proyecto);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		proyectosRepository.findById(id);
	}

	@Override
	public ProyectosEntity read(Long id) {
		// TODO Auto-generated method stub
		return proyectosRepository.findById(id).get();
	}

}
