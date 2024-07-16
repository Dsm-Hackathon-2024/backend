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

    private String image;
    private String name;
    private int roc;
    private int price;

    @Builder
    public Invest(User user, String image, String name, int roc, int price) {
        this.user = user;
        this.image = image;
        this.name = name;
        this.roc = roc;
        this.price = price;
    }
}
