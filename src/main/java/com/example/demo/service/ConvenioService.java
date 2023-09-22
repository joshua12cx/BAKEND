package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.ConvenioEntity;

public interface ConvenioService {
	ConvenioEntity create (ConvenioEntity conv);
	ConvenioEntity update(ConvenioEntity conv);
	void delete(Long id);
	ConvenioEntity read(Long id);
	List<ConvenioEntity> readAll();

}
