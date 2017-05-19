package falc.dungeonmasterhelper;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;

public class Add_Edit_Monster extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_edit_monster);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
}
