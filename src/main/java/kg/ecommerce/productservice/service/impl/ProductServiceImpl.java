package kg.ecommerce.productservice.service.impl;

import kg.ecommerce.productservice.mapper.ProductMapper;
import kg.ecommerce.productservice.models.dto.ProductDto;
import kg.ecommerce.productservice.models.entity.Product;
import kg.ecommerce.productservice.repository.ElasticSearchQuery;
import kg.ecommerce.productservice.repository.ProductRepository;
import kg.ecommerce.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  private final ProductMapper productMapper;

  private final ElasticSearchQuery elasticSearchQuery;

  @Override
  public void saveProducts(ProductDto productDto) {
    Product product = productMapper.mapProductDtoToModel(productDto);
    productRepository.saveAndFlush(product);
    try {
      elasticSearchQuery.createOrUpdateDocument(productMapper.mapProductToElasticProduct(product));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

    @Override
    public List<ProductDto> getProducts() {
        return productMapper.mapProductsToProductDtos(productRepository.findAll());
    }

  @Override
  public ProductDto getProduct(Long id) {
    return productMapper.mapProductToProductDto(productRepository.findById(id).get());
  }

  @Override
  public Boolean delete(Long id) {
    productRepository.deleteById(id);
    try {
      elasticSearchQuery.deleteDocumentById(String.valueOf(id));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return Boolean.TRUE;
  }

  Product findProductBySku(String sku){
    return productRepository.findProductBySku(sku);
  }


}
