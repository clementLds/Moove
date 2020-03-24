package fr.insa.moove.bdd.clients;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import fr.insa.moove.bdd.jo.JoEvent;

public class TestClient implements ClientAccount {

    private final ClientBalance balance;
    private final String name;
    private final UUID uuid;

    private final Set<JoEvent> events;
    public TestClient(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;
        balance = new ClientBalance(uuid);

        events = new HashSet<>();
    }

    @Override
    public UUID getUUID() {
        return uuid;
    }

    @Override
    public String getFirstName() {
        return name.split(" ")[0];
    }

    @Override
    public String getFamilyName() {
        return name.split(" ")[1];
    }

    @Override
    public Date getBirthDay() {
        return new Date(System.currentTimeMillis());
    }

    @Override
    public ClientBalance getBalance() {
        return balance;
    }

    @Override
    public Set<JoEvent> getAllEvents() {
        return events;
    }

    @Override
    public JoEvent getFutureEvent() {
        return events.iterator().next(); //Seulement pour le test
    }

    @Override
    public boolean registerPresence(JoEvent event) {
        events.add(event);
        return true;
    }
}
