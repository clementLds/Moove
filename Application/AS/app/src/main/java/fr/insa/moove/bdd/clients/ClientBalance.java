package fr.insa.moove.bdd.clients;

import java.util.UUID;

public class ClientBalance {

    private double balance;

    private final UUID client;
    public ClientBalance(UUID client) {
        this.client = client;
    }

    public double getCurrentBalance() {
        synchronized (client) {
            return balance;
        }
    }

    public UUID getClientId() {
        return client;
    }

    public boolean canAfford(double price) {
        synchronized (client) {
            return balance >= price;
        }
    }

    public void deltaBalance(double balance) {
        synchronized (client) {
            this.balance += balance;
        }
    }

}
