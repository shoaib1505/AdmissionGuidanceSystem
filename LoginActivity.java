package com.org.arkp.admissionguidance;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    RelativeLayout loginback;
    AnimationDrawable animationDrawable;

    private Button buttonLogin;
    private Button buttonSignup;
    private EditText userPassword;
    private EditText userEmail;
    private Button btnForgotPassword;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();


        firebaseAuth=FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() !=null)
        {
            finish();
            startActivity(new Intent(getApplicationContext(),Home.class));
        }

        userEmail=(EditText)findViewById(R.id.userEmail);
        userPassword=(EditText)findViewById(R.id.userPassword);
        buttonLogin=(Button)findViewById(R.id.login);
        buttonSignup=(Button)findViewById(R.id.btnsignup);
        btnForgotPassword=(Button)findViewById(R.id.btnforgetpassword);

        progressDialog=new ProgressDialog(this);

        buttonLogin.setOnClickListener(this);
        buttonSignup.setOnClickListener(this);
        btnForgotPassword.setOnClickListener(this);

           loginback = (RelativeLayout) findViewById(R.id.activity_login);

        animationDrawable = (AnimationDrawable) loginback.getBackground();
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
    private void userLogin()
    {
        //getting email and password from edit texts
        String email = userEmail.getText().toString().trim();
        String password  = userPassword.getText().toString().trim();

        //checking if email and passwords are empty
        if(TextUtils.isEmpty(email) ){
            userEmail.setError("Please enter Email");
            userEmail.requestFocus();

            userPassword.setError("Please Enter Password,Atleast 6 Character ");
            userPassword.requestFocus();
         //   Toast.makeText(this,"Please enter email",Toast.LENGTH_LONG).show();
            return;
        }




        //if the email and password are not empty
        //displaying a progress dialog

        progressDialog.setMessage("Please Wait, Logining...");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if (!task.isSuccessful())
                {
                    Toast.makeText(LoginActivity.this,"Please Enter Correct Email And Password",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    checkIfEmailverified();
                    finish();
                }
            }
        });

    }

    private void checkIfEmailverified() {
        FirebaseUser users =FirebaseAuth.getInstance().getCurrentUser();
        boolean emailVerified=users.isEmailVerified();
        if (!emailVerified)
        {
            Toast.makeText(LoginActivity.this,"Please Verify Your Email",Toast.LENGTH_SHORT).show();
            FirebaseAuth.getInstance().signOut();
        }
        else
        {
            startActivity(new Intent(LoginActivity.this,Home.class));
        }
    }

    @Override
    public void onClick(View view) {
        if (view==buttonLogin)
        {
            userLogin();
        }
        else if (view==buttonSignup)
        {

            startActivity(new Intent(this,RegisterActivity.class));
        }
        else if (view==btnForgotPassword)
        {
           startActivity(new Intent(this,ForgotPasswordActivity.class));

        }

    }

    @Override
    public void onBackPressed() {
        finish();
    }


}
