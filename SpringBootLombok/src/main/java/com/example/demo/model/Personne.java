package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

//@FieldDefaults(level=AccessLevel.PRIVATE)
//@Setter
//@Getter
//@ToString (of= {"nom","prenom"})
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Personne {
	Integer num;
	@NonNull
	String nom;
	@NonNull
	String prenom;
}
