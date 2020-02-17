package br.com.control.expensecontrol.domain.services;

import br.com.control.expensecontrol.domain.models.PersonModel;

import java.util.List;

public interface PersonService {

    PersonModel save(PersonModel personModel);

    PersonModel findById(Long id);

    PersonModel update(Long id, PersonModel personModel);

    List<PersonModel> saveAll(List<PersonModel> personModels);

}
