package br.com.etecia.myapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListaProdutosActivity extends AppCompatActivity {

    RecyclerView idListaProdutos;
    List<Produtos> lstProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.lista_produtos_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        idListaProdutos = findViewById(R.id.idListaProdutos);

        lstProdutos = new ArrayList<>();
        lstProdutos.add(
                new Produtos("Cachalote", R.drawable.axalote);
                new Produtos("Calango", R.drawable.calango);
                new Produtos("Camundongo", R.drawable.camundomgo);
                new Produtos("Orangotango", R.drawable.orangomtamg);
                new Produtos("Lemure", R.drawable.lemure);
                new Produtos("Capivara", R.drawable.capibara);
                new Produtos("Quokka", R.drawable.quokka);
                new Produtos("Tamanco", R.drawable.tamanco);
        );

        idListaProdutos.setLayoutManager(new GridLayoutManager());

        AdaptadorProdutos adapter = new
                AdaptadorProdutos(getApplicationContext(),
            lstProdutos);

        idListaProdutos.hasFixedSize();
        idListaProdutos.setAdapter(adapter);


    }
}