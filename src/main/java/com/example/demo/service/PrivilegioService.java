package com.example.demo.service;

import java.util.List;



import com.example.demo.entity.PrivilegioEntity;


public interface PrivilegioService {
	PrivilegioEntity create (PrivilegioEntity priv);
	PrivilegioEntity update(PrivilegioEntity priv);
	void delete(Long id);
	PrivilegioEntity read(Long id);
	List<PrivilegioEntity> readAll();

}
