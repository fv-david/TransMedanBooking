package fv.monster.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import lombok.Data;

@Entity
@Data
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private BigDecimal priceGross;
    @Min(0)
    private BigDecimal taxPercent;
    @OneToOne
    private Ticket ticket;
}
