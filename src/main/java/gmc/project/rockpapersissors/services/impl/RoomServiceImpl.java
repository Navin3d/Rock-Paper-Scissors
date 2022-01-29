package gmc.project.rockpapersissors.services.impl;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gmc.project.rockpapersissors.daos.MatchDao;
import gmc.project.rockpapersissors.daos.RoomDao;
import gmc.project.rockpapersissors.entities.MatchEntity;
import gmc.project.rockpapersissors.entities.Player;
import gmc.project.rockpapersissors.entities.RoomEntity;
import gmc.project.rockpapersissors.exceptions.RoomAlreadyExistsException;
import gmc.project.rockpapersissors.exceptions.RoomFilledException;
import gmc.project.rockpapersissors.exceptions.RoomNotFoundException;
import gmc.project.rockpapersissors.models.CreateRoomModel;
import gmc.project.rockpapersissors.models.RoomModel;
import gmc.project.rockpapersissors.services.RoomServices;

@Service
public class RoomServiceImpl implements RoomServices {
	
	@Autowired
	private RoomDao roomDao;
	
	@Autowired
	private MatchDao matchDao;
	
	@Override
	public RoomEntity findOne(String roomId) {
		RoomEntity foundRoom = roomDao.findByRoomId(roomId);
		
		if(foundRoom == null)
			throw new RoomNotFoundException();
		
		return foundRoom;
	}

	@Override
	public RoomModel createRoom(CreateRoomModel createRoomModel) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		MatchEntity matchEntity = new MatchEntity();
		matchEntity.setMatchId(UUID.randomUUID().toString());
		matchEntity.setStartedAt(Timestamp.from(Instant.now()));
		
		Player player1 = new Player();
		player1.setPlayerId(createRoomModel.getPlayer1Id());
		matchEntity.getPlayers().add(player1);
		
		RoomEntity roomEntity = new RoomEntity();
		roomEntity.setRoomId(createRoomModel.getRoomId());
		roomEntity.setMatches(matchEntity);
		
		RoomEntity foundRoom = findOne(createRoomModel.getRoomId());
		
		if(foundRoom != null)
			throw new RoomAlreadyExistsException();
		
		RoomEntity savedRoom = roomDao.save(roomEntity);

		RoomModel returnValue = modelMapper.map(savedRoom, RoomModel.class);
		
		return returnValue;
	}

	@Override
	public RoomModel joinRoom(CreateRoomModel joinRequest) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		RoomEntity foundRoom = findOne(joinRequest.getRoomId());
				
		if(foundRoom.getRoomFilled())
			throw new RoomFilledException();
		
		MatchEntity matchEntity = foundRoom.getMatches();
		
		Player player2 = new Player();
		player2.setPlayerId(joinRequest.getPlayer1Id());
		matchEntity.getPlayers().add(player2);
		matchEntity.setStartedAt(Timestamp.from(Instant.now()));
		
		matchDao.save(matchEntity);
		foundRoom.setRoomFilled(true);
		
		RoomEntity savedRoom = roomDao.save(foundRoom);

		RoomModel returnValue = modelMapper.map(savedRoom, RoomModel.class);
		
		return returnValue;
		
	}

	@Override
	public void deleteARoom(String roomId) {
		RoomEntity foundRoom = findOne(roomId);
		roomDao.delete(foundRoom);
	}

}
