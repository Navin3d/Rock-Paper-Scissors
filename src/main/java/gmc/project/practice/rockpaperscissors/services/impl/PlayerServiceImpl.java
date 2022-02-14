package gmc.project.practice.rockpaperscissors.services.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import gmc.project.practice.rockpaperscissors.daos.PlayerDao;
import gmc.project.practice.rockpaperscissors.daos.RoomDao;
import gmc.project.practice.rockpaperscissors.entities.PlayerEntity;
import gmc.project.practice.rockpaperscissors.entities.RoomEntity;
import gmc.project.practice.rockpaperscissors.exceptions.PlayerNotFoundException;
import gmc.project.practice.rockpaperscissors.exceptions.RoomFullException;
import gmc.project.practice.rockpaperscissors.exceptions.RoomNotFoundException;
import gmc.project.practice.rockpaperscissors.models.Options;
import gmc.project.practice.rockpaperscissors.models.PlayerModel;
import gmc.project.practice.rockpaperscissors.services.PlayersService;

@Service
public class PlayerServiceImpl implements PlayersService {
	
	private final PlayerDao playerDao;
	private final RoomDao roomDao;

	public PlayerServiceImpl(PlayerDao playerDao, RoomDao roomDao) {
		super();
		this.playerDao = playerDao;
		this.roomDao = roomDao;
	}

	@Override
	public PlayerEntity findOne(String playerId) {
		Optional<PlayerEntity> foundPlayer = playerDao.findByPlayerId(playerId);
		
		if(foundPlayer == null) throw new PlayerNotFoundException(playerId);
		
		return foundPlayer.get();
	}
	
	@Override
	public RoomEntity findOneRoom(String roomId) {
		Optional<RoomEntity> foundRoom = roomDao.findByRoomId(roomId);
		
		if(foundRoom == null) throw new RoomNotFoundException(roomId);
		
		return foundRoom.get();
	}
	
	@Override
	public PlayerModel getAUser(String userId) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		PlayerEntity foundPlayer = findOne(userId);
		PlayerModel returnValue = modelMapper.map(foundPlayer, PlayerModel.class);
		
		return returnValue;
	}
	
	@Override
	public PlayerModel createPlayer(String roomId) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		RoomEntity foundRoom = findOneRoom(roomId);
		
		if(foundRoom == null) throw new RoomNotFoundException(roomId);
		
		if(foundRoom.getPlayers().size() == 2) throw new RoomFullException(roomId);
		
		PlayerEntity newPlayer = new PlayerEntity();
		newPlayer.setMatchRoom(foundRoom);
		PlayerEntity savedPlayer = playerDao.save(newPlayer);
		foundRoom.getPlayers().add(savedPlayer);
		
		roomDao.save(foundRoom);
		
		PlayerModel playerModel = modelMapper.map(savedPlayer, PlayerModel.class);
		
		return playerModel;
	}

	@Override
	public PlayerModel editPlayer(PlayerModel playerEditModel) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		boolean bothPlayed = true;
		
		PlayerEntity foundPlayer = findOne(playerEditModel.getPlayerId());
		foundPlayer.setPlayerSelection(playerEditModel.getPlayerSelection());
		foundPlayer.setPlayerScore(playerEditModel.getPlayerScore());
		foundPlayer.setPlayed(playerEditModel.getPlayed());
		
		playerDao.save(foundPlayer);

		for(PlayerEntity player : foundPlayer.getMatchRoom().getPlayers()) 
			if(player.getPlayed() == false)
				bothPlayed = false;
		
		if(bothPlayed == true) {			
			PlayerEntity[] playersOption = foundPlayer.getMatchRoom().getPlayers().toArray(new PlayerEntity[2]);
			Options player1 = playersOption[0].getPlayerSelection();
			Options player2 = playersOption[1].getPlayerSelection();
			
			if(player1.equals(player2)) {
				
			} else if (player1.equals(Options.SCISSOR) && player2.equals(Options.ROCK)) {
				
				playersOption[1].setPlayerScore(playersOption[1].getPlayerScore() + 1);
			
			} else if (player1.equals(Options.ROCK) && player2.equals(Options.PAPER)) {
				
				playersOption[1].setPlayerScore(playersOption[1].getPlayerScore() + 1);
			
			} else if (player1.equals(Options.PAPER) && player2.equals(Options.SCISSOR)) {
				
				playersOption[1].setPlayerScore(playersOption[1].getPlayerScore() + 1);
			
			} else if (player1.equals(Options.SCISSOR) && player2.equals(Options.PAPER)) {
				
				playersOption[0].setPlayerScore(playersOption[0].getPlayerScore() + 1);
			
			}  else if (player1.equals(Options.PAPER) && player2.equals(Options.ROCK)) {
				
				playersOption[0].setPlayerScore(playersOption[0].getPlayerScore() + 1);
			
			}  else {
				
				playersOption[0].setPlayerScore(playersOption[0].getPlayerScore() + 1);
			
			}
			
			playersOption[0].setPlayerSelection(null);
			playersOption[1].setPlayerSelection(null);
			playersOption[0].setPlayed(false);
			playersOption[1].setPlayed(false);
			
			playerDao.save(playersOption[0]);
			playerDao.save(playersOption[1]);
		}
		
		PlayerEntity savedPlayer = findOne(foundPlayer.getPlayerId());		
		PlayerModel returnValue = modelMapper.map(savedPlayer, PlayerModel.class);
		
		return returnValue;
	}

}
