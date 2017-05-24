package falc.dungeonmasterhelper;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import falc.dungeonmasterhelper.model.Monster.Monster;

public class View_Monster extends AppCompatActivity {

    private Monster monster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_monster);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle bundle = this.getIntent().getExtras();
        monster = bundle.getParcelable("Monster");
        displayMonster();

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

    private void displayMonster() {

        TextView name = (TextView) findViewById(R.id.monstername);
        TextView sizetypeandalignment = (TextView) findViewById(R.id.typeandalignment);
        TextView armorClass = (TextView) findViewById(R.id.armorclass);
        TextView hitPoints = (TextView) findViewById(R.id.hitpoints);
        TextView str = (TextView) findViewById(R.id.strength);
        TextView dex = (TextView) findViewById(R.id.dexterity);
        TextView con = (TextView) findViewById(R.id.constitution);
        TextView intelligence = (TextView) findViewById(R.id.intelligence);
        TextView wis = (TextView) findViewById(R.id.wisdom);
        TextView cha = (TextView) findViewById(R.id.charisma);
        TextView speed = (TextView) findViewById(R.id.speed);

        name.setText(monster.getMonsterName());
        sizetypeandalignment.setText(monster.getSizeTypeAlignment());
        armorClass.setText(Integer.toString(monster.getArmorClass()));
        hitPoints.setText(monster.formatHitPoints());
        str.setText(Integer.toString(monster.getAbilityScores().get(0).getAbilityScore()));
        dex.setText(Integer.toString(monster.getAbilityScores().get(1).getAbilityScore()));
        con.setText(Integer.toString(monster.getAbilityScores().get(2).getAbilityScore()));
        intelligence.setText(Integer.toString(monster.getAbilityScores().get(3).getAbilityScore()));
        wis.setText(Integer.toString(monster.getAbilityScores().get(4).getAbilityScore()));
        cha.setText(Integer.toString(monster.getAbilityScores().get(5).getAbilityScore()));
        speed.setText(monster.getMovement());



    }

}
