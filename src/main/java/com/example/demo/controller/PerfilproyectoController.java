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
import com.example.demo.entity.PerfilproyectoEntity;
import com.example.demo.service.PerfilproyectoService;
import static com.example.demo.commons.GlobalConstans.API_PERFILPROYECTO;



@RestController
@RequestMapping(API_PERFILPROYECTO)
public class PerfilproyectoController {
	@Autowired
	private PerfilproyectoService perfilproyectoService;

	@GetMapping("/all")
	public List<PerfilproyectoEntity> listar() {
		return perfilproyectoService.readAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PerfilproyectoEntity> listar2(@PathVariable("id") long id) {
		PerfilproyectoEntity prod = perfilproyectoService.read(id);
		if (prod!=null) {
			return new ResponseEntity<>(prod, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		}
	@PostMapping("/perfilproyecto")
	  public ResponseEntity<PerfilproyectoEntity> createTutorial(@RequestBody PerfilproyectoEntity p) {
	    try {
	      PerfilproyectoEntity pp = perfilproyectoService.create(new PerfilproyectoEntity(p.getId(), p.getNombre(), p.getEstado(), p.getLimite_proyecto()));

	      return new ResponseEntity<>(pp, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	@PutMapping("/perfilproyecto/{id}")
	public ResponseEntity<PerfilproyectoEntity> updateTutorial(@PathVariable("id") long id, @RequestBody PerfilproyectoEntity pp) {
	    try {
	        PerfilproyectoEntity perfilproyecto = perfilproyectoService.read(id);

	        if (perfilproyecto != null) {
	        	
	            perfilproyecto.setNombre(pp.getNombre());
	            perfilproyecto.setEstado(pp.getEstado());
	            perfilproyecto.setLimite_proyecto(pp.getLimite_proyecto());

	            PerfilproyectoEntity updatedPerfilproyecto = perfilproyectoService.update(perfilproyecto);

	            return new ResponseEntity<>(updatedPerfilproyecto, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	    
	}
	@DeleteMapping("/perfilproyecto/{id}")
	public ResponseEntity<HttpStatus> deleteProducto(@PathVariable("id") long id) {
	    try {
	        perfilproyectoService.delete(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
}

