package es.jorge.productos.service;

import es.jorge.productos.dto.ProductoDTO;
import es.jorge.productos.dto.ProductoRequest;
import es.jorge.productos.model.ProductoModel;
import es.jorge.productos.repository.ProductoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository vRepository;

    public String postProducto(@Valid ProductoModel v) {
        vRepository.save(v);
        convertirADTO(v);
        return "producto creado";
    }

    private ProductoDTO convertirADTO(ProductoModel v) {
        ProductoDTO dto = new ProductoDTO();

        dto.setId(v.getId());
        dto.setPrecio(v.getPrecio());
        dto.setStock(v.getStock());
        return dto;
    }

    public List<ProductoDTO> getProductos() {
        return vRepository.findAll()
                .stream().map(this::convertirADTO)
                .toList();
    }

    public ProductoDTO getxProducto(Integer id) {
        return vRepository.findById(id)
                .map(this::convertirADTO)
                .orElse(null);
    }

    public String puProducto(@Valid ProductoModel v) {
        vRepository.save(v);
        return "Producto actualizado";
    }

    public String dProducto(Integer id) {
        vRepository.deleteById(id);
        return "Producto eliminado";
    }

    /*public List<ProductoDTO> libreVehiculos() {
        return vRepository.libreVehiculos();

    }*/
}
