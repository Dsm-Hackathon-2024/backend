package org.example.backend.domain.invest.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.backend.domain.user.domain.User;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "invest")
public class Invest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String name;
    private double roc;
    private double price;
    private int quantity;

    @Builder
    public Invest(User user, String name, double roc, double price, int quantity) {
        this.user = user;
        this.name = name;
        this.roc = roc;
        this.price = price;
        this.quantity = quantity;
    }

    public void setRoc(double roc) {
        this.roc = roc;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
