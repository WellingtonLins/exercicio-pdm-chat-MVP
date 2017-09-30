package ag.utacapp.components;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ag.utacapp.R;
import ag.utacapp.infra.AuthManagerImpl;
import ag.utacapp.model.AuthManager;
import ag.utacapp.model.AuthServiceException;
import ag.utacapp.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements LoginPresenter {
    private EditText etEmail;
    private EditText etPassword;
    private Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btLogin = (Button) findViewById(R.id.btLogin);
        btLogin.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginButtonClick();
            }
        });
    }

    @Override
    public String getEmail() {
        return etEmail.getText().toString();
    }

    @Override
    public String getPassword() {
        return etPassword.getText().toString();
    }

    @Override
    public void loginButtonClick() {
        String email = getEmail();
        String passwd = getPassword();
        AuthManager authManager = new AuthManagerImpl();
        try {
            String name = authManager.auth(email, passwd);
            Intent intent = new Intent(this, DashboardActivity.class);
            intent.putExtra("username", name);
            startActivity(intent);
        } catch (AuthServiceException e) {
            showMessageError(e.getMessage());
        }
    }

    @Override
    public void showMessageError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
