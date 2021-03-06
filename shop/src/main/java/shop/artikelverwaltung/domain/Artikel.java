package shop.artikelverwaltung.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public abstract class Artikel {

	@NotEmpty
	private Long id;

	@Size(min = 2)
	@NotNull
	private String name;

	@NotNull
	private int preis;

	@NotNull
	private Hersteller hersteller;

	@NotNull
	private Lieferant lieferant;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPreis() {
		return preis;
	}

	public void setPreis(int preis) {
		this.preis = preis;
	}

	public Hersteller getHersteller() {
		return hersteller;
	}

	public void setHersteller(Hersteller hersteller) {
		this.hersteller = hersteller;
	}

	public Lieferant getLieferant() {
		return lieferant;
	}

	public void setLieferant(Lieferant lieferant) {
		this.lieferant = lieferant;
	}

	@Override
	public String toString() {
		return "Artikel [id=" + id + ", name=" + name + ", preis=" + preis
				+ ", hersteller=" + hersteller + ", lieferant=" + lieferant
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((hersteller == null) ? 0 : hersteller.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((lieferant == null) ? 0 : lieferant.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + preis;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Artikel other = (Artikel) obj;
		if (hersteller == null) {
			if (other.hersteller != null)
				return false;
		} else if (!hersteller.equals(other.hersteller))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lieferant == null) {
			if (other.lieferant != null)
				return false;
		} else if (!lieferant.equals(other.lieferant))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (preis != other.preis)
			return false;
		return true;
	}

}
