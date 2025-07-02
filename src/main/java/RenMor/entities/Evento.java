package RenMor.entities;

import RenMor.enums.TipoEvento;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "evento")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "titolo",nullable = false)
    private String titolo;
    @Column(name = "data", nullable = false)
    private LocalDate dataEvento;
    @Column(name = "descrizione",nullable = false)
    private String descrizione;
    @Column(name = "tipo_evento", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;
    @Column(name = "numero_massimo_partecipanti",nullable = false)
    private int numMax;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL)
    private java.util.List<Partecipazione> partecipazioni;

    public Evento(){};

    public Evento(String titolo,LocalDate dataEvento,String descrizione,TipoEvento tipoEvento,int numMax){
        this.titolo=titolo;
        this.dataEvento=dataEvento;
        this.descrizione=descrizione;
        this.tipoEvento=tipoEvento;
        this.dataEvento=dataEvento;
        this.numMax=numMax;
    }

    public Evento(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numMax, Location location) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numMax = numMax;
        this.location = location;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public int getNumMax() {
        return numMax;
    }

    public void setNumMax(int numMax) {
        this.numMax = numMax;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public java.util.List<Partecipazione> getPartecipazioni() {
        return partecipazioni;
    }

    public void setPartecipazioni(java.util.List<Partecipazione> partecipazioni) {
        this.partecipazioni = partecipazioni;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                ", numMax=" + numMax +
                '}';
    }
}
