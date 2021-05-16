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

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText editTextConfirmPassword;
    private Button buttonRegister;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;


      RelativeLayout Registerback;
     AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();
        // overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);

        progressDialog=new ProgressDialog(this);
        firebaseAuth=FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() !=null)
        {
            finish();
            startActivity(new Intent(getApplicationContext(),Home.class));
        }

        editTextEmail = (EditText) findViewById(R.id.userEmail);
        editTextPassword = (EditText) findViewById(R.id.userPassword);
        editTextConfirmPassword=(EditText) findViewById(R.id.userconfirmPassword);
        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        buttonRegister.setOnClickListener(this);

        Registerback = (RelativeLayout) findViewById(R.id.activity_register);

        animationDrawable = (AnimationDrawable) Registerback.getBackground();
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

    //kill Current Register Activity on back button pressed
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.push_out_right, R.anim.pull_in_left);

    }



    private void registerUser()
    {
        String email= editTextEmail.getText().toString().trim();
        String password  = editTextPassword.getText().toString().trim();
        String confirmpassword=editTextConfirmPassword.getText().toString().trim();

        if(TextUtils.isEmpty(email) && TextUtils.isEmpty(password) && TextUtils.isEmpty(confirmpassword)){
            editTextEmail.setError("Please enter Email");
            editTextEmail.requestFocus();

            editTextPassword.setError("Please Enter Password,Atleast 6 Character ");
            editTextPassword.requestFocus();

            editTextConfirmPassword.setError("Please Enter Confirm Password");
            editTextConfirmPassword.requestFocus();
            //   Toast.makeText(this,"Please enter email",Toast.LENGTH_LONG).show();
            return;
        }


        if(password.length()<=6){
            editTextPassword.setError("Password must be 6 Character ");
            editTextPassword.requestFocus();
            //Toast.makeText(this,"Please enter password", Toast.LENGTH_LONG).show();
            return;
        }

        if (confirmpassword.length()<=6)
        {
            editTextConfirmPassword.setError("Confirm Password must be 6 Character");
            editTextConfirmPassword.requestFocus();
            //Toast.makeText(this,"Please Enter Confirm Password",Toast.LENGTH_SHORT).show();
            if (password!=confirmpassword)
            {
                Toast.makeText(this,"Password And Confirm Password Does not Match",Toast.LENGTH_SHORT).show();
            }
            return;
        }

        progressDialog.setMessage("Registering User....");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    sendEmailVerification();
                    finish();
                    //startActivity(new Intent(getApplicationContext(),LoginActivity.class));

                    Toast.makeText(RegisterActivity.this,"Registered Successfully, Please Check Your Email For Verification",Toast.LENGTH_SHORT).show();


                }
                else
                {
                    Toast.makeText(RegisterActivity.this,"Could Not Register, Something Went Wrong... ",Toast.LENGTH_SHORT).show();
                    finish();
                }

            }
        });
    }

    private void sendEmailVerification() {
        FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
        if (user!=null)
        {
            user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful())
                    {
                        FirebaseAuth.getInstance().signOut();
                    }

                }
            });
        }
    }

    @Override
    public void onClick(View view) {

        if(view == buttonRegister)
        {
            registerUser();
        }

    }
}
