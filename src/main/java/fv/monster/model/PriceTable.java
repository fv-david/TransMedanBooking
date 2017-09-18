package fv.monster.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import java.math.BigDecimal;

import lombok.Data;

@Entity
@Data
public class PriceTable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Min(0)
    private BigDecimal pricePerKilometer;
    @Min(0)
    private BigDecimal taxPercent;
}
