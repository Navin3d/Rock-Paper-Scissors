package gmc.project.rockpapersissors.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import gmc.project.rockpapersissors.entities.MatchEntity;

public interface MatchDao extends JpaRepository<MatchEntity, Long> {
	MatchEntity findByMatchId(String matchId);
}
