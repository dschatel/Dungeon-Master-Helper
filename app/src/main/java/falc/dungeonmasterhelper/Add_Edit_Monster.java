package falc.dungeonmasterhelper;

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

import falc.dungeonmasterhelper.model.Monster.Monster;
import falc.dungeonmasterhelper.model.Monster.MonsterProperties.Ability;
import falc.dungeonmasterhelper.model.Monster.MonsterProperties.MovementType;
import falc.dungeonmasterhelper.model.Monster.MonsterProperties.SavingThrow;
import falc.dungeonmasterhelper.model.Monster.MonsterProperties.Sense;
import falc.dungeonmasterhelper.model.Monster.MonsterProperties.Skill;

public class Add_Edit_Monster extends AppCompatActivity {

    Button savebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_edit_monster);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        addSpeed();
        addSavingThrow();
        addDamResist();
        addSkill();
        addDamImmunity();
        addCondImmunity();
        addSense();
        addLanguage();
        createMonster();

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

    private void addDamResist() {

        Button addSpeed = (Button) findViewById(R.id.add_damresist);
        addSpeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TableRow row = new TableRow(Add_Edit_Monster.this);
                Spinner damResistSpinner = new Spinner(Add_Edit_Monster.this);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(Add_Edit_Monster.this, R.array.damage_types, android.R.layout.simple_spinner_dropdown_item);
                damResistSpinner.setAdapter(adapter);
                row.addView(damResistSpinner);
                Button deleteRow = new Button(Add_Edit_Monster.this);
                deleteRow.setBackgroundColor(getColor(R.color.colorInk));
                deleteRow.setTextColor(getColor(R.color.colorWhite));
                deleteRow.setText("-");
                row.addView(deleteRow);
                TableLayout damResistTable = (TableLayout) findViewById(R.id.damresisttable);
                damResistTable.addView(row);
                final float scale = getResources().getDisplayMetrics().density;
                int heightDp = (int) (20 * scale + 0.5f);
                ViewGroup.LayoutParams params = deleteRow.getLayoutParams();
                params.height = heightDp;
                params.width = heightDp;
                deleteRow.setPadding(5, 5, 5, 5);
                deleteRow.setGravity(Gravity.CENTER);
                deleteRow.setLayoutParams(params);
                deleteRow.requestLayout();
                damResistTable.requestLayout();
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
        });

    }

    private void addDamImmunity() {

        Button addSpeed = (Button) findViewById(R.id.add_damimmunity);
        addSpeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TableRow row = new TableRow(Add_Edit_Monster.this);
                Spinner damImmuneSpinner = new Spinner(Add_Edit_Monster.this);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(Add_Edit_Monster.this, R.array.damage_types, android.R.layout.simple_spinner_dropdown_item);
                damImmuneSpinner.setAdapter(adapter);
                row.addView(damImmuneSpinner);
                Button deleteRow = new Button(Add_Edit_Monster.this);
                deleteRow.setBackgroundColor(getColor(R.color.colorInk));
                deleteRow.setTextColor(getColor(R.color.colorWhite));
                deleteRow.setText("-");
                row.addView(deleteRow);
                TableLayout damImmuneTable = (TableLayout) findViewById(R.id.damimmunetable);
                damImmuneTable.addView(row);
                final float scale = getResources().getDisplayMetrics().density;
                int heightDp = (int) (20 * scale + 0.5f);
                ViewGroup.LayoutParams params = deleteRow.getLayoutParams();
                params.height = heightDp;
                params.width = heightDp;
                deleteRow.setPadding(5, 5, 5, 5);
                deleteRow.setGravity(Gravity.CENTER);
                deleteRow.setLayoutParams(params);
                deleteRow.requestLayout();
                damImmuneTable.requestLayout();
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
        });

    }

    private void addCondImmunity() {

        Button addSpeed = (Button) findViewById(R.id.add_condimmunity);
        addSpeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TableRow row = new TableRow(Add_Edit_Monster.this);
                Spinner condImmuneSpinner = new Spinner(Add_Edit_Monster.this);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(Add_Edit_Monster.this, R.array.conditions, android.R.layout.simple_spinner_dropdown_item);
                condImmuneSpinner.setAdapter(adapter);
                row.addView(condImmuneSpinner);
                Button deleteRow = new Button(Add_Edit_Monster.this);
                deleteRow.setBackgroundColor(getColor(R.color.colorInk));
                deleteRow.setTextColor(getColor(R.color.colorWhite));
                deleteRow.setText("-");
                row.addView(deleteRow);
                TableLayout condImmuneTable = (TableLayout) findViewById(R.id.condimmunetable);
                condImmuneTable.addView(row);
                final float scale = getResources().getDisplayMetrics().density;
                int heightDp = (int) (20 * scale + 0.5f);
                ViewGroup.LayoutParams params = deleteRow.getLayoutParams();
                params.height = heightDp;
                params.width = heightDp;
                deleteRow.setPadding(5, 5, 5, 5);
                deleteRow.setGravity(Gravity.CENTER);
                deleteRow.setLayoutParams(params);
                deleteRow.requestLayout();
                condImmuneTable.requestLayout();
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
        });

    }

    private void addLanguage() {

        Button addLanguage = (Button) findViewById(R.id.add_language);
        addLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TableRow row = new TableRow(Add_Edit_Monster.this);
                Spinner languageSpinner = new Spinner(Add_Edit_Monster.this);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(Add_Edit_Monster.this, R.array.languages, android.R.layout.simple_spinner_dropdown_item);
                languageSpinner.setAdapter(adapter);
                row.addView(languageSpinner);
                Button deleteRow = new Button(Add_Edit_Monster.this);
                deleteRow.setBackgroundColor(getColor(R.color.colorInk));
                deleteRow.setTextColor(getColor(R.color.colorWhite));
                deleteRow.setText("-");
                row.addView(deleteRow);
                TableLayout languageTable = (TableLayout) findViewById(R.id.languagetable);
                languageTable.addView(row);
                final float scale = getResources().getDisplayMetrics().density;
                int heightDp = (int) (20 * scale + 0.5f);
                ViewGroup.LayoutParams params = deleteRow.getLayoutParams();
                params.height = heightDp;
                params.width = heightDp;
                deleteRow.setPadding(5, 5, 5, 5);
                deleteRow.setGravity(Gravity.CENTER);
                deleteRow.setLayoutParams(params);
                deleteRow.requestLayout();
                languageTable.requestLayout();
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
        });

    }

    private void addSense() {

        Button addSense = (Button) findViewById(R.id.add_sense);
        addSense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TableRow row = new TableRow(Add_Edit_Monster.this);
                Spinner senseSpinner = new Spinner(Add_Edit_Monster.this);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(Add_Edit_Monster.this, R.array.senses, android.R.layout.simple_spinner_dropdown_item);
                senseSpinner.setAdapter(adapter);
                row.addView(senseSpinner);
                EditText senseText = new EditText(Add_Edit_Monster.this);
                senseText.setHint("Enter Range");
                row.addView(senseText);
                Button deleteRow = new Button(Add_Edit_Monster.this);
                deleteRow.setBackgroundColor(getColor(R.color.colorInk));
                deleteRow.setTextColor(getColor(R.color.colorWhite));
                deleteRow.setText("-");
                row.addView(deleteRow);
                TableLayout senseTable = (TableLayout) findViewById(R.id.sensestable);
                senseTable.addView(row);
                final float scale = getResources().getDisplayMetrics().density;
                int heightDp = (int) (20 * scale + 0.5f);
                ViewGroup.LayoutParams params = deleteRow.getLayoutParams();
                params.height = heightDp;
                params.width = heightDp;
                deleteRow.setPadding(5, 5, 5, 5);
                deleteRow.setGravity(Gravity.CENTER);
                deleteRow.setLayoutParams(params);
                deleteRow.requestLayout();
                senseTable.requestLayout();
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
        });

    }

    private void addSkill() {

        Button addSpeed = (Button) findViewById(R.id.add_skill);
        addSpeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TableRow row = new TableRow(Add_Edit_Monster.this);
                Spinner skillSpinner = new Spinner(Add_Edit_Monster.this);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(Add_Edit_Monster.this, R.array.skills, android.R.layout.simple_spinner_dropdown_item);
                skillSpinner.setAdapter(adapter);
                row.addView(skillSpinner);
                EditText skillText = new EditText(Add_Edit_Monster.this);
                skillText.setHint("Enter Bonus");
                row.addView(skillText);
                Button deleteRow = new Button(Add_Edit_Monster.this);
                deleteRow.setBackgroundColor(getColor(R.color.colorInk));
                deleteRow.setTextColor(getColor(R.color.colorWhite));
                deleteRow.setText("-");
                row.addView(deleteRow);
                TableLayout skillTable = (TableLayout) findViewById(R.id.skilltable);
                skillTable.addView(row);
                final float scale = getResources().getDisplayMetrics().density;
                int heightDp = (int) (20 * scale + 0.5f);
                ViewGroup.LayoutParams params = deleteRow.getLayoutParams();
                params.height = heightDp;
                params.width = heightDp;
                deleteRow.setPadding(5, 5, 5, 5);
                deleteRow.setGravity(Gravity.CENTER);
                deleteRow.setLayoutParams(params);
                deleteRow.requestLayout();
                skillTable.requestLayout();
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
        });

    }


    private void addSavingThrow() {

        Button addSpeed = (Button) findViewById(R.id.add_savingthrow);
        addSpeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TableRow row = new TableRow(Add_Edit_Monster.this);
                Spinner savingThrowSpinner = new Spinner(Add_Edit_Monster.this);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(Add_Edit_Monster.this, R.array.saving_throws, android.R.layout.simple_spinner_dropdown_item);
                savingThrowSpinner.setAdapter(adapter);
                row.addView(savingThrowSpinner);
                EditText savingThrowText = new EditText(Add_Edit_Monster.this);
                savingThrowText.setHint("Enter Bonus");
                row.addView(savingThrowText);
                Button deleteRow = new Button(Add_Edit_Monster.this);
                deleteRow.setBackgroundColor(getColor(R.color.colorInk));
                deleteRow.setTextColor(getColor(R.color.colorWhite));
                deleteRow.setText("-");
                row.addView(deleteRow);
                TableLayout speedTable = (TableLayout) findViewById(R.id.savingthrowtable);
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
        });

    }

    private void addSpeed() {

        Button addSpeed = (Button) findViewById(R.id.add_speed);
        addSpeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TableRow row = new TableRow(Add_Edit_Monster.this);
                Spinner speedSpinner = new Spinner(Add_Edit_Monster.this);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(Add_Edit_Monster.this, R.array.speed_types, android.R.layout.simple_spinner_dropdown_item);
                speedSpinner.setAdapter(adapter);
                row.addView(speedSpinner);
                EditText speedText = new EditText(Add_Edit_Monster.this);
                speedText.setHint("Enter Speed");
                row.addView(speedText);
                Button deleteRow = new Button(Add_Edit_Monster.this);
                deleteRow.setBackgroundColor(getColor(R.color.colorInk));
                deleteRow.setTextColor(getColor(R.color.colorWhite));
                deleteRow.setText("-");
                row.addView(deleteRow);
                TableLayout speedTable = (TableLayout) findViewById(R.id.speedtable);
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
        });

    }

    private void createMonster() {
        Button save = (Button) findViewById(R.id.save_monster);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText monsterName = (EditText) findViewById(R.id.monsternameentry);
                Monster newMonster = new Monster(monsterName.getText().toString());

                Spinner size = (Spinner) findViewById(R.id.sizeentry);
                Spinner type = (Spinner) findViewById(R.id.typeentry);
                Spinner alignment = (Spinner) findViewById(R.id.alignmententry);
                EditText armorClass = (EditText) findViewById(R.id.armorclass);
                EditText numDice = (EditText) findViewById(R.id.numdice);
                EditText diceType = (EditText) findViewById(R.id.dicetype);
                TableLayout speedTable = (TableLayout) findViewById(R.id.speedtable);
                TableLayout saveTable = (TableLayout) findViewById(R.id.savingthrowtable);
                TableLayout skillTable = (TableLayout) findViewById(R.id.skilltable);
                TableLayout damResistTable = (TableLayout) findViewById(R.id.damresisttable);
                TableLayout damImmuneTable = (TableLayout) findViewById(R.id.damimmunetable);
                TableLayout condImmuneable = (TableLayout) findViewById(R.id.condimmunetable);
                TableLayout senseTable = (TableLayout) findViewById(R.id.sensestable);
                TableLayout languageTable = (TableLayout) findViewById(R.id.languagetable);

                newMonster.setSize(size.getSelectedItem().toString());
                newMonster.setType(type.getSelectedItem().toString());
                newMonster.setAlignment(alignment.getSelectedItem().toString());


                newMonster.setArmorClass(Integer.parseInt(armorClass.getText().toString()));
                newMonster.setNumHitDice(Integer.parseInt(numDice.getText().toString()));
                newMonster.setHitDiceType(Integer.parseInt(diceType.getText().toString()));

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
                        newMonster.addMovementType(newMovement);
                    }
                }


                EditText strength = (EditText) findViewById(R.id.strength);
                EditText dexterity = (EditText) findViewById(R.id.dexterity);
                EditText constitution = (EditText) findViewById(R.id.constitution);
                EditText intelligence = (EditText) findViewById(R.id.intelligence);
                EditText wisdom = (EditText) findViewById(R.id.wisdom);
                EditText charisma = (EditText) findViewById(R.id.dexterity);

                newMonster.addAbility(new Ability("Strength", Integer.parseInt(strength.getText().toString())));
                newMonster.addAbility(new Ability("Dexterity", Integer.parseInt(dexterity.getText().toString())));
                newMonster.addAbility(new Ability("Constitution", Integer.parseInt(constitution.getText().toString())));
                newMonster.addAbility(new Ability("Intelligence", Integer.parseInt(intelligence.getText().toString())));
                newMonster.addAbility(new Ability("Wisdom", Integer.parseInt(wisdom.getText().toString())));
                newMonster.addAbility(new Ability("Charisma", Integer.parseInt(charisma.getText().toString())));

                //Parse saving throw table
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
                        newMonster.addSavingThrow(newSave);
                    }
                }

                //Parse skill table
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
                        newMonster.addSkill(newSkill);
                    }
                }

                //Parse dam resist table
                for (int i = 0; i < damResistTable.getChildCount(); i++) {
                    View child = damResistTable.getChildAt(i);

                    if (child instanceof TableRow) {
                        TableRow row = (TableRow) child;

                        for (int j = 0; j < row.getChildCount(); j++) {
                            View v = row.getChildAt(j);

                            if (v instanceof Spinner)
                                newMonster.addDamResistance(((Spinner) v).getSelectedItem().toString());

                        }
                    }
                }

                //Parse dam immune table
                for (int i = 0; i < damImmuneTable.getChildCount(); i++) {
                    View child = damImmuneTable.getChildAt(i);

                    if (child instanceof TableRow) {
                        TableRow row = (TableRow) child;

                        for (int j = 0; j < row.getChildCount(); j++) {
                            View v = row.getChildAt(j);

                            if (v instanceof Spinner)
                                newMonster.addDamImmunity(((Spinner) v).getSelectedItem().toString());

                        }
                    }
                }


                //Parse cond immune table
                for (int i = 0; i < condImmuneable.getChildCount(); i++) {
                    View child = condImmuneable.getChildAt(i);

                    if (child instanceof TableRow) {
                        TableRow row = (TableRow) child;

                        for (int j = 0; j < row.getChildCount(); j++) {
                            View v = row.getChildAt(j);

                            if (v instanceof Spinner)
                                newMonster.addCondImmunity(((Spinner) v).getSelectedItem().toString());

                        }
                    }
                }


                //Parse sense table
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
                        newMonster.addSense(newSense);
                    }
                }

                //Parse language table
                for (int i = 0; i < languageTable.getChildCount(); i++) {
                    View child = languageTable.getChildAt(i);

                    if (child instanceof TableRow) {
                        TableRow row = (TableRow) child;

                        for (int j = 0; j < row.getChildCount(); j++) {
                            View v = row.getChildAt(j);

                            if (v instanceof Spinner)
                                newMonster.addLanguage(((Spinner) v).getSelectedItem().toString());

                        }
                    }
                }

                CheckBox legendary = (CheckBox) findViewById(R.id.legendary_checkbox);
                CheckBox lair = (CheckBox) findViewById(R.id.lair_checkbox);

                if (legendary.isChecked())
                    newMonster.setIsLegendary(true);
                else
                    newMonster.setIsLegendary(false);
                if(lair.isChecked())
                    newMonster.setHasLair(true);
                else
                    newMonster.setHasLair(false);

                Bundle bundle = new Bundle();
                bundle.putParcelable("NewMonster", newMonster);

                Intent intent = new Intent();
                intent.putExtras(bundle);

                setResult(RESULT_OK, intent);
                finish();

            }
        });
    }
}
