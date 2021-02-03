package fr.epsi.entite;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Facture {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
    private Client client;
	
	@OneToMany
	private List<LigneFacture> ligneFacture;
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}	

	public List<LigneFacture> getLigneFacture() {
		return ligneFacture;
	}

	public void setLigneFacture(List<LigneFacture> ligneFacture) {
		this.ligneFacture = ligneFacture;
	}

}
