package br.com.control.expensecontrol.domain.services.impl;

import br.com.control.expensecontrol.domain.entities.PersonEntity;
import br.com.control.expensecontrol.domain.models.PersonModel;
import br.com.control.expensecontrol.domain.repositories.PersonRepository;
import br.com.control.expensecontrol.domain.services.PersonService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public PersonModel save(PersonModel personModel) {

        if (personModel.getEmail().length() >= 100) {
            throw new IllegalArgumentException("Nâo é permitido tamanho maior que 100");
        }

        return personRepository.save(new PersonEntity(personModel)).toModel();
    }

    @Override
    public PersonModel findById(Long id) {
        return personRepository.findById(id).map(PersonEntity::toModel).orElse(null);
    }

    @Override
    public PersonModel update(Long id, PersonModel personModel) {
        PersonModel personModelSave = this.findById(id);
        if (personModelSave == null){
               throw new IllegalArgumentException();
        }
        BeanUtils.copyProperties(personModel, personModelSave, "id");


        return this.save(personModelSave);
    }

    @Override
    public List<PersonModel> saveAll(List<PersonModel> personModels) {
       int size = personModels.size();

        PersonModel lastPerson = personModels.get(--size);

        PersonEntity personEntity = this.personRepository.save(new PersonEntity(lastPerson));

        List<PersonModel> models = Collections.singletonList(personEntity).stream().map(PersonEntity::toModel).collect(Collectors.toList());

        return models;
    }
}