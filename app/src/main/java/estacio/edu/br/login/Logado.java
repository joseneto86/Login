package estacio.edu.br.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.HashMap;

public class Logado extends AppCompatActivity {
    Button botao;
    TextView texto;
    private UsuarioSessao sessao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logado);

        this.botao = (Button) findViewById(R.id.logout);
        this.texto = (TextView) findViewById(R.id.ola);
        this.sessao = new UsuarioSessao(getApplicationContext());

        if(sessao.checkLogin())
            finish();

        // get user data from session
        HashMap<String, String> user = sessao.getUserDetails();

        String nome = user.get(UsuarioSessao.KEY_NAME);

        String cpf = user.get(UsuarioSessao.KEY_CPF);

        this.texto.setText("Olá "+nome+" "+cpf);
        Button btLogoff = (Button) findViewById(R.id.logout);
        btLogoff.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                logoff();
            }
        });


    }

    private void logoff(){
        finish();
        this.sessao.logoutUser();

    }
}
