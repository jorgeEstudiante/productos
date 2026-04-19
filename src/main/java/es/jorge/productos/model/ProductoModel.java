package es.jorge.productos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity//define que esta clase es una tabla en la base de datos
@Table(name = "productos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoModel {
    @Id//marca el campo como llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)//la base de datos se encarga de 1, 2, 3...
    private Integer id;

    private String nombre;
    private Double precio;
    private Integer stock;
}
