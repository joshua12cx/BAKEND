package com.example.demo.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "proyectos")
public class ProyectosEntity implements Serializable{
private static final long serialVersionUID = -2170897015344177815L;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
private Long id;

@Column(name = "nombre")
private String nombre;

@Column(name = "estado")
private boolean estado;

@Column(name = "facultad")
private String facultad;

@Column(name = "fecha_ini")
private String fechaIni;

@Column(name = "entidades")
private String entidades;
}
