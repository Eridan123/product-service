package kg.ecommerce.productservice.mapper;


import kg.ecommerce.productservice.models.dto.ProductDto;
import kg.ecommerce.productservice.models.elastic.ElasticProduct;
import kg.ecommerce.productservice.models.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {

  List<Product> mapProductDtosToProducts(List<ProductDto> dto);

  @Mapping(source = "sku", target = "sku")
  @Mapping(source = "name", target = "name")
  @Mapping(source = "description", target = "description")
  @Mapping(source = "image", target = "image")
  @Mapping(source = "lastModifiedDate", target = "lastModifiedDate")
  @Mapping(source = "createdDate", target = "createdDate")
  ProductDto mapProductToProductDto(Product stock);

  List<ProductDto> mapProductsToProductDtos(List<Product> stocks);

  @Mapping(source = "sku", target = "sku")
  @Mapping(source = "name", target = "name")
  @Mapping(source = "description", target = "description")
  @Mapping(source = "image", target = "image")
  @Mapping(source = "lastModifiedDate", target = "lastModifiedDate")
  @Mapping(source = "createdDate", target = "createdDate")
  @Mapping(source = "category", target = "category")
  Product mapProductDtoToModel(ProductDto stockDto);

  @Mapping(source = "sku", target = "sku")
  @Mapping(source = "name", target = "name")
  @Mapping(source = "description", target = "description")
  @Mapping(source = "image", target = "image")
  @Mapping(source = "lastModifiedDate", target = "lastModifiedDate")
  @Mapping(source = "createdDate", target = "createdDate")
  @Mapping(source = "category", target = "category")
  ElasticProduct mapProductToElasticProduct(Product product);
}
