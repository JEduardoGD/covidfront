package egd.covid.covidfront.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class BusquedaDto {
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
}
