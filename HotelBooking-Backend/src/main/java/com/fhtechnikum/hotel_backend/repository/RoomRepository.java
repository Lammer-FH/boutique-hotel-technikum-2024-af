package com.fhtechnikum.hotel_backend.repository;

import com.fhtechnikum.hotel_backend.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
	//@Query("SELECT ROOM_ID, ROOM_TITLE, ROOM_DESCRIPTION FROM ROOM ORDER BY ROOM_ID")
	//Iterable<Room> findAllRooms();
}
