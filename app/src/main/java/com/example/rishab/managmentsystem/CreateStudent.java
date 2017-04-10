package com.example.rishab.managmentsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.rishab.managmentsystem.Model.Studentinfo;

/**
 * Created by Rishab on 05-04-2017.
 */

public class CreateStudent extends AppCompatActivity {

    private String mname;
    private String mschool;
    private String mrollno;
    private String mEmail;
    private boolean mchecked;
    Studentinfo studentInfoobj;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_student);

        button = (Button) findViewById(R.id.btnSubmitdata);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText viewname = (EditText) findViewById(R.id.etname);
                mname = viewname.getText().toString();
                EditText viewschool = (EditText) findViewById(R.id.etschoolname);
                mschool = viewschool.getText().toString();
                EditText viewrollno = (EditText) findViewById(R.id.etrollno);
                mrollno = viewrollno.getText().toString();
                EditText viewEmail = (EditText) findViewById(R.id.etemail);
                mEmail = viewEmail.getText().toString();
                boolean b = checkValidation();
                if(b == true) {
                    Intent intent = new Intent();
                    studentInfoobj = new Studentinfo(mname, mschool, mrollno, mEmail);
                    intent.putExtra("infoobject", studentInfoobj);
                    setResult(RESULT_OK, intent);
                    finish();
                }
                else{
                    Toast.makeText(CreateStudent.this, "enter details again!", Toast.LENGTH_LONG).show();
                }

            }
        });


    }



    private boolean checkValidation() {


        if (mname.isEmpty() || mschool.isEmpty() || mrollno.isEmpty()) {
            return false;
        } else {
            if (isValidEmail(mEmail)) {
                return true;
            }

            return false;

        }
    }

    private boolean isValidEmail(String Email)
    {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(Email).matches();
    }

    public void onRadioButtonClicked(View view) {

        mchecked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.rbtnMale:
                if (mchecked)
                    break;
            case R.id.rbtnFemale:
                if (mchecked)
                    break;
            default:
                Toast.makeText(this, "check a button first", Toast.LENGTH_LONG).show();
                break;
        }
    }


}

