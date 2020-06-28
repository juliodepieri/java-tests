package com.example.test.product;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class ProductDto {

    private Long id;

    @NotNull(message = "name must not be null")
    @Size(min = 5, max = 100, message = "name must be between 5 and 10 characteres")
    private String name;

    @NotNull(message = "price must not be null")
    @Min(value = 0, message = "price must not be less than 0")
    private BigDecimal price;

    public Product toEntity() {
        return Product.builder()
                .id(id)
                .name(name)
                .price(price)
                .build();
    }

}
