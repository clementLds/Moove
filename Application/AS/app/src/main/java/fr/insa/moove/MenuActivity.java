package fr.insa.moove;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.UUID;

import fr.insa.moove.bdd.DataBase;
import fr.insa.moove.bdd.TestDataBase;
import fr.insa.moove.bdd.clients.ClientAccount;
import fr.insa.moove.bdd.jo.JoEvent;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * Database data
     */
    private DataBase bdd;
    private ClientAccount client;

    /**
     * Fields to modify
     */
    TextView textFutureL1, textFutureL2;

    private final static UUID clientUUID = UUID.randomUUID();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_menu);

        connectDataBase();
        getViewsFields();
        updateFutureEvents();
    }

    /**
     * Connect to the database and get the #client field
     */
    private void connectDataBase() {
        bdd = new TestDataBase(clientUUID);
        bdd.connect();
        client = bdd.getAccountWithUUID(clientUUID);
    }

    /**
     * get views fields
     */
    private void getViewsFields() {
        textFutureL1 = findViewById(R.id.futureEvent1);
        textFutureL2 = findViewById(R.id.futureEvent2);
    }

    /**
     * Update the "future event" TextViews
     */
    public void updateFutureEvents() {
        JoEvent event = client.getFutureEvent();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM");
        textFutureL1.setText(event.getSport() + "  -  " + formatter.format(event.getDate()));
        textFutureL2.setText(event.getDescription());
    }

    @Override
    public void onClick(View view) {
        Log.d("MOOVE","Click");
        switch (view.getId()) {
            case R.id.menuButton:
                //TODO click sur menuButton
                Log.d("MOOVE","Click on menu");
                break;
            case R.id.buttonTL:
                //TODO Rechercher un horaire
                Log.d("MOOVE","Click on TL");
                break;
            case R.id.buttonTR:
                //TODO Reserver un billet
                Log.d("MOOVE","Click on TR");
                break;
            case R.id.buttonBL:
                //TODO Calendrier évenementiel
                Log.d("MOOVE","Click on BL");
                break;
            case R.id.buttonBR:
                //TODO Consulter mes billets
                Log.d("MOOVE","Click on BR");
                break;
        }
    }
}