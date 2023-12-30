package egd.covid.covidfront.dto;

import java.io.Serializable;

import egd.covid.persistence.util.StaticValuesHelper;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class PersonaDto extends StaticValuesHelper implements Serializable {
	private static final long serialVersionUID = -1641318817027772444L;

	private int id;
	private String gDomicilio;
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private String sexoDto;
	private String curp;
	private String fechaNacimiento;
	private String edadDto;
	private String nacionalidadDto;
	private String corina;

	public String getNombreCompleto() {
		StringBuffer sb = new StringBuffer();
		if (this.getNombre() != null) {
			sb.append(this.getNombre());
			sb.append(WHITE_SPACE);
		}
		if (this.getPrimerApellido() != null) {
			sb.append(this.getPrimerApellido());
			sb.append(WHITE_SPACE);
		}
		if (this.getSegundoApellido() != null) {
			sb.append(this.getSegundoApellido());
			sb.append(WHITE_SPACE);
		}
		return sb.toString().trim();
	}
}
