package com.cart.VegetableService.entity;
import jakarta.persistence.*;
import java.util.Objects;
@Entity
@Table(name="VEGETABLE")
public class Vegetable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private VegetableCategory category;
    private Double availableQuantity;

    public Vegetable() {
    }

    public Vegetable(Long id, String name, VegetableCategory category, Double availableQuantity) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.availableQuantity = availableQuantity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(VegetableCategory category) {
        this.category = category;
    }

    public void setAvailableQuantity(Double availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public VegetableCategory getCategory() {
        return category;
    }

    public double getAvailableQuantity() {
        return availableQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vegetable vegetable = (Vegetable) o;

        if (id != vegetable.id) return false;
        if (Double.compare(vegetable.availableQuantity, availableQuantity) != 0) return false;
        if (!Objects.equals(name, vegetable.name)) return false;
        return category == vegetable.category;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        temp = Double.doubleToLongBits(availableQuantity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "VegetableRepository{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", availableQuantity=" + availableQuantity +
                '}';
    }

    @PrePersist
    private void checkAndUpdateQuantity() {
        if (this.availableQuantity == null || this.availableQuantity < 0) {
            this.availableQuantity = 0.0;
        }
    }
}
