package estacio.edu.br.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button botao;
    EditText login;
    EditText senha;

    private UsuarioSessao sessao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.login = (EditText)findViewById(R.id.login);
        this.senha = (EditText)findViewById(R.id.senha);
        this.botao = (Button) findViewById(R.id.button);
        this.sessao = new UsuarioSessao(getApplicationContext());


        botao.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                efetuarLogin();
            }
        });


        if(this.sessao.isUserLoggedIn()){
            this.abrirApp();
        }

    }

    private void efetuarLogin() {
        if( this.login.getText().toString().equals("admin") &&
                this.senha.getText().toString().equals("123")    ){
            this.sessao.createUserLoginSession("admin", "123456");
            abrirApp();
        }else{
            Toast toast = Toast.makeText(getApplicationContext(),"Senha inváida", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    private void abrirApp() {
        Intent i = new Intent(getApplicationContext(), Logado.class);
        startActivity(i);
        finish();
    }
}
