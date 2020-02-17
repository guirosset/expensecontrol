package br.com.control.expensecontrol.api.resources;

import br.com.control.expensecontrol.domain.models.PersonModel;
import br.com.control.expensecontrol.domain.models.Random;
import br.com.control.expensecontrol.domain.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/persons")
public class PersonResource {

    @Autowired
    private PersonService personService;

    @Autowired
    RestTemplate restTemplate;

    @PostMapping
    public ResponseEntity<PersonModel> create(@RequestBody @Valid PersonModel personModel) {
        PersonModel personModelSave = personService.save(personModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(personModelSave);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonModel> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(personService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonModel> findById(@PathVariable Long id, @RequestBody PersonModel personModel) {
        PersonModel personModelSave = personService.update(id, personModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(personModelSave);
    }


    @PostMapping("/all")
    public ResponseEntity<List<PersonModel>> createAll(@RequestBody @Valid List<PersonModel> personModels) {
        List<PersonModel> models = personService.saveAll(personModels);

        return ResponseEntity.status(HttpStatus.CREATED).body(models);
    }

    @GetMapping("/all")
    public ResponseEntity<PersonModel> create1() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(headers);

       Random r = restTemplate.exchange("https://gturnquist-quoters.cfapps.io/api/random", HttpMethod.GET, entity, Random.class).getBody();

       PersonModel p = new PersonModel();
       p.setName(r.getValue().getQuote());
       p.setEmail("luc@gmail.com");
       p.setPhone("8888888888");

        personService.save(p);

        return ResponseEntity.ok(p);
    }

}
