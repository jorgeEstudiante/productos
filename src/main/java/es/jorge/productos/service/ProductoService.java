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

    public ProductoDTO pProducto(@Valid ProductoRequest v) {
        ProductoModel u = new ProductoModel();
        u.setNombre(v.getNombre());
        u.setPrecio(v.getPrecio());
        u.setStock(v.getStock());
        ProductoModel guardado = vRepository.save(u);
        return convertirADTO(guardado);
    }

    private ProductoDTO convertirADTO(ProductoModel v) {
        ProductoDTO dto = new ProductoDTO();
        dto.setNombre(v.getNombre());
        dto.setEdad(v.getEdad());
        dto.setFechaNacimiento(v.getFechaNacimiento());
        dto.setPeso(v.getPeso());
        return dto;
    }

    public List<ProductoModel> gProducto() {
        return vRepository.findAll();
    }

    public ProductoDTO gxProducto(Integer id) {
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
