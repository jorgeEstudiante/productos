package es.jorge.productos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NonNull;

@Data
public class ProductoRequest {

    @NotBlank
    private String nombre;

    @Positive
    private Double precio;

    @Positive
    private Integer stock;
}
