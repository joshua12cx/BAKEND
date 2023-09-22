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
@Table(name="PRIVILEGIO")
public class PrivilegioEntity implements Serializable {
private static final long serialVersionUID = -2170897015344177815L;

@Id
@Column(name = "ID_PRIVILEGIO")
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPrivilegio")
@SequenceGenerator(sequenceName = "SEQ_PRIVILEGIO", allocationSize = 1, name = "seqPrivilegio")
private Long id;


@Column(name = "COORDINADORA")
	private String coordinadora;

@Column(name = "FACULTAD")
private String facultad;

@Column(name = "CELULAR")
private int celular;

@Column(name = "DNI")
private int dni;
	
}
