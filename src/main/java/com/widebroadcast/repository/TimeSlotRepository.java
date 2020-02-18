package com.widebroadcast.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import com.widebroadcast.common.WideBroadCastEnum.TimeSlotStatus;
import com.widebroadcast.entity.Slot;
import com.widebroadcast.entity.TimeSlot;

@Repository
public interface TimeSlotRepository extends JpaRepository<TimeSlot, Integer> {

	List<TimeSlot> findAllBySlotOrderByTimeSlotIdAsc(Slot slot);

	Optional<TimeSlot> findBySlotDateTime(LocalDateTime dateTime);

	Long countByStatusAndSlotDateTimeBetween(TimeSlotStatus status, LocalDateTime from, LocalDateTime to);

	@Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
	List<TimeSlot> findByStatusAndSlotDateTimeBetween(TimeSlotStatus available, LocalDateTime fromDateTime,
			LocalDateTime toDateTime);
	
}
