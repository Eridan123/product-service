package kg.ecommerce.productservice.repository;

import kg.ecommerce.productservice.models.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

  @Modifying
  @Query(
          "update Product s set s.name = :name, s.description = :description, s.lastModifiedDate = :lastModified where s.sku = :sku " +
                  "and s.lastModifiedDate < :lastModifiedDate")
  void saveUpdatedProducts(@Param("name") String name, @Param("description") String description,
                           @Param("lastModifiedDate") LocalDateTime lastModifiedDate,
                           @Param("sku") String sku);

  Product findProductBySku(String sku);
}
