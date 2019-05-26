package com.example.hw_222_appbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class UniversalFormActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextMail;
    private TextView successfulSubscribe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universal_form);

        editTextName = findViewById(R.id.editText_name);
        editTextMail = findViewById(R.id.editText_mail);
        successfulSubscribe = findViewById(R.id.text_successful_subscribe);

        findViewById(R.id.button_ok).setOnClickListener(okClickListener);
        findViewById(R.id.button_delete).setOnClickListener(deleteClickListener);
    }
    private View.OnClickListener okClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String name = String.valueOf(editTextName.getText());
            String mail = String.valueOf(editTextMail.getText());

            String message = getString(R.string.message_template, name, mail);
            successfulSubscribe.setText(message);
        }
    };
    private View.OnClickListener deleteClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            editTextName.getText().clear();
            editTextMail.getText().clear();
            successfulSubscribe.setText("");
        }
    };

}
