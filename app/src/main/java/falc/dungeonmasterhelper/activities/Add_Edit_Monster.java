package falc.dungeonmasterhelper.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.util.ArrayList;

import falc.dungeonmasterhelper.R;
import falc.dungeonmasterhelper.model.Monster.Monster;
import falc.dungeonmasterhelper.model.Monster.MonsterProperties.Ability;
import falc.dungeonmasterhelper.model.Monster.MonsterProperties.MovementType;
import falc.dungeonmasterhelper.model.Monster.MonsterProperties.SavingThrow;
import falc.dungeonmasterhelper.model.Monster.MonsterProperties.Sense;
import falc.dungeonmasterhelper.model.Monster.MonsterProperties.Skill;
import falc.dungeonmasterhelper.model.Monster.MonsterProperties.Trait;

public class Add_Edit_Monster extends AppCompatActivity {

    Monster monster;
    Spinner size;
    Spinner type;
    Spinner alignment;
    EditText armorClass;
    EditText numDice;
    EditText diceType;
    EditText extraHP;
    TableLayout speedTable;
    TableLayout saveTable;
    TableLayout skillTable;
    TableLayout damResistTable;
    TableLayout damImmuneTable;
    TableLayout condImmuneable;
    TableLayout senseTable;
    TableLayout languageTable;
    EditText monsterName;
    EditText strength;
    EditText dexterity;
    EditText constitution;
    EditText intelligence;
    EditText wisdom;
    EditText charisma;
    CheckBox legendary;
    CheckBox lair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_edit_monster);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        size = (Spinner) findViewById(R.id.sizeentry);
        type = (Spinner) findViewById(R.id.typeentry);
        alignment = (Spinner) findViewById(R.id.alignmententry);
        armorClass = (EditText) findViewById(R.id.armorclass);
        numDice = (EditText) findViewById(R.id.numdice);
        diceType = (EditText) findViewById(R.id.dicetype);
        extraHP = (EditText) findViewById(R.id.extrahp);
        speedTable = (TableLayout) findViewById(R.id.speedtable);
        saveTable = (TableLayout) findViewById(R.id.savingthrowtable);
        skillTable = (TableLayout) findViewById(R.id.skilltable);
        damResistTable = (TableLayout) findViewById(R.id.damresisttable);
        damImmuneTable = (TableLayout) findViewById(R.id.damimmunetable);
        condImmuneable = (TableLayout) findViewById(R.id.condimmunetable);
        senseTable = (TableLayout) findViewById(R.id.sensestable);
        languageTable = (TableLayout) findViewById(R.id.languagetable);
        monsterName = (EditText) findViewById(R.id.monsternameentry);
        strength = (EditText) findViewById(R.id.strength);
        dexterity = (EditText) findViewById(R.id.dexterity);
        constitution = (EditText) findViewById(R.id.constitution);
        intelligence = (EditText) findViewById(R.id.intelligence);
        wisdom = (EditText) findViewById(R.id.wisdom);
        charisma = (EditText) findViewById(R.id.charisma);
        legendary = (CheckBox) findViewById(R.id.legendary_checkbox);
        lair = (CheckBox) findViewById(R.id.lair_checkbox);

        addSpeed();
        addSavingThrow();
        addDamResist();
        addSkill();
        addDamImmunity();
        addCondImmunity();
        addSense();
        addLanguage();
        createMonster();

        if(getIntent().getExtras().getInt("requestCode") == 1)
            monster = null;
        else {
            Bundle bundle = this.getIntent().getExtras();
            monster = bundle.getParcelable("Monster");
            enterInfo();
        }

        if (monster == null)
            Toast.makeText(this, "Adding new monster!", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, "Editing monster!", Toast.LENGTH_LONG).show();



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

    private void createTableRow(int tableID, int spinnerID, int typeOfRow, String hint) {

                TableRow row = new TableRow(Add_Edit_Monster.this);
                Spinner mSpinner = new Spinner(Add_Edit_Monster.this);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(Add_Edit_Monster.this, spinnerID, android.R.layout.simple_spinner_dropdown_item);
                mSpinner.setAdapter(adapter);
                row.addView(mSpinner);
                if(typeOfRow == 0) {
                    EditText mText = new EditText(Add_Edit_Monster.this);
                    mText.setHint(hint);
                    row.addView(mText);
                }
                Button deleteRow = new Button(Add_Edit_Monster.this);
                deleteRow.setBackgroundColor(getColor(R.color.colorInk));
                deleteRow.setTextColor(getColor(R.color.colorWhite));
                deleteRow.setText("-");
                row.addView(deleteRow);
                TableLayout speedTable = (TableLayout) findViewById(tableID);
                speedTable.addView(row);
                final float scale = getResources().getDisplayMetrics().density;
                int heightDp = (int) (20 * scale + 0.5f);
                ViewGroup.LayoutParams params = deleteRow.getLayoutParams();
                params.height = heightDp;
                params.width = heightDp;
                deleteRow.setPadding(5, 5, 5, 5);
                deleteRow.setGravity(Gravity.CENTER);
                deleteRow.setLayoutParams(params);
                deleteRow.requestLayout();
                speedTable.requestLayout();
                deleteRow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        View row = (View) view.getParent();
                        ViewGroup container = ((ViewGroup)row.getParent());
                        container.removeView(row);
                        container.invalidate();
                    }
                });
    }

    private void addDamResist() {

        Button addSpeed = (Button) findViewById(R.id.add_damresist);
        addSpeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createTableRow(R.id.damresisttable, R.array.damage_types, 1, "None");
            }
        });

    }

    private void addDamImmunity() {

        Button addSpeed = (Button) findViewById(R.id.add_damimmunity);
        addSpeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createTableRow(R.id.damimmunetable, R.array.damage_types, 1, "None");
            }
        });

    }

    private void addCondImmunity() {

        Button addSpeed = (Button) findViewById(R.id.add_condimmunity);
        addSpeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createTableRow(R.id.condimmunetable, R.array.conditions, 1, "None");
            }
        });

    }

    private void addLanguage() {

        Button addLanguage = (Button) findViewById(R.id.add_language);
        addLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createTableRow(R.id.languagetable, R.array.languages, 1, "None");
            }
        });

    }

    private void addSense() {

        Button addSense = (Button) findViewById(R.id.add_sense);
        addSense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createTableRow(R.id.sensestable, R.array.senses, 0, "Enter Range");
            }
        });

    }

    private void addSkill() {

        Button addSpeed = (Button) findViewById(R.id.add_skill);
        addSpeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createTableRow(R.id.skilltable, R.array.skills, 0, "Enter Bonus");
            }
        });

    }


    private void addSavingThrow() {

        Button addSpeed = (Button) findViewById(R.id.add_savingthrow);
        addSpeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createTableRow(R.id.savingthrowtable, R.array.saving_throws, 0, "Enter Bonus");
            }
        });

    }

    private void addSpeed() {

        Button addSpeed = (Button) findViewById(R.id.add_speed);
        addSpeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createTableRow(R.id.speedtable, R.array.speed_types, 0, "Enter Speed");
            }
        });

    }

    private void enterInfo() {

        monsterName.setText(monster.getMonsterName());
        size.setSelection(getSpinnerIndex(size, monster.getSize()));
        type.setSelection(getSpinnerIndex(type, monster.getType()));
        alignment.setSelection(getSpinnerIndex(alignment, monster.getAlignment()));
        armorClass.setText(Integer.toString(monster.getArmorClass()));
        numDice.setText(Integer.toString(monster.getNumHitDice()));
        diceType.setText(Integer.toString(monster.getHitDiceType()));
        extraHP.setText(Integer.toString(monster.getExtraHP()));
        addTable(speedTable, R.array.speed_types, 0, "Enter Speed", 0);
        strength.setText(Integer.toString(monster.getAbilityScores().get(0).getValue()));
        dexterity.setText(Integer.toString(monster.getAbilityScores().get(1).getValue()));
        constitution.setText(Integer.toString(monster.getAbilityScores().get(2).getValue()));
        intelligence.setText(Integer.toString(monster.getAbilityScores().get(3).getValue()));
        wisdom.setText(Integer.toString(monster.getAbilityScores().get(4).getValue()));
        charisma.setText(Integer.toString(monster.getAbilityScores().get(5).getValue()));
        addTable(saveTable, R.array.saving_throws, 0, "Enter Bonus", 1);
        addTable(skillTable, R.array.skills, 0, "Enter Bonus", 2);
        addTable(damResistTable, R.array.damage_types, 1, "None", 3);
        addTable(damImmuneTable, R.array.damage_types, 1, "None", 4);
        addTable(condImmuneable, R.array.conditions, 1, "None", 5);
        addTable(senseTable, R.array.senses, 0, "Enter Range", 6);
        addTable(languageTable, R.array.languages, 1, "None", 7);
        if(monster.getIsLegendary() == true)
            legendary.setChecked(true);
        else
            legendary.setChecked(false);
        if(monster.getHasLair() == true)
            lair.setChecked(true);
        else
            lair.setChecked(false);

    }

    private void addTable(TableLayout table, int spinnerID, int type, String hint, int tableType) {

        switch(tableType) {
            case 0: //speed
                for (MovementType m: monster.getMovementList()) {
                    addTableRow(table, spinnerID, type, hint, m, "");
                }
                break;
            case 1: //Saving throws
                for (SavingThrow s: monster.getSavingThrowList()) {
                    addTableRow(table, spinnerID, type, hint, s, "");
                }
                break;
            case 2: //Skills
                for (Skill s: monster.getSkillList()) {
                    addTableRow(table, spinnerID, type, hint, s, "");
                }
                break;
            case 3: //Dam Resist
                for (String s: monster.getDamResistList()) {
                    addTableRow(table, spinnerID, type, hint, new Trait(), s);
                }
                break;
            case 4: //Dam Immune
                for (String s: monster.getDamImmuneList()) {
                    addTableRow(table, spinnerID, type, hint, new Trait(), s);
                }
                break;
            case 5: //Cond Immune
                for (String s: monster.getCondImmuneList()) {
                    addTableRow(table, spinnerID, type, hint, new Trait(), s);
                }
                break;
            case 6: //Senses
                for (Sense s: monster.getSensesList()) {
                    addTableRow(table, spinnerID, type, hint, s, "");
                }
                break;
            case 7: //Languages
                for (String s: monster.getLanguageList()) {
                    addTableRow(table, spinnerID, type, hint, new Trait(), s);
                }
                break;
        }

    }

    private void addTableRow(TableLayout table, int spinnerID, int type, String hint, Trait t, String s) {

            TableRow row = new TableRow(Add_Edit_Monster.this);
            Spinner mSpinner = new Spinner(Add_Edit_Monster.this);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(Add_Edit_Monster.this, spinnerID, android.R.layout.simple_spinner_dropdown_item);
            mSpinner.setAdapter(adapter);
            if(type == 0)
                mSpinner.setSelection(getSpinnerIndex(mSpinner, t.getName()));
            else
                mSpinner.setSelection(getSpinnerIndex(mSpinner, s));
            row.addView(mSpinner);
            if(type == 0) {
                EditText mText = new EditText(Add_Edit_Monster.this);
                mText.setHint(hint);
                mText.setText(Integer.toString(t.getValue()));
                row.addView(mText);
            }
            Button deleteRow = new Button(Add_Edit_Monster.this);
            deleteRow.setBackgroundColor(getColor(R.color.colorInk));
            deleteRow.setTextColor(getColor(R.color.colorWhite));
            deleteRow.setText("-");
            row.addView(deleteRow);
            table.addView(row);
            final float scale = getResources().getDisplayMetrics().density;
            int heightDp = (int) (20 * scale + 0.5f);
            ViewGroup.LayoutParams params = deleteRow.getLayoutParams();
            params.height = heightDp;
            params.width = heightDp;
            deleteRow.setPadding(5, 5, 5, 5);
            deleteRow.setGravity(Gravity.CENTER);
            deleteRow.setLayoutParams(params);
            deleteRow.requestLayout();
            table.requestLayout();
            deleteRow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    View row = (View) view.getParent();
                    ViewGroup container = ((ViewGroup) row.getParent());
                    container.removeView(row);
                    container.invalidate();
                }
            });

    }

    private int getSpinnerIndex(Spinner spinner, String string) {
        int index = 0;

        for (int i = 0; i < spinner.getCount(); i++) {
            if (spinner.getItemAtPosition(i).toString().equalsIgnoreCase(string)) {
                index = i;
                break;
            }
        }
        return index;
    }

    private void createMonster() {
        Button save = (Button) findViewById(R.id.save_monster);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(monster == null)
                    monster = new Monster(monsterName.getText().toString());
                else
                    monster.setMonsterName(monsterName.getText().toString());

                monster.setSize(size.getSelectedItem().toString());
                monster.setType(type.getSelectedItem().toString());
                monster.setAlignment(alignment.getSelectedItem().toString());


                monster.setArmorClass(Integer.parseInt(armorClass.getText().toString()));
                monster.setNumHitDice(Integer.parseInt(numDice.getText().toString()));
                monster.setHitDiceType(Integer.parseInt(diceType.getText().toString()));
                monster.setExtraHP(Integer.parseInt(extraHP.getText().toString()));

                ArrayList<MovementType> speedList = new ArrayList<MovementType>();

                for (int i = 0; i < speedTable.getChildCount(); i++) {
                    View child = speedTable.getChildAt(i);

                    if (child instanceof TableRow) {
                        TableRow row = (TableRow) child;
                        MovementType newMovement = new MovementType();

                        for (int j = 0; j < row.getChildCount(); j++) {
                            View v = row.getChildAt(j);

                            if (v instanceof Spinner)
                                newMovement.setMovementName(((Spinner) v).getSelectedItem().toString());
                            if (v instanceof EditText)
                                newMovement.setMovementAmount(Integer.parseInt(((EditText) v).getText().toString()));

                        }
                        speedList.add(newMovement);
                    }
                }

                monster.setMovementList(speedList);


                ArrayList<Ability> abilities = new ArrayList<Ability>();

                abilities.add(new Ability("Strength", Integer.parseInt(strength.getText().toString())));
                abilities.add(new Ability("Dexterity", Integer.parseInt(dexterity.getText().toString())));
                abilities.add(new Ability("Constitution", Integer.parseInt(constitution.getText().toString())));
                abilities.add(new Ability("Intelligence", Integer.parseInt(intelligence.getText().toString())));
                abilities.add(new Ability("Wisdom", Integer.parseInt(wisdom.getText().toString())));
                abilities.add(new Ability("Charisma", Integer.parseInt(charisma.getText().toString())));

                monster.setAbilityScores(abilities);

                //Parse saving throw table
                ArrayList<SavingThrow> saveList = new ArrayList<SavingThrow>();
                for (int i = 0; i < saveTable.getChildCount(); i++) {
                    View child = saveTable.getChildAt(i);

                    if (child instanceof TableRow) {
                        TableRow row = (TableRow) child;
                        SavingThrow newSave = new SavingThrow();

                        for (int j = 0; j < row.getChildCount(); j++) {
                            View v = row.getChildAt(j);

                            if (v instanceof Spinner)
                                newSave.setSave(((Spinner) v).getSelectedItem().toString());
                            if (v instanceof EditText)
                                newSave.setBonus(Integer.parseInt(((EditText) v).getText().toString()));

                        }
                        saveList.add(newSave);
                    }
                }
                monster.setSavingThrowList(saveList);

                //Parse skill table
                ArrayList<Skill> skillList = new ArrayList<Skill>();
                for (int i = 0; i < skillTable.getChildCount(); i++) {
                    View child = skillTable.getChildAt(i);

                    if (child instanceof TableRow) {
                        TableRow row = (TableRow) child;
                        Skill newSkill = new Skill();

                        for (int j = 0; j < row.getChildCount(); j++) {
                            View v = row.getChildAt(j);

                            if (v instanceof Spinner)
                                newSkill.setSkillName(((Spinner) v).getSelectedItem().toString());
                            if (v instanceof EditText)
                                newSkill.setSkillBonus(Integer.parseInt(((EditText) v).getText().toString()));

                        }
                        skillList.add(newSkill);
                    }
                }
                monster.setSkillList(skillList);

                //Parse dam resist table
                ArrayList<String> damResistList = new ArrayList<String>();
                for (int i = 0; i < damResistTable.getChildCount(); i++) {
                    View child = damResistTable.getChildAt(i);

                    if (child instanceof TableRow) {
                        TableRow row = (TableRow) child;

                        for (int j = 0; j < row.getChildCount(); j++) {
                            View v = row.getChildAt(j);

                            if (v instanceof Spinner)
                                damResistList.add(((Spinner) v).getSelectedItem().toString());

                        }
                    }
                }

                monster.setDamResistList(damResistList);

                //Parse dam immune table
                ArrayList<String> damImmuneList = new ArrayList<String>();
                for (int i = 0; i < damImmuneTable.getChildCount(); i++) {
                    View child = damImmuneTable.getChildAt(i);

                    if (child instanceof TableRow) {
                        TableRow row = (TableRow) child;

                        for (int j = 0; j < row.getChildCount(); j++) {
                            View v = row.getChildAt(j);

                            if (v instanceof Spinner)
                                damImmuneList.add(((Spinner) v).getSelectedItem().toString());

                        }
                    }
                }

                monster.setDamImmuneList(damImmuneList);


                //Parse cond immune table
                ArrayList<String> condImmuneList = new ArrayList<String>();
                for (int i = 0; i < condImmuneable.getChildCount(); i++) {
                    View child = condImmuneable.getChildAt(i);

                    if (child instanceof TableRow) {
                        TableRow row = (TableRow) child;

                        for (int j = 0; j < row.getChildCount(); j++) {
                            View v = row.getChildAt(j);

                            if (v instanceof Spinner)
                               condImmuneList.add(((Spinner) v).getSelectedItem().toString());

                        }
                    }
                }

                monster.setCondImmuneList(condImmuneList);


                //Parse sense table
                ArrayList<Sense> senseList = new ArrayList<Sense>();
                for (int i = 0; i < senseTable.getChildCount(); i++) {
                    View child = senseTable.getChildAt(i);

                    if (child instanceof TableRow) {
                        TableRow row = (TableRow) child;
                        Sense newSense = new Sense();

                        for (int j = 0; j < row.getChildCount(); j++) {
                            View v = row.getChildAt(j);

                            if (v instanceof Spinner)
                                newSense.setSenseName(((Spinner) v).getSelectedItem().toString());
                            if (v instanceof EditText)
                                newSense.setSenseRange(Integer.parseInt(((EditText) v).getText().toString()));

                        }
                        senseList.add(newSense);
                    }
                }

                monster.setSenseList(senseList);

                //Parse language table
                ArrayList<String> languageList = new ArrayList<String>();
                for (int i = 0; i < languageTable.getChildCount(); i++) {
                    View child = languageTable.getChildAt(i);

                    if (child instanceof TableRow) {
                        TableRow row = (TableRow) child;

                        for (int j = 0; j < row.getChildCount(); j++) {
                            View v = row.getChildAt(j);

                            if (v instanceof Spinner)
                                languageList.add(((Spinner) v).getSelectedItem().toString());

                        }
                    }
                }

                monster.setLanguageList(languageList);

                if (legendary.isChecked())
                    monster.setIsLegendary(true);
                else
                    monster.setIsLegendary(false);
                if(lair.isChecked())
                    monster.setHasLair(true);
                else
                    monster.setHasLair(false);

                Bundle bundle = new Bundle();
                bundle.putParcelable("NewMonster", monster);

                Intent intent = new Intent();
                intent.putExtras(bundle);
                if (getIntent().getExtras().getInt("requestCode") == 2)
                    intent.putExtra("Position", getIntent().getExtras().getInt("Position"));

                setResult(RESULT_OK, intent);
                finish();

            }
        });
    }
}
