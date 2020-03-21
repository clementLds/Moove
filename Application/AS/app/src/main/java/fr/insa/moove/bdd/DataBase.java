package fr.insa.moove.bdd;

import java.util.Set;
import java.util.UUID;

import fr.insa.moove.bdd.clients.ClientAccount;
import fr.insa.moove.bdd.jo.JoLocation;

public interface DataBase {

    public ClientAccount getAccountWithUUID(UUID uuid);

    public Set<JoLocation> getLocations();

    public boolean isConnected();

    public boolean connect();

    public boolean disconnect();

}
