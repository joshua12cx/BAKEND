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
import static com.example.demo.commons.GlobalConstans.API_CONVENIO;


import com.example.demo.entity.ConvenioEntity;

import com.example.demo.service.ConvenioService;


@RestController
@RequestMapping(API_CONVENIO)
public class ConvenioController {
	@Autowired
	private ConvenioService convenioService;

	@GetMapping("/all")
	public List<ConvenioEntity> listar() {
		return convenioService.readAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ConvenioEntity> listar2(@PathVariable("id") long id) {
		ConvenioEntity prod = convenioService.read(id);
		if (prod!=null) {
			return new ResponseEntity<>(prod, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		}
	@PostMapping("/convenio")
	  public ResponseEntity<ConvenioEntity> createTutorial(@RequestBody ConvenioEntity c) {
	    try {
	    	ConvenioEntity conv = convenioService.create(new ConvenioEntity(c.getId(), c.getEncargado(),c.getEstado(),c.getLugar(), c.getFecha_ini(),c.getSemestre())); 
	    	
	      return new ResponseEntity<>(conv, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	
	@PutMapping("/convenio/{id}")
	public ResponseEntity<ConvenioEntity> updateTutorial(@PathVariable("id") long id, @RequestBody ConvenioEntity conv) {
	    try {
	        ConvenioEntity convenio = convenioService.read(id);

	        if (convenio!=null) {

		    	convenio.setEncargado(conv.getEncargado());
		    	convenio.setEstado(conv.getEstado());
		    	convenio.setLugar(conv.getLugar());
		    	convenio.setFecha_ini(conv.getFecha_ini());
		    	convenio.setSemestre(conv.getSemestre());

	           ConvenioEntity updatedConvenio = convenioService.update(convenio);

	            return new ResponseEntity<>(updatedConvenio, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	    
	}
	@DeleteMapping("/convenio/{id}")
	public ResponseEntity<HttpStatus> deleteProducto(@PathVariable("id") long id) {
	    try {
	        convenioService.delete(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
}

