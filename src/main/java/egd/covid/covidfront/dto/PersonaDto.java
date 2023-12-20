package egd.covid.covidfront.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class PersonaDto implements Serializable {
	private static final long serialVersionUID = -1641318817027772444L;
	
	private int id;
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
}