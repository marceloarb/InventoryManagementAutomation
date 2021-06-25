package org.tgs_ct.probies.service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@SuppressWarnings("unused")
@Entity(name = "product")
public class Product {
    @Id
    @GeneratedValue
    private final int id;
    @Column
    private final String name;

    @Column
    private final BigDecimal price;

    public Product() {
        this(-1, null, null);
    }

    public Product(int id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice(){return price;}

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
