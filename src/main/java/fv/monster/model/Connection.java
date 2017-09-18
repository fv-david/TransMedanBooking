package fv.monster.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import lombok.Data;

@Entity
@Data
@JsonIgnoreProperties({"tickets"})
public class Connection {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String startPlace;
    @NotNull
    private String endPlace;
    @Min(0)
    private double distance;
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date departureDate;
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date arrivalDate;
    @Min(0)
    private int places;
    @OneToMany(mappedBy = "connection", cascade = CascadeType.REMOVE)
    private List<Ticket> tickets;
}
