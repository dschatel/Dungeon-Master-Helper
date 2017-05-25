package falc.dungeonmasterhelper.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import falc.dungeonmasterhelper.R;
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

        monsterList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                viewMonster(i);
            }
        });

        monsterList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                editOrDelete(i);
                return true;
            }
        });

        addMonster = (Button) findViewById(R.id.add_monster);
        addMonster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addMonster();
            }
        });
    }


    private void editOrDelete(final int pos) {
        CharSequence editOrDelete[] = new CharSequence[] {"Edit", "Delete"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose an Option");
        builder.setItems(editOrDelete, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 1) {
                    monsters.remove(pos);
                    updateMonsterList();
                }
                else if (i == 0) {
                    editMonster(pos);
                }


            }
        });
        builder.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    private void updateMonsterList() {

        monsterList.setAdapter(new ArrayAdapter<Monster>(this, R.layout.monster, monsters));

        try {
            saveToFile(monsters);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        intent.putExtra("requestCode", 1);
        startActivityForResult(intent, 1);
    }

    private void editMonster(int pos) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("Monster", monsters.get(pos));
        Intent intent = new Intent(this, Add_Edit_Monster.class);
        intent.putExtras(bundle);
        intent.putExtra("requestCode", 2);
        intent.putExtra("Position", pos);
        startActivityForResult(intent, 2);
    }

    private void viewMonster(int position) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("Monster", monsters.get(position));

        Intent intent = new Intent(this, View_Monster.class);
        intent.putExtras(bundle);

        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {

        Bundle bundle = intent.getExtras();

        if (resultCode != RESULT_OK) return;

        if (requestCode == 1) {
            Monster monster = bundle.getParcelable("NewMonster");
            monsters.add(monster);
        }
        else if(requestCode == 2) {
            Monster monster = bundle.getParcelable("NewMonster");
            int pos = intent.getExtras().getInt("Position");
            monsters.set(pos, monster);

        }

        monsterList.setAdapter(new ArrayAdapter<Monster>(this, R.layout.monster, monsters));

        try {
            saveToFile(monsters);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
