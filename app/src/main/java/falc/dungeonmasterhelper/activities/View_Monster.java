package falc.dungeonmasterhelper.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import falc.dungeonmasterhelper.R;
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
        TextView savingThrows = (TextView) findViewById(R.id.savingthrows);
        TextView savingThrowTag = (TextView) findViewById(R.id.savingtag);
        TextView skills = (TextView) findViewById(R.id.skills);
        TextView skillTag = (TextView) findViewById(R.id.skilltag);
        TextView damResist = (TextView) findViewById(R.id.damresistance);
        TextView damResistTag = (TextView) findViewById(R.id.damresisttag);
        TextView damImmune = (TextView) findViewById(R.id.damimmunities);
        TextView damImmuneTag = (TextView) findViewById(R.id.damimmunetag);
        TextView condImmune = (TextView) findViewById(R.id.condimmunities);
        TextView condImmuneTag = (TextView) findViewById(R.id.condimmunetag);
        TextView senses = (TextView) findViewById(R.id.senses);
        TextView senseTag = (TextView) findViewById(R.id.sensestag);
        TextView languages = (TextView) findViewById(R.id.languages);
        TextView languageTag = (TextView) findViewById(R.id.languagetag);
        TextView challengeRating = (TextView) findViewById(R.id.challengerating);
        TextView legendaryHeader = (TextView) findViewById(R.id.legendaryactiontag);
        View legendaryDivider = (View) findViewById(R.id.legendaryactionbar);
        ListView legendaryActions = (ListView) findViewById(R.id.legendaryactions);
        TextView lairHeader = (TextView) findViewById(R.id.lairactiontag);
        View lairDivider = (View) findViewById(R.id.lairactionbar);
        ListView lairActions = (ListView) findViewById(R.id.lairactions);
        ListView traits = (ListView) findViewById(R.id.traits);
        ListView actions = (ListView) findViewById(R.id.actions);


        if (monster.getIsLegendary() == false) {
            legendaryHeader.setVisibility(View.GONE);
            legendaryDivider.setVisibility(View.GONE);
            legendaryActions.setVisibility(View.GONE);
        }

        if(monster.getHasLair() == false) {
            lairHeader.setVisibility(View.GONE);
            lairDivider.setVisibility(View.GONE);
            lairActions.setVisibility(View.GONE);
        }



        name.setText(monster.getMonsterName());
        sizetypeandalignment.setText(monster.getSizeTypeAlignment());
        armorClass.setText(Integer.toString(monster.getArmorClass()));
        hitPoints.setText(monster.formatHitPoints());
        str.setText(Integer.toString(monster.getAbilityScores().get(0).getValue()));
        dex.setText(Integer.toString(monster.getAbilityScores().get(1).getValue()));
        con.setText(Integer.toString(monster.getAbilityScores().get(2).getValue()));
        intelligence.setText(Integer.toString(monster.getAbilityScores().get(3).getValue()));
        wis.setText(Integer.toString(monster.getAbilityScores().get(4).getValue()));
        cha.setText(Integer.toString(monster.getAbilityScores().get(5).getValue()));
        speed.setText(monster.getMovement());

        if (monster.getSavingThrows().equals("None")) {
            savingThrowTag.setVisibility(View.GONE);
            savingThrows.setVisibility(View.GONE);
        }
        else
            savingThrows.setText(monster.getSavingThrows());

        if (monster.getSkills().equals("None")) {
            skillTag.setVisibility(View.GONE);
            skills.setVisibility(View.GONE);
        }
        else
            skills.setText(monster.getSkills());

        if (monster.getDamResist().equals("None")) {
            damResistTag.setVisibility(View.GONE);
            damResist.setVisibility(View.GONE);
        }
        else
            damResist.setText(monster.getDamResist());

        if (monster.getDamImmunities().equals("None")) {
            damImmuneTag.setVisibility(View.GONE);
            damImmune.setVisibility(View.GONE);
        }
        else
            damImmune.setText(monster.getDamImmunities());

        if (monster.getCondImmunities().equals("None")) {
            condImmuneTag.setVisibility(View.GONE);
            condImmune.setVisibility(View.GONE);
        }
        else
            condImmune.setText(monster.getCondImmunities());

        if (monster.getSenses().equals("None")) {
            senseTag.setVisibility(View.GONE);
            senses.setVisibility(View.GONE);
        }
        else
            senses.setText(monster.getSenses());

        if (monster.getLanguages().equals("None")) {
            languageTag.setVisibility(View.GONE);
            languages.setVisibility(View.GONE);
        }
        else
            languages.setText(monster.getLanguages());


    }

}
