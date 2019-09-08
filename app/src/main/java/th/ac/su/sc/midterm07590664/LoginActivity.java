package th.ac.su.sc.midterm07590664;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import th.ac.su.sc.midterm07590664.Model.Auth;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
/*
 Intent  intent = new Intent(LoginActivity,ProfileActivity);
    intent.putExtra()
*/


//ใช้ตัวแปร loginbutton อ้างอิงไปยังปุ่ม layout
        Button loginButton = findViewById(R.id.login_button);
//สร้าง listener จากคลาส Mylistener
        MyListener listener = new MyListener();
// ผูกปุ่มกับ listen เข้าด้วยกัน
        loginButton.setOnClickListener(listener);


        EditText emailEditText = findViewById(R.id.email_edit_text);
        EditText passwordEditText = findViewById(R.id.password_edit_text);



        String inputEmail = emailEditText.getText().toString();
        int value = Integer.parseInt(inputEmail);

        String inputPassword = passwordEditText.getText().toString();

        Auth auth = new Auth(inputEmail, inputPassword);

    }
    private class MyListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            boolean result = auth.check();

            if (result) {
                  /*  Toast.makeText(
                            LoginActivity.this,
                            R.string.login_success,
                            Toast.LENGTH_SHORT
                    ).show(); */

                if (rememberPasswordCheckBox.isChecked()){
                    Toast.makeText(
                            LoginActivity.this,
                            "คุณเลือกจำรหัสผ่าน",
                            Toast.LENGTH_SHORT
                    ).show();
                }else {
                    Toast.makeText(
                            LoginActivity.this,
                            "คุณไม่ได้เลือกจำรหัสผ่าน",
                            Toast.LENGTH_SHORT
                    ).show();
                }


            } else {
                // login failed
                AlertDialog.Builder dialog = new AlertDialog.Builder(LoginActivity.this);
                dialog.setTitle("Error");
                dialog.setMessage(R.string.login_failed);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //โค้ดที่มห้ทำงานเมื่อยูสเศอร์กดปุ่มโอเค
                        //todo;
                    }
                });
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //โค้ดที่มห้ทำงานเมื่อยูสเศอร์กดปุ่มแคนเซิล
                        //todo;
                    }
                });

                dialog.setNeutralButton("Ignore", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //โค้ดที่มห้ทำงานเมื่อยูสเศอร์กดปุ่มignore
                        //todo;
                    }
                });

                dialog.show();

                //Toast.makeText(
                //LoginActivity.this,R.string.login_failed,Toast.LENGTH_SHORT ).show();
            }



        }
    }
}
