package gmc.project.practice.rockpaperscissors.daos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import gmc.project.practice.rockpaperscissors.entities.PlayerEntity;

public interface PlayerDao extends JpaRepository<PlayerEntity, Long> {
	Optional<PlayerEntity> findByPlayerId(String playerId);
}
