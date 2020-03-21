package fr.insa.moove.bdd.clients;

import java.util.Date;
import java.util.UUID;

public class TestClient implements ClientAccount {

    private final ClientBalance balance;
    private final String name;
    private final UUID uuid;
    public TestClient(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;
        balance = new ClientBalance(uuid);
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
}
