package de.carstorewebservice.sql.model;

import javax.persistence.*;

@Entity
@Table(name = "Car")
public class Car {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "carId", nullable = false)
    private Long carId;
    @Column(name = "fin", nullable = false)
    private String fin;
    @Column(name = "kennzeichen", nullable = false,unique = true)
    private String kennzeichen;
    @Column(name = "verbrenner")
    private String verbrenner;
    @Column(name = "tuev")
    private String tuev;
    @Column(name = "service")
    private String service;
    @Column(name = "halter", nullable = false)
    private String halter;


    public Car() {}

    public Car(String fin, String kennzeichen, String verbrenner, String tuev, String service,String halter) {
        this.fin = fin;
        this.kennzeichen = kennzeichen;
        this.verbrenner = verbrenner;
        this.tuev = tuev;
        this.service = service;
        this.halter=halter;
    }

    public Long getCarId() {
        return carId;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getKennzeichen() {
        return kennzeichen;
    }

    public void setKennzeichen(String kennzeichen) {
        this.kennzeichen = kennzeichen;
    }

    public String getVerbrenner() {
        return verbrenner;
    }

    public void setVerbrenner(String verbrenner) {
        this.verbrenner = verbrenner;
    }

    public String getTuev() {
        return tuev;
    }

    public void setTuev(String tuev) {
        this.tuev = tuev;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getHalter() {
        return halter;
    }

    public void setHalter(String halter) {
        this.halter = halter;
    }
}