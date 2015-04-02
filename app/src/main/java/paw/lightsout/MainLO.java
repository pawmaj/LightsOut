package paw.lightsout;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;


public class MainLO extends ActionBarActivity implements View.OnClickListener {
    LinkedList<HashSet> couples;
    LinkedList<ToggleButton> buttons;
    Iterator bi;
    private ToggleButton ib1;
    private ToggleButton ib2;
    private ToggleButton ib3;
    private ToggleButton ib4;
    private ToggleButton ib5;
    private ToggleButton ib6;
    private ToggleButton ib7;
    private ToggleButton ib8;
    private ToggleButton ib9;
    HashSet<ToggleButton> couple1;
    HashSet<ToggleButton> couple2;
    HashSet<ToggleButton> couple3;
    HashSet<ToggleButton> couple4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lo);
        couples = new LinkedList<HashSet>();
        ib1 = (ToggleButton) findViewById(R.id.toggleButton);
        ib2 = (ToggleButton) findViewById(R.id.toggleButton2);
        ib3 = (ToggleButton) findViewById(R.id.toggleButton3);
        ib4 = (ToggleButton) findViewById(R.id.toggleButton4);
        ib5 = (ToggleButton) findViewById(R.id.toggleButton5);
        ib6 = (ToggleButton) findViewById(R.id.toggleButton6);
        ib7 = (ToggleButton) findViewById(R.id.toggleButton7);
        ib8 = (ToggleButton) findViewById(R.id.toggleButton8);
        ib9 = (ToggleButton) findViewById(R.id.toggleButton9);

        ib1.setOnClickListener(this);
        ib2.setOnClickListener(this);
        ib3.setOnClickListener(this);
        ib4.setOnClickListener(this);
        ib5.setOnClickListener(this);
        ib6.setOnClickListener(this);
        ib7.setOnClickListener(this);
        ib8.setOnClickListener(this);
        ib9.setOnClickListener(this);

        couple1 = new HashSet<ToggleButton>();
        couple2 = new HashSet<ToggleButton>();
        couple3 = new HashSet<ToggleButton>();
        couple4 = new HashSet<ToggleButton>();

        buttons = new LinkedList<ToggleButton>();
        buttons.add(ib1);
        buttons.add(ib2);
        buttons.add(ib3);
        buttons.add(ib4);
        buttons.add(ib5);
        buttons.add(ib6);
        buttons.add(ib7);
        buttons.add(ib8);
        buttons.add(ib9);



        setUp();


    }


    @Override
    public void onClick(View v) {

        bi = buttons.iterator();
        ToggleButton currentButton;
        Iterator it = couples.iterator();
        while (it.hasNext()){
           HashSet<View> current = (HashSet<View>) it.next();
            if (current.contains(v)) {
                Iterator it2 = current.iterator();
                while (it2.hasNext()) {
                    currentButton = (ToggleButton) it2.next();
                    if (currentButton.equals(v)==false)
                    currentButton.toggle();
                }
            }

        }
        boolean przegrana = false;
        while(bi.hasNext()){

            ToggleButton current = (ToggleButton)bi.next();

            if(current.isChecked()==true){
                przegrana=true;
            }else{

            }
        }
        if (przegrana==false){
            Context context = getApplicationContext();
            CharSequence text = "Wygrałaś!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        }


    }

    private void setUp()
    {
        couples.clear();
        couple1.clear();
        couple2.clear();
        couple3.clear();
        couple4.clear();
            Random r = new Random();
            do {

                    int rInt = r.nextInt(9);
                    couple1.add(buttons.get(rInt));


            } while (couple1.size()<3 );

        do {

            int rInt = r.nextInt(9);
                couple2.add(buttons.get(rInt));


        } while (couple2.size()<3 );

        do {

            int rInt = r.nextInt(9);
                couple3.add(buttons.get(rInt));


        } while (couple3.size()<3 );
        do {

            int rInt = r.nextInt(9);
            couple4.add(buttons.get(rInt));


        } while (couple4.size()<3 );
        couples.add(couple1);
        couples.add(couple2);
        couples.add(couple3);
        couples.add(couple4);

            onClick(ib1);
            ib1.toggle();
            onClick(ib3);
            ib3.toggle();
            onClick(ib7);
            ib7.toggle();
            onClick(ib9);
            ib9.toggle();
        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater blowUp = getMenuInflater();
        blowUp.inflate(R.menu.menu_main_lo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.nowa_gra:
                setUp();
                break;
            case R.id.zamknij:
            finish();
            break;
        }
        return false;
    }
}
