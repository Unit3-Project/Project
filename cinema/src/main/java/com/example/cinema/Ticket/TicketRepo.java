package com.example.cinema.Ticket;

import com.example.cinema.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TicketRepo extends JpaRepository<Ticket,Long> {

//    @Query("SELECT u from user u where u.id = ?1")
//    List<Ticket> getAllUserTicket(Long user_id);
}
