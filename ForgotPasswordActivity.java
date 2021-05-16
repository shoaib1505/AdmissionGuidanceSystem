package com.org.arkp.admissionguidance;

import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
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

public class ForgotPasswordActivity extends AppCompatActivity implements View.OnClickListener{

    RelativeLayout resetback;
    AnimationDrawable animationDrawable;
    private EditText editTextEmail;
    private Button btnResetPassword;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.activity_forgot_password);
        getSupportActionBar().hide();

        editTextEmail=(EditText)findViewById(R.id.userEmail);
        btnResetPassword=(Button)findViewById(R.id.btnResetPassword);

        firebaseAuth=FirebaseAuth.getInstance();
     btnResetPassword.setOnClickListener(this);



        resetback = (RelativeLayout) findViewById(R.id.activity_forgetpassword);

        animationDrawable = (AnimationDrawable) resetback.getBackground();
        animationDrawable.setEnterFadeDuration(4000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        //    Blink your button or Text

        TextView myText = (TextView) findViewById(R.id.myText );

        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(1000); //You can manage the time of the blink with this parameter
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        myText.startAnimation(anim);
    }


    @Override
    public void onClick(View view) {
        if (view==btnResetPassword)
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
                  Toast.makeText(ForgotPasswordActivity.this,"Email Send,check your email to reset password",Toast.LENGTH_SHORT).show();
              }
              else
              {
                  Toast.makeText(ForgotPasswordActivity.this,"something went wrong",Toast.LENGTH_SHORT).show();
              }
          }
      });
    }


}
