package br.com.control.expensecontrol.domain.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;


@Entity
@Table(name="expense")
public class BuyEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;
    private BigDecimal total;
    @ManyToOne
    @JoinColumn(name = "id_category")
    private CategoryEntity categoryEntity;
    @ManyToOne
    @JoinColumn(name = "id_person")
    private PersonEntity personEntity;
    private LocalDateTime expireTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }

    public void setCategoryEntity(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
    }

    public PersonEntity getPersonEntity() {
        return personEntity;
    }

    public void setPersonEntity(PersonEntity personEntity) {
        this.personEntity = personEntity;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BuyEntity)) return false;
        BuyEntity buyEntity = (BuyEntity) o;
        return getId().equals(buyEntity.getId()) &&
                getName().equals(buyEntity.getName()) &&
                getPrice().equals(buyEntity.getPrice()) &&
                getTotal().equals(buyEntity.getTotal()) &&
                getCategoryEntity().equals(buyEntity.getCategoryEntity()) &&
                getPersonEntity().equals(buyEntity.getPersonEntity()) &&
                getExpireTime().equals(buyEntity.getExpireTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPrice(), getTotal(), getCategoryEntity(), getPersonEntity(), getExpireTime());
    }
}
