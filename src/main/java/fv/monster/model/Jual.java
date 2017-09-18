package fv.monster.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

/**
 *
 * @author fvsaddam - saddamtbg@gmail.com
 */
@Entity
@Table(name = "jual")
@Data
public class Jual {

    @GeneratedValue
    @Id
    private Long id;

    @NotNull
    @Min(1000)
    private BigDecimal harga;

    @NotNull
    @Min(0)
    private BigDecimal jumlah;

    @NotNull
    @NotEmpty
    private String jenis;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "waktu_jual")
    private Date waktuJual;

    @NotNull
    @NotEmpty
    private String username;

}
