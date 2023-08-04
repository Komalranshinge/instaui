package com.example.insta2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import java.util.HashMap;
import java.util.Map;


public class SignUp extends AppCompatActivity {


    EditText name,username,email,phone,pass;
    Button btn,btn1;
    private static final String url ="http://192.168.1.36/Login/signup.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow() .setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);

        name= findViewById(R.id.name);
        username= findViewById(R.id.username);
        email= findViewById(R.id.email);
        phone= findViewById(R.id.phone);
        pass= findViewById(R.id.pass);
        btn1= findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register_user(name.getText().toString(),username.getText().toString(),email.getText().toString(),phone.getText().toString(),pass.getText().toString());
            }
        });

        btn = findViewById(R.id.btn2);
        btn.setOnClickListener(view -> {
            Intent intent = new Intent(SignUp.this, Login.class );
            startActivity(intent);
        });
    }
    public void register_user(final String name, final String username, final String email, final String phone, final String pass)
    {
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                name.equals("");
                username.equals("");
                email.equals("");
                phone.equals("");
                pass.equals("");


                Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                name.equals("");
                username.equals("");
                email.equals("");
                phone.equals("");
                pass.equals("");
                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG).show();

            }
        }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
            Map<String,String> map = new HashMap<String,String>();
                map.put("fullname",name);
                map.put("username",username);
                map.put("email",email);
                map.put("phoneno",phone);
                map.put("password",pass);
                return map;
            }
        };
        RequestQueue queue= Volley.newRequestQueue(getApplicationContext());
        queue.add(request);
    }
}