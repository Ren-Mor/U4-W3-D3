package RenMor.entities;

import jakarta.persistence.*;
import RenMor.enums.Stato;

// Entità Partecipazione
@Entity
public class Partecipazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID univoco

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona; // Persona che partecipa

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento; // Evento a cui partecipa

    @Enumerated(EnumType.STRING)
    private Stato stato; // Stato della partecipazione

    // Costruttore vuoto
    public Partecipazione() {}

    // Costruttore completo
    public Partecipazione(Persona persona, Evento evento, Stato stato) {
        this.persona = persona;
        this.evento = evento;
        this.stato = stato;
    }

    // Getter e setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Persona getPersona() { return persona; }
    public void setPersona(Persona persona) { this.persona = persona; }

    public Evento getEvento() { return evento; }
    public void setEvento(Evento evento) { this.evento = evento; }

    public Stato getStato() { return stato; }
    public void setStato(Stato stato) { this.stato = stato; }
}
