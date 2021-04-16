package com.harium.suneidesis.concept.word;


import com.harium.suneidesis.linguistic.nlp.pos.Tag;

public class WordNumeral extends Word {

    public WordNumeral(String name) {
        super(name, Tag.NUMERAL);
    }

    public WordNumeral(String name, String type) {
        this(name);
        setWordType(new Word(type));
    }

}
