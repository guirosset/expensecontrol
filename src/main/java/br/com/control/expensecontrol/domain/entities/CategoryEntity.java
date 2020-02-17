package br.com.control.expensecontrol.domain.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="category")
public class CategoryEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoryEntity)) return false;
        CategoryEntity categoryEntity = (CategoryEntity) o;
        return getId().equals(categoryEntity.getId()) &&
                getName().equals(categoryEntity.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }


}
