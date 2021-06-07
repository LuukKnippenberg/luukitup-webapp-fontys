package org.luukitup.webapp.dal;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

@Entity
public class Project extends PanacheEntityBase implements Serializable
{
    @Id private String id;
    private String title;
    private String description;
    private String featuredImageUrl;
    private Boolean featured;
    private String linkToProject;
    @ElementCollection
    @JsonbTransient
    private List<String> galleryImageUrls;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getFeaturedImageUrl() {
        return featuredImageUrl;
    }

    public void setFeaturedImageUrl(String featuredImageUrl) {
        this.featuredImageUrl = featuredImageUrl;
    }

    public List<String> getGalleryImageUrls() {
        return galleryImageUrls;
    }

    public void setGalleryImageUrls(List<String> galleryImageUrls) {
        this.galleryImageUrls = galleryImageUrls;
    }

    public Boolean getFeatured() {
        return featured;
    }

    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    public String getLinkToProject() {
        return linkToProject;
    }

    public void setLinkToProject(String linkToProject) {
        this.linkToProject = linkToProject;
    }

    public void Save() {
        persist();
    }
}
