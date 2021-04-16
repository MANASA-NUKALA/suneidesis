package com.harium.suneidesis.concept.word;

import com.harium.suneidesis.linguistic.nlp.pos.Tag;

public class WordVerb extends Word {

	// The same verb may have none or more than one
	// E.g: to,from,of,X <- None
	// TODO change to list of concepts instead
	public static final String ATTRIBUTE_PREPOSITIONS = "prepositions";
	public static final String ATTRIBUTE_TRANSITIVITY = "transitivity";

	public WordVerb(String name) {
		super(name, Tag.VERB);
	}
	
	public Word getPrepositions() {
		return (Word) attributes.get(ATTRIBUTE_PREPOSITIONS);
	}

	public String getPrepositionsWord() {
		return attributes.get(ATTRIBUTE_PREPOSITIONS).getName();
	}

	public void setPrepositions(Word gender) {
		attributes.insert(ATTRIBUTE_PREPOSITIONS, gender);
	}

	public Word getTransitivity() {
		return (Word) attributes.get(ATTRIBUTE_TRANSITIVITY);
	}

	public String getTransitivityWord() {
		return getTransitivity().getName();
	}

	public void setTransitivity(Word Transitivity) {
		attributes.insert(ATTRIBUTE_TRANSITIVITY, Transitivity);
	}
}
