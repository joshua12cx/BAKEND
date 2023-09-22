package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.example.demo.commons.GlobalConstans.API_PRIVILEGIO;


import com.example.demo.entity.PrivilegioEntity;

import com.example.demo.service.PrivilegioService;


@RestController
@RequestMapping(API_PRIVILEGIO)
public class PrivilegioController {
	@Autowired
	private PrivilegioService privilegioService;

	@GetMapping("/all")
	public List<PrivilegioEntity> listar() {
		return privilegioService.readAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PrivilegioEntity> listar2(@PathVariable("id") long id) {
		PrivilegioEntity prod = privilegioService.read(id);
		if (prod!=null) {
			return new ResponseEntity<>(prod, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		}
	@PostMapping("/privilegio")
	  public ResponseEntity<PrivilegioEntity> createTutorial(@RequestBody PrivilegioEntity p) {
	    try {
	    	PrivilegioEntity priv = privilegioService.create(new PrivilegioEntity(p.getId(), p.getFacultad(),p.getCoordinadora(), p.getCelular(),p.getDni())); 
	    	
	      return new ResponseEntity<>(priv, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	
	@PutMapping("/privilegio/{id}")
	public ResponseEntity<PrivilegioEntity> updateTutorial(@PathVariable("id") long id, @RequestBody PrivilegioEntity priv) {
	    try {
	    	PrivilegioEntity privilegio = privilegioService.read(id);

	        if (privilegio!=null) {
		    	
		    	privilegio.setCoordinadora(priv.getCoordinadora());
		    	privilegio.setFacultad(priv.getFacultad());
		    	privilegio.setCelular(priv.getCelular());
		    	privilegio.setDni(priv.getDni());
		    	

		    	PrivilegioEntity updatedPrivilegio = privilegioService.update(privilegio);

	            return new ResponseEntity<>(updatedPrivilegio, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	    
	}
	@DeleteMapping("/privilegio/{id}")
	public ResponseEntity<HttpStatus> deleteProducto(@PathVariable("id") long id) {
	    try {
	        privilegioService.delete(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
}

