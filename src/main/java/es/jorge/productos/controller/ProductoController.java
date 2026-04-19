package es.jorge.productos.controller;

import es.jorge.productos.dto.ProductoDTO;
import es.jorge.productos.model.ProductoModel;
import es.jorge.productos.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/compras")
public class ProductoController {
    @Autowired
    private ProductoService vService;

    //crud
    @PostMapping
    public ResponseEntity<String> postProducto(@Valid @RequestBody ProductoModel v){
        try{
            return ResponseEntity.status(201).body(vService.postProducto(v));
        }catch(Exception e){
            return new ResponseEntity("errorr al agregar Producto", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<ProductoDTO>> getProductos(){
        try{
            return ResponseEntity.status(200).body(vService.getProductos());
        }catch(Exception e){
            return new ResponseEntity("errorr al listar Productos", HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("{id}")
    public ResponseEntity<ProductoDTO> getxProducto(@PathVariable Integer id){
        try{
            return ResponseEntity.status(200).body(vService.getxProducto(id));
        }catch(Exception e){
            return new ResponseEntity("errorr al encontrar el Producto", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<String> puProducto(@PathVariable Integer id, @Valid @RequestBody ProductoModel v){
        try{
            return ResponseEntity.status(200).body(vService.puProducto(v));
        }catch(Exception e){
            return new ResponseEntity("errorr al actualizar el vehiculo", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> dProducto(@PathVariable Integer id){
        try{
            return ResponseEntity.status(200).body(vService.dProducto(id));
        }catch(Exception e){
            return new ResponseEntity("errorr al eliminar el vehiculo", HttpStatus.BAD_REQUEST);
        }
    }

    // la que faltaba
    /*@GetMapping("libres")
    public ResponseEntity<List<ProductoDTO>> libreVehiculos(){
        try{
            return ResponseEntity.status(200).body(vService.libreVehiculos());
        }catch(Exception e){
            return new ResponseEntity("errorr al listar los vehiculos", HttpStatus.BAD_REQUEST);
        }
    }*/

}
