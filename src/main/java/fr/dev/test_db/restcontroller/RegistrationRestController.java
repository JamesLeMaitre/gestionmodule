package fr.dev.test_db.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.dev.test_db.entities.Registration;
import fr.dev.test_db.methodes.RegistrationMethode;

@RestController
public class RegistrationRestController {

	@Autowired
	private RegistrationMethode registrationMethode;

	@PostMapping("/addNewRegistration/{id}")
	public boolean addRegistration(@RequestBody Registration registration, @PathVariable long id) {
		boolean res = false;
		try {
			registrationMethode.addNewRegistration(registration, id);
			res = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return res;
	}

	@GetMapping("/deleteRegistration/{id}")
	public boolean deleteRegistration(@PathVariable long id) {
		return registrationMethode.deleteRegistration(id);
	}
	
	@GetMapping("/updateRegistration/{id}")
	public Registration updateRegistration(@PathVariable long id) {
		return registrationMethode.updateRegistration(id);
	}

}
