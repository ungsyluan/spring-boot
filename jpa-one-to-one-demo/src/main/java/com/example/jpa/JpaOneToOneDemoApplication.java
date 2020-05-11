package com.example.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.jpa.repository.UserProfileRepository;
import com.example.jpa.repository.UserRepository;

import entity.example.jpa.model.UserDetails;

@SpringBootApplication
public class JpaOneToOneDemoApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private UserProfileRepository userProfileRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaOneToOneDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Clean up database tables
//		userProfileRepository.deleteAllInBatch();
//		userRepository.deleteAllInBatch();

		// =========================================

		// Create a User instance
//		User user = new User("Rajeev", "Singh", "rajeev@callicoder.com", "MY_SUPER_SECRET_PASSWORD");
//
//		Calendar dateOfBirth = Calendar.getInstance();
//		dateOfBirth.set(1992, 7, 21);
//
//		// Create a UserProfile instance
//		UserProfile userProfile = new UserProfile("+91-8197882053", Gender.MALE, dateOfBirth.getTime(), "747",
//				"2nd Cross", "Golf View Road, Kodihalli", "Bangalore", "Karnataka", "India", "560008");
//
//		// Set child reference(userProfile) in parent entity(user)
//		user.setUserProfile(userProfile);
//
//		// Set parent reference(user) in child entity(userProfile)
//		userProfile.setUser(user);
//
//		// Save Parent Reference (which will save the child as well)
//		userRepository.save(user);

		// Scalar function
		List<UserDetails> uProfile = getUserDetails();

		System.out.print(uProfile.get(0).toString());

		// =========================================
	}

	List<UserDetails> getUserDetails() {
		Query query = entityManager.createQuery("SELECT a, u from UserProfile a inner join User u on a.userId = u.id");
		List<UserDetails> uProfile = (List<UserDetails>)query.getResultList();
		return uProfile;
	}

}
