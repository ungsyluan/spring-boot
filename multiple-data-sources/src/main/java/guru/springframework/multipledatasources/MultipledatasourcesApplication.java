package guru.springframework.multipledatasources;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import guru.springframework.multipledatasources.model.card.Card;
import guru.springframework.multipledatasources.model.cardholder.CardHolder;
import guru.springframework.multipledatasources.model.member.Member;

@SpringBootApplication
public class MultipledatasourcesApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MultipledatasourcesApplication.class, args);
	}

	@PersistenceContext(unitName = "cardEntityManagerFactory")
	private EntityManager cardEntityManager;

	@PersistenceContext(unitName = "cardHolderEntityManagerFactory")
	private EntityManager cardHolderEntityManager;

	@PersistenceContext(unitName = "memberEntityManagerFactory")
	private EntityManager memberEntityManager;

	@Override
	public void run(String... args) throws Exception {
		List<Card> cards = cardEntityManager.createQuery("select a from Card a", Card.class).getResultList();
		System.out.println("CARD: " + cards.toString());

		List<CardHolder> cardHolders = cardHolderEntityManager.createQuery("select a from CardHolder a", CardHolder.class).getResultList();
		System.out.println("CARD HOLDER: " + cardHolders.toString());

		List<Member> members = memberEntityManager.createQuery("select a from Member a", Member.class).getResultList();
		System.out.println("MEMBER: " + members.toString());

	}

}
