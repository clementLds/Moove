package fr.insa.moove.bdd.clients;

import java.util.Date;
import java.util.UUID;

public interface ClientAccount {

    public UUID getUUID();

    public String getFirstName();

    public String getFamilyName();

    public Date getBirthDay();

    public ClientBalance getBalance();

}
