package dmit2015.jviloria.review03.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;


@Data
@Entity                     // This class is map to database table with the same name as the class name
@Table(name = "covid19data")
public class Covid19Data {

    @Id                 // This is the primary key field
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @PastOrPresent
    private LocalDate dateReported;

    @NotBlank
    private String ahsZone;

    @Min(0)
    private int inHospital;

    @Min(0)
    private int inIntensiveCare;

}
