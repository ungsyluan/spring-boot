package guru.springframework.multipledatasources.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import guru.springframework.multipledatasources.repository.card.CardRepository;
import guru.springframework.multipledatasources.repository.cardholder.CardHolderRepository;
import guru.springframework.multipledatasources.repository.member.MemberRepository;

@RestController
public class TestController {

	@Autowired
	private MemberRepository memberRepository;
	
	
	@Autowired
	private CardHolderRepository cardHolderRepository;

	@Autowired
	private CardRepository cardRepository;

	@GetMapping("/card")
	public String getCard() {
		return cardRepository.findAll().toString();
	}

	@GetMapping("/member")
	public String getMember() {
		return memberRepository.findAll().toString();
	}

	@GetMapping("/cardHolder")
	public String getCardHolder() {
		return cardHolderRepository.findAll().toString();
	}
}
