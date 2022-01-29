package gmc.project.rockpapersissors.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "players")
public class Player implements Serializable {

	private static final long serialVersionUID = 8794683723020704705L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "player_id")
	private String playerId;
	
	@OneToMany(targetEntity = MatchEntity.class)
	private MatchEntity match;
	
	public Player() {
		this.match = new MatchEntity();
	}

}
