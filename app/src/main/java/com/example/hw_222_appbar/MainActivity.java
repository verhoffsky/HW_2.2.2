package com.example.hw_222_appbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_open_notes:
                startActivity(new Intent(this, NotesActivity.class));
                break;
            case R.id.action_setting:
                Toast.makeText(this, "This is SETTINGS", Toast.LENGTH_SHORT).show();
                break;
            default:
                return super.onOptionsItemSelected(item);

        }
        return true;

    }

}
