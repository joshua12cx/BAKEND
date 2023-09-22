package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ConvenioEntity;
import com.example.demo.repository.ConvenioRepository;
import com.example.demo.service.ConvenioService;

@Service
public class ConvenioServiceImpl implements ConvenioService{
	@Autowired
	private ConvenioRepository convenioRepository;

	@Override
	public ConvenioEntity create(ConvenioEntity conv) {
		// TODO Auto-generated method stub
		return convenioRepository.save(conv);
	}

	@Override
	public ConvenioEntity update(ConvenioEntity conv) {
		// TODO Auto-generated method stub
		return convenioRepository.save(conv);
	}

	@Override
	public void delete(Long id) {
		convenioRepository.deleteById(id);
		
	}

	@Override
	public ConvenioEntity read(Long id) {
		// TODO Auto-generated method stub
		return convenioRepository.findById(id).get();
	}

	@Override
	public List<ConvenioEntity> readAll() {
		// TODO Auto-generated method stub
		return convenioRepository.findAll();
	}

}
