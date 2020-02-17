package br.com.control.expensecontrol.domain.entities;

import br.com.control.expensecontrol.domain.models.PersonModel;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name="person")
public class PersonEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;

    public PersonEntity() {
    }

    public PersonEntity(PersonModel personModel) {
        if (personModel != null) {
            this.id = personModel.getId();
            this.name = personModel.getName();
            this.email = personModel.getEmail();
            this.phone = personModel.getPhone();
        }
    }

    public PersonModel toModel() {
        PersonModel personModel = new PersonModel();
        personModel.setId(this.id);
        personModel.setName(this.name);
        personModel.setEmail(this.email);
        personModel.setPhone(this.phone);
        return personModel;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonEntity)) return false;
        PersonEntity personEntity = (PersonEntity) o;
        return getId().equals(personEntity.getId()) &&
                getName().equals(personEntity.getName()) &&
                getEmail().equals(personEntity.getEmail()) &&
                getPhone().equals(personEntity.getPhone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getEmail(), getPhone());
    }
}
