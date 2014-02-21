package cz.cvut.fit.ortstepa.universalbookingsystem.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "permission")
public class Permission implements GrantedAuthority {
	private Long id;
	private String name;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Long getId() { return id; }

	@SuppressWarnings("unused")
	private void setId(Long id) { this.id = id; }

	@Column(name = "name")
	public String getName() { return name; }

	public void setName(String name) { this.name = name; }
	
	@Override
	@Transient
	public String getAuthority() { return name; }

	@Override
	public boolean equals(Object o) {
		GrantedAuthority ga = (GrantedAuthority) o;
		return (getAuthority().equals(ga.getAuthority()));
	}

	@Override
	public int hashCode() {
		return getAuthority().hashCode();
	}
}