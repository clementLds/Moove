package fr.insa.moove.bdd.clients;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

import fr.insa.moove.bdd.jo.JoEvent;

public interface ClientAccount {

    public UUID getUUID();

    public String getFirstName();

    public String getFamilyName();

    public Date getBirthDay();

    public ClientBalance getBalance();

    public Set<JoEvent> getAllEvents();

    public JoEvent getFutureEvent();

    public boolean registerPresence(JoEvent event);

}