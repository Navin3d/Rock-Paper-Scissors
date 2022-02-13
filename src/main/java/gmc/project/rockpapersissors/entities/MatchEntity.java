package gmc.project.rockpapersissors.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import gmc.project.rockpapersissors.models.Options;
import lombok.Data;

@Data
@Entity
@Table(name = "matches")
public class MatchEntity implements Serializable {

	private static final long serialVersionUID = 658676497716271504L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "match_id", unique = true)
	@Lob
	private String matchId;
	
	@Column(name = "player1_option")
	@Enumerated(value = EnumType.STRING)
	private Options player1Option;
	
	@Column(name = "player2_option")
	@Enumerated(value = EnumType.STRING)
	private Options player2Option;
	
	@Column(name = "player1_score")
	private Integer player1Score = 0;
	
	@Column(name = "player2_score")
	private Integer player2Score = 0;
	
	@OneToMany(mappedBy = "match", targetEntity = Player.class)
	private Set<Player> players;
	
	@Column(name = "is_player1_won")
	private Boolean isPlayer1Won;
	
	@Column(name = "waiting_time")
	private Integer waitingTime = 0;
	
	@Column(name = "is_waiting")
	private Boolean isWaiting = false;
	
	@Column(name = "match_cancelled")
	private Boolean isMatchCancelled = false;
	
	@OneToOne(mappedBy = "matches", fetch = FetchType.LAZY)
	private RoomEntity room = new RoomEntity();
	
	@Column(name = "started_at")
	private Timestamp startedAt;
	
	@Column(name = "finished_at")
	private Timestamp finishedAt;
	
	public MatchEntity() {
		this.players = new HashSet<>();
		this.startedAt = Timestamp.from(Instant.now());
	}
	
}
