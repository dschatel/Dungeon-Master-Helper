package falc.dungeonmasterhelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import falc.dungeonmasterhelper.model.Monster.Monster;

public class Homebrew_List extends AppCompatActivity implements Serializable {

    private ArrayList<Monster> monsters;
    private ArrayList<ArrayList> homeBrewList;
    private ListView monsterList;
    Button addMonster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homebrew_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        monsters = new ArrayList<Monster>();

        try {
            monsters = readFromFile();
        } catch (IOException | ClassNotFoundException e) {
            try {
                saveToFile(monsters);
            } catch (IOException el) {
                el.printStackTrace();
            }
        }

        monsterList = (ListView) findViewById(R.id.monsterlist);
        monsterList.setAdapter(new ArrayAdapter<Monster>(this, R.layout.monster, monsters));

        addMonster = (Button) findViewById(R.id.add_monster);
        addMonster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addMonster();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void saveToFile(ArrayList<Monster> list) throws IOException {
        FileOutputStream fileOut = openFileOutput("homebrewlist.dat", MODE_PRIVATE);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(list);
        out.close();
        fileOut.close();
    }

    private ArrayList<Monster> readFromFile() throws IOException, ClassNotFoundException {
        FileInputStream fileIn = openFileInput("homebrewlist.dat");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        ArrayList<Monster> homebrewList = (ArrayList) in.readObject();
        in.close();
        fileIn.close();
        return homebrewList;
    }

    private void addMonster() {
        Intent intent = new Intent(this, Add_Edit_Monster.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {

        Bundle bundle = intent.getExtras();

        if (resultCode != RESULT_OK) return;

        if (requestCode == 1) {
            Monster monster = bundle.getParcelable("NewMonster");
            monsters.add(monster);

        }

        monsterList.setAdapter(new ArrayAdapter<Monster>(this, R.layout.monster, monsters));

        try {
            saveToFile(monsters);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
