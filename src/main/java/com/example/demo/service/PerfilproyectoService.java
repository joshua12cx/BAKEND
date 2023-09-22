package com.example.demo.service;

import java.util.List;



import com.example.demo.entity.PerfilproyectoEntity;


public interface PerfilproyectoService {
	PerfilproyectoEntity create (PerfilproyectoEntity pp);
	PerfilproyectoEntity update(PerfilproyectoEntity pp);
	void delete(Long id);
	PerfilproyectoEntity read(Long id);
	List<PerfilproyectoEntity> readAll();

}
