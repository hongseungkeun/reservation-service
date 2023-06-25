package com.numble.reservation.domain.venue.seat.service;

import com.numble.reservation.domain.venue.domain.Venue;
import com.numble.reservation.domain.venue.seat.data.Status;
import com.numble.reservation.domain.venue.seat.domain.Seat;
import com.numble.reservation.domain.venue.seat.dto.request.SeatRegisterRequest;
import com.numble.reservation.domain.venue.seat.exception.SeatNotFoundException;
import com.numble.reservation.domain.venue.seat.repository.SeatRepository;
import com.numble.reservation.global.exception.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SeatService {
    private final RedissonClient redissonClient;
    private final SeatRepository seatRepository;

    @Transactional
    public void save(List<SeatRegisterRequest> seats, Venue venue) {
        seatRepository.saveAll(seats.stream().map(s -> s.toSeat(venue)).toList());
    }

    @Transactional
    public List<Seat> isSeatsAvailable(List<Long> seatIds){
        List<Seat> seats = new ArrayList<>();
        for(Long seatId : seatIds){
            seats.add(lock(seatId));
        }
        return seats;
    }

    public Seat lock(Long seatId){
        RLock lock = redissonClient.getLock(String.format("reservation:lock:%d", seatId));
        try{
            boolean available = lock.tryLock(100 ,1, TimeUnit.SECONDS);
            if(!available){
                throw new RuntimeException("Lock 획득 실패!");
            }
            Seat seat = isSeatAvailable(seatId);
            seat.seatChangeOccupied();
            return seat;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public List<Seat> findSeats(List<Long> id) {
        return seatRepository.findAllById(id);
    }

    public Seat isSeatAvailable(Long id) {
        return seatRepository.findBySeatIdAndStatus(id, Status.AVAILABLE)
                .orElseThrow(() -> new SeatNotFoundException(ErrorCode.SEAT_ALREADY_OCCUPIED));
    }
}
