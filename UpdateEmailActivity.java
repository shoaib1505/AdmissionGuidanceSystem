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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UpdateEmailActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_email);
        Window w = this.getWindow();
        //set task bar translucent & also color
        w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        setTitle("Update Email");

        //    Blink your button or Text

        TextView myText = (TextView) findViewById(R.id.myText );

        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(1000); //You can manage the time of the blink with this parameter
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        myText.startAnimation(anim);


        editText=(EditText) findViewById(R.id.editTextEmail);
        button=(Button)findViewById(R.id.buttonSubmitEmail);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view==button)
        {
            resetMyEmail();
        }
    }

    private void resetMyEmail() {
        String textEmail=editText.getText().toString().trim();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        user.updateEmail(textEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful())
                {
                    Toast.makeText(UpdateEmailActivity.this,"Email Updated Successfully",Toast.LENGTH_SHORT).show();
                    FirebaseAuth.getInstance().signOut();
                }
                else
                {
                    Toast.makeText(UpdateEmailActivity.this,"Something went wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
