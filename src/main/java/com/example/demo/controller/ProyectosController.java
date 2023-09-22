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
import static com.example.demo.commons.GlobalConstans.API_PROYECTOS;

import com.example.demo.entity.ProyectosEntity;
import com.example.demo.service.ProyectosService;

@RestController
@RequestMapping(API_PROYECTOS)
public class ProyectosController {
	@Autowired
    private ProyectosService proyectoService;
	

    @GetMapping("/all")
    public List<ProyectosEntity> listar() {
        return proyectoService.readAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProyectosEntity> listarPorId(@PathVariable("id") long id) {
    	ProyectosEntity proyecto = proyectoService.read(id);
        if (proyecto != null) {
            return new ResponseEntity<>(proyecto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/proyecto1")
    public ResponseEntity<ProyectosEntity> crearProyecto(@RequestBody ProyectosEntity proyecto) {
        try {
        	ProyectosEntity creado = proyectoService.create(proyecto);
            return new ResponseEntity<>(creado, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/proyecto1/{id}")
    public ResponseEntity<ProyectosEntity> actualizarProyecto(@PathVariable("id") long id, @RequestBody ProyectosEntity proyecto) {
        try {
        	ProyectosEntity existente = proyectoService.read(id);

            if (existente != null) {
                existente.setNombre(proyecto.getNombre());
                existente.setEstado(proyecto.isEstado());
                existente.setFacultad(proyecto.getFacultad());
                existente.setFechaIni(proyecto.getFechaIni());
                existente.setEntidades(proyecto.getEntidades());

                ProyectosEntity actualizado = proyectoService.update(existente);

                return new ResponseEntity<>(actualizado, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/proyecto1/{id}")
    public ResponseEntity<HttpStatus> eliminarProyecto(@PathVariable("id") long id) {
        try {
            proyectoService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
