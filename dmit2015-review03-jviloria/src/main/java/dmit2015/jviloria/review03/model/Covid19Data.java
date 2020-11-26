package dmit2015.jviloria.review03.model;

import java.time.LocalDate;

public class Covid19Data {

    private long id;


    private LocalDate dateReported;

    private String ahsZone;

    private int inHospital;

    private int inIntensiveCare;


    public Covid19Data(long id, LocalDate dateReported, String ahsZone, int inHospital, int inIntensiveCare) {
        this.id = id;
        this.dateReported = dateReported;
        this.ahsZone = ahsZone;
        this.inHospital = inHospital;
        this.inIntensiveCare = inIntensiveCare;
    }
}
