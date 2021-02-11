package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.Personne;

@Controller
public class LombokController {
	@GetMapping(value = "/lombok")
	public void sayHello() {
		Personne personne = new Personne();
		personne.setNom("doe");
		personne.setPrenom("toto");
		personne.setNum(9);
		System.out.println(personne);
		Personne p2=new Personne(10,"doe","titi");
		System.out.println(p2);
		Personne personne3 = new Personne("green","ben");
		System.out.println(personne3);
		
	}
}