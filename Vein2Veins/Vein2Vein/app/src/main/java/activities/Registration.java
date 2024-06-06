package activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vein2vein.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registration extends AppCompatActivity {

    TextView button;

    private EditText input_username, input_email, input_password, input_confirm_password;

    Button button_register;

    private FirebaseAuth mAuth;

    private ProgressDialog mLoadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        button = findViewById(R.id.already_have_account);

        input_username = findViewById(R.id.input_username);
        input_email = findViewById(R.id.input_email);
        input_password = findViewById(R.id.input_password);
        input_confirm_password = findViewById(R.id.input_confirm_password);

        mAuth = FirebaseAuth.getInstance();

        mLoadingBar = new ProgressDialog(Registration.this);

        button_register = findViewById(R.id.button_register);
        button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkCredentials();
            }
        });

        checkCredentials();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Registration.this, Login.class));
            }
        });
    }

    private void checkCredentials() {
        String username = input_username.getText().toString();
        String email = input_email.getText().toString();
        String password = input_password.getText().toString();
        String confirm_password = input_confirm_password.getText().toString();

        if(username.isEmpty() || username.length() < 7)
        {
            showError(input_username, "Your username is not valid!");
        }
        else if (email.isEmpty() || !email.contains("@"))
        {
            showError(input_email, "Your Email Id is not valid");
        }
        else if (password.isEmpty() || password.length() < 7)
        {
            showError(input_password, "Password must contain at least 7 characters");
        }
        else if (confirm_password.isEmpty() || !confirm_password.equals(password))
        {
            showError(input_confirm_password, "Password is not matching. Please check again.");
        }
        else
        {
            mLoadingBar.setTitle("Registration");
            mLoadingBar.setMessage("Please wait, while check your credentials");
            mLoadingBar.setCanceledOnTouchOutside(false);
            mLoadingBar.show();

            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful())
                    {
                        Toast.makeText(Registration.this, "Registration Successful!", Toast.LENGTH_SHORT).show();
                        mLoadingBar.dismiss();

                        Intent intent = new Intent(Registration.this, Login.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(Registration.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void showError(EditText input, String s) {
        input.setError(s);
        input.requestFocus();
    }
}