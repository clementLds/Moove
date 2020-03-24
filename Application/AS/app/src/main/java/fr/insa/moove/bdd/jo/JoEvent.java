package fr.insa.moove.bdd.jo;

import java.util.Date;

public interface JoEvent {

    public String getDescription();

    public String getName();

    public String getSport();

    public JoLocation getLocation();

    public Date getDate();

}
