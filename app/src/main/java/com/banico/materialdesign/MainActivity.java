package com.banico.materialdesign;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    MaterialToolbar toolbar;
    MaterialButton next;
    MaterialButton cancel;
    TextInputEditText userName;
    TextInputEditText password;
    TextInputLayout userNameInputLayout;
    TextInputLayout passwordInputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setView();
        setClicks();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.close) finish();
        return super.onOptionsItemSelected(item);
    }

    private void setView() {
        toolbar = findViewById(R.id.toolbar);
        next = findViewById(R.id.next);
        cancel = findViewById(R.id.cancel);
        userName = findViewById(R.id.userName);
        password = findViewById(R.id.password);
        userNameInputLayout = findViewById(R.id.userNameLayout);
        passwordInputLayout = findViewById(R.id.passwordLayout);

        setSupportActionBar(toolbar);
    }

    private void setClicks() {
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInputsValid = validateInputs();
                if (isInputsValid) {
                    Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_SHORT).show();
                } else {
                    userNameInputLayout.setError("Invalid Input");
                    passwordInputLayout.setError("Invalid Input");
                }

            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private boolean validateInputs() {
        if (userName.getText() == null || userName.getText().toString().equals("")) {
            return false;
        } else return password.getText() != null && password.getText().toString().length() >= 8;
    }
}
