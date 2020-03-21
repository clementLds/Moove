package fr.insa.moove;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import fr.insa.moove.bdd.DataBase;
import fr.insa.moove.bdd.clients.ClientAccount;
import fr.insa.moove.bdd.clients.ClientNotFoundException;
import fr.insa.moove.bdd.clients.TestClient;
import fr.insa.moove.bdd.jo.JoLocation;

public class TestDataBase implements DataBase {

    private Set<JoLocation> locations;

    private Map<UUID, ClientAccount> clients;

    public TestDataBase() {
        locations = new HashSet<>();
        locations.add(new JoLocation("Stade",1, "3 rue du Parc fleuri", 10000));
        locations.add(new JoLocation("Parc",2, "123 avenue Michel", 2000));

        clients = new HashMap<>();
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();
        clients.put(id1, new TestClient(id1, "Jean Dupont"));
        clients.put(id2, new TestClient(id2, "Camille Plaza"));
    }

    @Override
    public ClientAccount getAccountWithUUID(UUID uuid) {
        if(clients.containsKey(uuid))
            return clients.get(uuid);
        throw new ClientNotFoundException("Client with UUID=["+uuid+"] does not exist.");
    }

    @Override
    public Set<JoLocation> getLocations() {
        return locations;
    }

    @Override
    public boolean isConnected() {
        return true;
    }

    @Override
    public boolean connect() {
        return true;
    }

    @Override
    public boolean disconnect() {
        return true;
    }
}
