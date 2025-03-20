package com.crud.jpa_relations_17_03.entity.one_to_many;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "publicationDate")
    private LocalDate publicationDate;

    @Column(name = "deleted")
    private Boolean deleted = false;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "book_id")
    private List<Author> authors;

    public Book() {
    }

    public Book(Long id, String title, LocalDate publicationDate, Boolean deleted, List<Author> authors) {
        this.id = id;
        this.title = title;
        this.publicationDate = publicationDate;
        this.deleted = deleted;
        this.authors = authors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
