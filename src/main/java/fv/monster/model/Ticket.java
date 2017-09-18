package fv.monster.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.NotEmpty;
import lombok.Data;

/**
 *
 * @author fvsaddam - fvmonster.corp@gmail.com
 */
@Entity
@Data
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    private String ticketNumber;
    @ManyToOne
    private Connection connection;
    @NotNull
    private BigDecimal price;
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date reservationDate;
    @ManyToOne
    private User user;
    @OneToOne(mappedBy = "ticket", cascade = CascadeType.REMOVE)
    private Invoice invoice;
}
