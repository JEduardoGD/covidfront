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

	public String getDomicilioMostrar() {
		StringBuffer sb = new StringBuffer();
		if (this.domicilio != null) {
			sb.append(this.domicilio).append(COMMA).append(WHITE_SPACE);
		}
		if (this.cp != null) {
			sb.append(this.cp).append(COMMA).append(WHITE_SPACE);
		}
		String sDomicilio = sb.toString();
		if (sDomicilio.length() > 0) {
			return sDomicilio.substring(0, sDomicilio.length() - 2);
		}
		return sDomicilio;
	}
}
