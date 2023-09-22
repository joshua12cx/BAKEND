package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.ProyectosEntity;

public interface ProyectosService {
	ProyectosEntity create(ProyectosEntity proyecto);

    List<ProyectosEntity> readAll();

    ProyectosEntity update(ProyectosEntity proyecto);

    void delete(Long id);

    ProyectosEntity read(Long id);
}
