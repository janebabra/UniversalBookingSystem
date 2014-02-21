package cz.cvut.fit.ortstepa.universalbookingsystem.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import cz.cvut.fit.ortstepa.universalbookingsystem.domain.helper.PropertyType;
 
@Entity
@Table(name="resource_property")
public class ResourceProperty {
 
    private Long id;
    private String name;
    @Enumerated(EnumType.ORDINAL)
    private PropertyType type;
    private Set<ResourcePropertyValue> values = new HashSet<ResourcePropertyValue>(0);
    private String defaultValue;
 
    public ResourceProperty() {}
    public ResourceProperty(String name, PropertyType type) {
        this.name = name;
        this.type = type;
    }
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return id;
    }
    public void setId(Long attributeId) {
        this.id = attributeId;
    }
     
    @NotEmpty
    @Column(name = "name", nullable = false, unique = true)
    public String getName() {
        return name;
    }
     
    public void setName(String name) {
        this.name = name;
    }
    
    @Enumerated(EnumType.ORDINAL)
    public PropertyType getType() {
        return type;
    }
    public void setType(PropertyType type) {
        this.type = type;
    }
         
    @OneToMany(mappedBy = "pk.attribute", cascade=CascadeType.ALL, orphanRemoval=true)
    public Set<ResourcePropertyValue> getValues() {
        return this.values ;
    }
  
    public void setValues(Set<ResourcePropertyValue> values) {
        this.values = values;
    }
     
    @Column(name = "default", nullable=false)
    public String getDefault() {
        return defaultValue;
    }
    public void setDefault(String defaultValue) {
        this.defaultValue = defaultValue;
    }
}