package fv.monster.controller;

import fv.monster.model.Ticket;
import fv.monster.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 *
 * @author fvsaddam - fvmonster.corp@gmail.com
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TicketsController {

    @Autowired
    TicketService ticketService;

    @RequestMapping(value = "/tickets/book/{connectionId}", method = RequestMethod.POST)
    public Ticket bookTicket(@PathVariable Long connectionId, Authentication auth) {
        return ticketService.bookTicket(connectionId, auth.getName());
    }

    @RequestMapping(value = "/tickets/{id}/cancel", method = RequestMethod.DELETE)
    public void cancelBookTicket(@PathVariable Long id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        ticketService.cancelBookTicket(id, auth.getName());
    }

    @RequestMapping(value = "/tickets", method = RequestMethod.GET)
    public List<Ticket> getAllCurrentUserTickets() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return ticketService.getAllTicketsOfUser(auth.getName());
    }

    @RequestMapping(value = "/admin/tickets", method = RequestMethod.GET)
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @RequestMapping(value = "/admin/tickets/{id}", method = RequestMethod.DELETE)
    public void deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicket(id);
    }
}
