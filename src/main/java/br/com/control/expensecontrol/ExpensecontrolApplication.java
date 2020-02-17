package br.com.control.expensecontrol;


import br.com.control.expensecontrol.domain.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ExpensecontrolApplication {

	@Autowired
	private PersonService personService;

	public static void main(String[] args) {
		SpringApplication.run(ExpensecontrolApplication.class, args);
	}


//	@Override
//	public void run(String... args) throws Exception {
//		PersonEntity p1 = new PersonEntity();
//		p1.setName("Lelis");
//		p1.setPhone("8888888");
//		p1.setEmail("test");
//
//		//personRepository.save(p1);
//		personRepository.delete(p1);
//
//	}
}
