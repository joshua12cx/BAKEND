package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.PrivilegioEntity;
import com.example.demo.repository.PrivilegioRepository;
import com.example.demo.service.PrivilegioService;

@Service
public class PrivilegioServiceImpl implements PrivilegioService{

	@Autowired
	private PrivilegioRepository privilegioRepository;
	
	@Override
	public PrivilegioEntity create(PrivilegioEntity priv) {
		// TODO Auto-generated method stub
		return privilegioRepository.save(priv);
	}

	@Override
	public PrivilegioEntity update(PrivilegioEntity priv) {
		// TODO Auto-generated method stub
		return privilegioRepository.save(priv);
	}

	@Override
	public void delete(Long id) {
		privilegioRepository.deleteById(id);
		
	}

	@Override
	public PrivilegioEntity read(Long id) {
		// TODO Auto-generated method stub
		return privilegioRepository.findById(id).get();
	}

	@Override
	public List<PrivilegioEntity> readAll() {
		// TODO Auto-generated method stub
		return privilegioRepository.findAll();
	}

}
