package com.example.nyaay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import io.github.muddz.styleabletoast.StyleableToast;

public class MainP extends AppCompatActivity {

    Button btn_CaseStatus;
    Button btn_InfoCenter;
    Button btn_Forms;
    Button btn_Fees;
    Button btn_FAQ;
    DrawerLayout drawerLayout;
    NavigationView navigation;
    Toolbar toolbar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_p);

        btn_CaseStatus = findViewById(R.id.btn_CaseStatus);
        btn_CaseStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), LoginP.class);
                Intent intent = new Intent(MainP.this, CaseStatusPN.class);
                startActivity(intent);
            }
        });

        btn_InfoCenter = findViewById(R.id.btn_InfoCenter);
        btn_InfoCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), LoginP.class);
                Intent intent = new Intent(MainP.this, InfoCenterP.class);
                startActivity(intent);
            }
        });

        btn_Forms = findViewById(R.id.btn_Forms);
        btn_Forms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), LoginP.class);
                Intent intent = new Intent(MainP.this, FormsP.class);
                startActivity(intent);
            }
        });

        btn_Fees = findViewById(R.id.btn_Fees);
        btn_Fees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), LoginP.class);
                Intent intent = new Intent(MainP.this, FeesP.class);
                startActivity(intent);
            }
        });

        btn_FAQ = findViewById(R.id.btn_FAQ);
        btn_FAQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), LoginP.class);
                Intent intent = new Intent(MainP.this, FAQP.class);
                startActivity(intent);
            }
        });
        drawerLayout =  findViewById(R.id.drawer_layoutP);
        navigation=  findViewById(R.id.navP);
        toolbar=(Toolbar)findViewById(R.id.toolbarP);
        setSupportActionBar(toolbar);


        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:
                        StyleableToast.makeText(getApplicationContext(),"Home", Toast.LENGTH_SHORT,R.style.CustomToast).show();
                        Intent i =new Intent(getApplicationContext(),LoginOptions.class);
                        startActivity(i);
                        break;
                    case R.id.privacyPolicy:
                        StyleableToast.makeText(getApplicationContext(),"Privacy Policy",Toast.LENGTH_SHORT,R.style.CustomToast).show();
                        Intent i1 =new Intent(getApplicationContext(),Privacy_policy.class);
                        startActivity(i1);
                        break;
                    case R.id.logout:
                        StyleableToast.makeText(getApplicationContext(),"Logout Successfully",Toast.LENGTH_SHORT,R.style.CustomToast).show();
                        Intent i2 =new Intent(getApplicationContext(),LoginOptions.class);
                        startActivity(i2);
                        break;
                    case R.id.contact:
                        StyleableToast.makeText(getApplicationContext(),"Contact",Toast.LENGTH_SHORT,R.style.CustomToast).show();
                        Intent i3 =new Intent(getApplicationContext(),Contact_Us.class);
                        startActivity(i3);
                        break;
                    case R.id.nav_share:
                        StyleableToast.makeText(getApplicationContext(),"Share",Toast.LENGTH_SHORT,R.style.CustomToast).show();
                        Intent i4 =new Intent(getApplicationContext(),Share.class);
                        startActivity(i4);
                        break;
                    case R.id.mail:
                        StyleableToast.makeText(getApplicationContext(),"Mail",Toast.LENGTH_SHORT,R.style.CustomToast).show();
                        break;
                    case R.id.phone:
                        StyleableToast.makeText(getApplicationContext(),"Phone",Toast.LENGTH_SHORT,R.style.CustomToast).show();
                        break;

                }
                return false;
            }
        });


    }
}