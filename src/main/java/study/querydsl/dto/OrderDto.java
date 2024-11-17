package study.querydsl.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderDto {
    private String productName;

    private LocalDateTime orderDateTime;

    private Integer count;

    @QueryProjection
    public OrderDto(String productName, LocalDateTime orderDateTime, Integer count) {
        this.productName = productName;
        this.orderDateTime = orderDateTime;
        this.count = count;
    }
}
