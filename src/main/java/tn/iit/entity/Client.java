package tn.iit.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NamedQuery(name = "all-client", query = "select cl from Client cl")
@NamedQuery(name = "count-client", query = "select count(cl) from Client cl")
@Entity
@Table(name = "t_client")
public class Client implements Serializable { // spec JEE
	private static final long serialVersionUID = 1L;
	@Id
	@Include
	@Column(length = 20)
	private String cin; // PK
	private String nom;
	private String prenom;
	@JsonIgnore
	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@ToString.Exclude
	private Set<Compte> comptes;

	public Client(String cin, String nom, String prenom) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
	}
}