package kg.ecommerce.productservice.service;


import kg.ecommerce.productservice.models.dto.ProductDto;

import java.util.List;

public interface ProductService {
  void saveProducts(ProductDto stockDto);

    List<ProductDto> getProducts();
  ProductDto getProduct(Long id);

  Boolean delete(Long id);
}
