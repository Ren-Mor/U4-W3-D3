package RenMor.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import RenMor.enums.Sesso;

// Entità Persona
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id; // ID univoco

    private String nome; // Nome della persona
    private String cognome; // Cognome della persona
    private String email; // Email della persona

    private LocalDate dataDiNascita; // Data di nascita

    @OneToMany(mappedBy = "persona")
    private List<Partecipazione> listaPartecipazioni; // Lista delle partecipazioni

    @Enumerated(EnumType.STRING)
    private Sesso sesso; // Sesso (M/F)

    // Costruttore vuoto
    public Persona() {}

    // Costruttore completo
    public Persona(String nome, String cognome, String email, LocalDate dataDiNascita, Sesso sesso) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataDiNascita = dataDiNascita;
        this.sesso = sesso;
    }

    // Getter

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public List<Partecipazione> getListaPartecipazioni() {
        return listaPartecipazioni;
    }

    public Sesso getSesso() {
        return sesso;
    }

    // Setter

    public void setId(UUID id) { this.id = id; }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public void setListaPartecipazioni(List<Partecipazione> listaPartecipazioni) {
        this.listaPartecipazioni = listaPartecipazioni;
    }

    public void setSesso(Sesso sesso) {
        this.sesso = sesso;
    }
}
