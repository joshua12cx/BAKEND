package com.example.demo.entity;
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="CONVENIO")
public class ConvenioEntity implements Serializable {
private static final long serialVersionUID = -2170897015344177815L;

@Id
@Column(name = "ID_CONVENIO")
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqConvenio")
@SequenceGenerator(sequenceName = "SEQ_CONVENIO", allocationSize = 1, name = "seqConvenio")
private Long id;


@Column(name = "ENCARGADO")
	private String encargado;

@Column(name = "ESTADO")
private String estado;

@Column(name = "LUGAR")
private String lugar;

@Column(name = "FECHA_INI")
private String fecha_ini;

@Column(name = "SEMESTRE")
private String semestre;
	
}
