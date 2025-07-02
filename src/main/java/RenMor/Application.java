package RenMor;

import RenMor.DAO.EventiDAO;
import RenMor.DAO.LocationDAO;
import RenMor.DAO.PartecipazioneDAO;
import RenMor.DAO.PersonaDAO;
import RenMor.entities.Evento;
import RenMor.entities.Location;
import RenMor.entities.Partecipazione;
import RenMor.entities.Persona;
import RenMor.enums.Sesso;
import RenMor.enums.Stato;
import RenMor.enums.TipoEvento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf= Persistence.createEntityManagerFactory("U4-W3-D3");

    public static void main(String[] args) {
        EntityManager em= emf.createEntityManager();

        EventiDAO ed= new EventiDAO(em);
        PersonaDAO personaDAO = new PersonaDAO(em);
        LocationDAO locationDAO = new LocationDAO(em);
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(em);

        LocalDate date1= LocalDate.of(2025,07,01);
        Evento num1= new Evento("Raccolta di beneficenza", date1,"Raccolta fondi per ricerca sul cancro", TipoEvento.BENEFICENZA,200);
        ed.save(num1);
        Evento num2= new Evento("Partita Champions", date1.plusDays(15),"Finale Champions", TipoEvento.SPORTIVO,60000);
        ed.save(num2);
        Evento num3= new Evento("Cena Aziendale", date1.minusDays(30),"Cena Aziendale con i boss", TipoEvento.LAVORO,25);
        ed.save(num3);

        // Creazione e salvataggio di una location
        Location location = new Location("Palazzo Congressi", "Roma");
        locationDAO.save(location);

        // Creazione e salvataggio di una persona
        Persona persona = new Persona("Mario", "Rossi", "mario.rossi@email.it", LocalDate.of(1990, 5, 20), Sesso.M);
        personaDAO.save(persona);

        // Creazione e salvataggio di un evento associato alla location
        Evento evento = new Evento("Conferenza Java", LocalDate.of(2025, 10, 10), "Evento su Java e Spring", TipoEvento.FESTA, 300, location);
        ed.save(evento);

        // Creazione e salvataggio di una partecipazione della persona all'evento
        Partecipazione partecipazione = new Partecipazione(persona, evento, Stato.CONFERMATA);
        partecipazioneDAO.save(partecipazione);
    }
}
