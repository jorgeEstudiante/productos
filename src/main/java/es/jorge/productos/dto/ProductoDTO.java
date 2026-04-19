package es.jorge.productos.dto;

import lombok.Data;

@Data
public class ProductoDTO {
    private Integer id;
    private String nombre;
    private Double precio;
    private Integer stock;
}
