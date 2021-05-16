package com.org.arkp.admissionguidance;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UpdatePasswordActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextEmail;
    private Button btnUpdatePassword;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_password);


        Window w = this.getWindow();
        //set task bar translucent & also color
        w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        setTitle("Update Password");

        //    Blink your button or Text

        TextView myText = (TextView) findViewById(R.id.myText );

        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(1000); //You can manage the time of the blink with this parameter
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        myText.startAnimation(anim);


        editTextEmail=(EditText)findViewById(R.id.editUpdatePassword);
        btnUpdatePassword=(Button)findViewById(R.id.buttonSubmitPassword);

        firebaseAuth=FirebaseAuth.getInstance();
        btnUpdatePassword.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if (view==btnUpdatePassword)
        {
            resetPassword();
        }
    }

    private void resetPassword() {
        final String email=editTextEmail.getText().toString().trim();

        firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if (task.isSuccessful())
                {
                    Toast.makeText(UpdatePasswordActivity.this,"Request completed,check your email to Update password",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(UpdatePasswordActivity.this,"something went wrong",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
