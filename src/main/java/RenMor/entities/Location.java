package RenMor.entities;

import jakarta.persistence.*;

// Entità Location
@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID univoco

    private String nome; // Nome della location
    private String citta; // Città della location

    // Costruttore vuoto
    public Location() {}

    // Costruttore completo
    public Location(String nome, String citta) {
        this.nome = nome;
        this.citta = citta;
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCitta() { return citta; }
    public void setCitta(String citta) { this.citta = citta; }
}
