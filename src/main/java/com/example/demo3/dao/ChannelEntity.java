package com.example.demo3.dao;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "channels", schema = "", catalog = "ai_bot_for_seo")
public class ChannelEntity {

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    private Long id;
    @Basic
    @Column(name = "title", nullable = false, insertable = true, updatable = true, length = 60)
    private String title;
    @Basic
    @Column(name = "description", nullable = false, insertable = true, updatable = true, length = 60)
    private String description;
    //private Date birthDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy="channels", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "channel_id") // ? channel_id or id
    private Set<CompanyEntity> companies;

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


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<CompanyEntity> getCompanies() { return companies; }
    public void setCompanies(Set<CompanyEntity> companies) { this.companies = companies; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChannelEntity that = (ChannelEntity) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description +
                '}';
    }
}

