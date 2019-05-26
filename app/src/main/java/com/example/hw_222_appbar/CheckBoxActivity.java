package com.example.hw_222_appbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class CheckBoxActivity extends AppCompatActivity {

    private EditText inputInfo;
    private EditText inputMoney;
    private Button buttonOk;
    private CheckBox bankCardCheckBox;
    private CheckBox mobilePhoneCheckBox;
    private CheckBox cashAddressCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);
        initViews();

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String messageToShow =
                        inputInfo.getText().toString() + " "
                                + inputMoney.getText().toString() + " ";
                Toast.makeText(CheckBoxActivity.this, messageToShow, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void initViews() {

        inputInfo = findViewById(R.id.infoInputText);
        inputMoney = findViewById(R.id.moneyInputText);
        buttonOk = findViewById(R.id.okButton);
        bankCardCheckBox = findViewById(R.id.bankCardCheckBox);
        mobilePhoneCheckBox = findViewById(R.id.mobilePhoneCheckBox);
        cashAddressCheckBox = findViewById(R.id.cashAddressCheckBox);
        bankCardCheckBox.setOnCheckedChangeListener(checkedChangeListener);
        mobilePhoneCheckBox.setOnCheckedChangeListener(checkedChangeListener);
        cashAddressCheckBox.setOnCheckedChangeListener(checkedChangeListener);
    }

    private void resetCheckBoxes() {
        bankCardCheckBox.setChecked(false);
        mobilePhoneCheckBox.setChecked(false);
        cashAddressCheckBox.setChecked(false);
    }

    CompoundButton.OnCheckedChangeListener checkedChangeListener =
            new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                    if (b) {
                        switch (buttonView.getId()) {
                            case R.id.bankCardCheckBox:
                                resetCheckBoxes();
                                bankCardCheckBox.setChecked(true);
                                bankCardCheckBox.setInputType(InputType.TYPE_CLASS_NUMBER);
                                break;
                            case R.id.mobilePhoneCheckBox:
                                resetCheckBoxes();
                                mobilePhoneCheckBox.setChecked(true);
                                mobilePhoneCheckBox.setInputType(InputType.TYPE_CLASS_PHONE);
                                break;
                            case R.id.cashAddressCheckBox:
                                resetCheckBoxes();
                                cashAddressCheckBox.setChecked(true);
                                cashAddressCheckBox.setInputType(InputType.TYPE_CLASS_TEXT);
                                break;
                        }

                    }
                }
            };
}
