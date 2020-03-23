package fr.insa.moove.bdd;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import fr.insa.moove.bdd.clients.ClientAccount;
import fr.insa.moove.bdd.clients.ClientNotFoundException;
import fr.insa.moove.bdd.clients.TestClient;
import fr.insa.moove.bdd.jo.JoEvent;
import fr.insa.moove.bdd.jo.JoLocation;

public class TestDataBase implements DataBase {

    private Set<JoLocation> locations;
    private Map<UUID, ClientAccount> clients;

    private final UUID current;
    public TestDataBase(UUID current) {
        this.current = current;
        locations = new HashSet<>();
        clients = new HashMap<>();
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
        return !clients.isEmpty();
    }

    @Override
    public boolean connect() {
        locations.add(new JoLocation("Stade",1, "3 rue du Parc fleuri", 10000));
        locations.add(new JoLocation("Parc",2, "123 avenue Michel", 2000));
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();
        clients.put(id1, new TestClient(id1, "Paul Dupont"));
        clients.put(id2, new TestClient(id2, "Camille Plaza"));
        ClientAccount account = new TestClient(current, "Jean Test");
        clients.put(current, account);
        account.registerPresence(new JoEvent() {
            @Override
            public String getDescription() {
                return "France 89 - 75 Espagne";
            }

            @Override
            public String getName() {
                return "Basket";
            }

            @Override
            public String getSport() {
                return "Basket";
            }

            @Override
            public JoLocation getLocation() {
                return locations.iterator().next();
            }

            @Override
            public Date getDate() {
                return new Date(System.currentTimeMillis());
            }
        });



        return true;
    }

    @Override
    public boolean disconnect() {
        clients.clear();
        locations.clear();
        return true;
    }
}
