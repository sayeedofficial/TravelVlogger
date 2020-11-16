package my.travelvlogger;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.android.material.textfield.TextInputLayout;
import com.travelblog.R;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {
    private TextInputLayout textUsernameInput;
    private TextInputLayout textPasswordInput;
    private  Button loginButton;
    private  ProgressBar progressBar;
    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_login);
        textUsernameInput = findViewById(R.id.textUsernameLayout);
        textPasswordInput = findViewById((R.id.textPasswordInput));
         loginButton = findViewById(R.id.loginButton);
         progressBar = findViewById(R.id.progressBar);
        loginButton.setOnClickListener(view -> LoginActivity.this.onLoginClicked());


        textUsernameInput.getEditText().addTextChangedListener(createTextWatcher(textUsernameInput));
        textPasswordInput.getEditText().addTextChangedListener(createTextWatcher(textPasswordInput));

    }

    public void onLoginClicked() {

        String username = Objects.requireNonNull(textUsernameInput.getEditText()).getText().toString();
        String password = Objects.requireNonNull(textPasswordInput.getEditText()).getText().toString();
        if (username.isEmpty()) {
            textUsernameInput.setError("Username must not be empty");
        }
        if (password.isEmpty()) {
            textPasswordInput.setError("Password must not be empty");
        }
        if (!username.equals("admin") && !password.equals("admin")) {
            showErrorDailog();
        }
        else{
            performLogin();
        }

    }
    private void performLogin(){
        loginButton.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.VISIBLE);
        textUsernameInput.setEnabled(false);
        textPasswordInput.setEnabled(false);

        Handler handler = new Handler();
        handler.postDelayed(this::startMainActivity,2000);
    }
    private void startMainActivity(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }



    private void showErrorDailog() {
        new AlertDialog.Builder(this).setTitle("Login Failed").setMessage("Username or Password is incorrect,Please try Again").setPositiveButton("Ok", (dialog, which) -> dialog.dismiss()).show();

    }
    private TextWatcher createTextWatcher(TextInputLayout text) {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                text.setError(null);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
    }




}
