package com.org.arkp.admissionguidance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;

public class MyAccountActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonemail;
    private Button buttonpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);
        Window w = this.getWindow();
        //set task bar translucent & also color
        w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        setTitle("My Account");

        //    Blink your button or Text

        TextView myText = (TextView) findViewById(R.id.myText );

        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(1000); //You can manage the time of the blink with this parameter
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        myText.startAnimation(anim);

        buttonemail=(Button)findViewById(R.id.buttonupdateEmail);
        buttonpassword=(Button)findViewById(R.id.buttonupdatePassword);

        buttonemail.setOnClickListener(this);
        buttonpassword.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if (view==buttonemail)
        {
            startActivity(new Intent(this,UpdateEmailActivity.class));
        }
        if (view==buttonpassword)
        {
            startActivity(new Intent(this,UpdatePasswordActivity.class));
        }

    }


    // back arrow
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(MyAccountActivity.this, Home.class);
                startActivity(intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //kill Current College info activity on back button pressed
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(MyAccountActivity.this, Home.class);
        startActivity(intent);
        finish();
    }
}
