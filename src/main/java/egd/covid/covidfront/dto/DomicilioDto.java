package egd.covid.covidfront.dto;

import java.io.Serializable;

import egd.covid.persistence.util.StaticValuesHelper;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DomicilioDto extends StaticValuesHelper implements Serializable {
	private static final long serialVersionUID = -6951391094771621775L;
	private String domicilio;
	private String cp;
	private String telefono;
	private String localidad;
	private String municipio;
	private String entidad;

	public String getDomicilioMostrar() {
		StringBuffer sb = new StringBuffer();
		if (this.domicilio != null) {
			sb.append(this.domicilio).append(COMMA).append(WHITE_SPACE);
		}
		if (this.cp != null) {
			sb.append(this.cp).append(COMMA).append(WHITE_SPACE);
		}
		if (this.localidad != null) {
			sb.append(this.localidad).append(COMMA).append(WHITE_SPACE);
		}
		if (this.municipio != null) {
			sb.append(this.municipio).append(COMMA).append(WHITE_SPACE);
		}
		if (this.entidad != null) {
			sb.append(this.entidad).append(COMMA).append(WHITE_SPACE);
		}
		
		String sDomicilio = sb.toString();
		if (sDomicilio.length() > 0) {
			return sDomicilio.substring(0, sDomicilio.length() - 2);
		}
		return sDomicilio;
	}
}
