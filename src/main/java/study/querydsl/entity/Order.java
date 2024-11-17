package study.querydsl.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 개인 연습용 Order 엔티티 추가
 */
@Entity
@Getter
@Setter
@Table(name = "Orders")
public class Order {
    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    private String productName;

    private LocalDateTime orderDateTime;

    private Integer count;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
}
