package fr.dev.test_db.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.dev.test_db.entities.School_membership;
import fr.dev.test_db.methodes.SchoolMembershipMethode;

@RestController
public class SchoolMembershipRestController {
	@Autowired
	private SchoolMembershipMethode membershipMethode;

	@PostMapping("/addNewSchoolMembership/{id}")
	public boolean addSchoolMembership(@RequestBody School_membership membership, @PathVariable long id) {
		boolean res = false;
		try {
			System.out.println("Holaaaaaaaaaaaaa");
			membershipMethode.addNewSchoolMembership(membership, id);
			res = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return res;
	}

	@GetMapping("/deleteSchoolMembership/{id}")
	public boolean deleteSchoolMemberShips(@PathVariable long id) {
		return membershipMethode.deleteSchoolMembership(id);
	}

}
