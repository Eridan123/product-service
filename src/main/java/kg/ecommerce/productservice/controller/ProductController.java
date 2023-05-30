package kg.ecommerce.productservice.controller;

import kg.ecommerce.productservice.models.dto.ProductDto;
import kg.ecommerce.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;

  @GetMapping()
  public List<ProductDto> list(){
    return productService.getProducts();
  }

  @GetMapping("/{id}")
  public ProductDto getProduct(@PathVariable Long id) {
    return productService.getProduct(id);
  }

  @PutMapping
  public void saveProduct(@RequestBody ProductDto stockDto){
    productService.saveProducts(stockDto);
  }

  @PostMapping("/delete/{id}")
  public ResponseEntity<Boolean> delete(@PathVariable Long id) {
    productService.delete(id);
    return ResponseEntity.ok(true);
  }
}
