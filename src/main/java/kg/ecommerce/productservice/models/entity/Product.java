package kg.ecommerce.productservice.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "sku", nullable = false)
  private String sku;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "description", nullable = false)
  private String description;

  @Column(name = "category", nullable = false)
  private String category;

  @Column(name = "image", nullable = false)
  private String image;

  @CreationTimestamp
  @Column(name = "created_date", updatable = false, nullable = false, columnDefinition = "TIMESTAMP")
  private LocalDateTime createdDate;

  @UpdateTimestamp
  @Column(name = "last_modified_date", nullable = false, columnDefinition = "TIMESTAMP")
  private LocalDateTime lastModifiedDate;
}
