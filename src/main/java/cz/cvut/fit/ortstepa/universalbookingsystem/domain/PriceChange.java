package cz.cvut.fit.ortstepa.universalbookingsystem.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import cz.cvut.fit.ortstepa.universalbookingsystem.domain.helper.PriceChangeType;

@Entity
@Table(name="price_change")
public class PriceChange {

	private Long id;
	private String value;
	private PriceChangeType type;
	private String name;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotNull
	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "value")
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Enumerated(EnumType.ORDINAL)
	public PriceChangeType getType() {
		return type;
	}

	public void setType(PriceChangeType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return this.name;
	}
	
	
}
