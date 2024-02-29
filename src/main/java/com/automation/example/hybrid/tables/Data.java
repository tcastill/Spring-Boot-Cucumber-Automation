package com.automation.example.hybrid.tables;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

@Proxy(lazy = false)
@Entity
@Getter
@Setter
@Table(name = "dictionary")
public class Data implements Serializable {

    @Id
    private String word;
    private String result;

    @Column(name = "near_rhymes")
    private String nearRhymes;

    private String thesaurus;

    private String phrases;

    @Column(name = "descriptive_words")
    private String descriptiveWords;

    private String definitions;

    private String homophones;

    @Column(name = "similar_sound")
    private String similarSound;

    @Column(name = "same_consonants")
    private String sameConsonants;
}
