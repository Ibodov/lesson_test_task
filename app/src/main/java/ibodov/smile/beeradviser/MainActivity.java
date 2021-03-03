package ibodov.smile.beeradviser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private BeerExpert expert;
    TextView brands;
    Spinner color;
    String beerType;
    List<String> brandsList;
    StringBuilder brandsFormatted = new StringBuilder();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickFindBeer(View view) {
        brands = findViewById(R.id.textView);
        color = findViewById(R.id.spinner);
        beerType = String.valueOf(color.getSelectedItem());
        //brands.setText(beerType);

        List<String> brandsList = expert.getBrands(beerType);
        StringBuilder brandsFormatted = new StringBuilder();
        for (String brand : brandsList) {
            brandsFormatted.append(brand).append('\n');
        }
        brands.setText(brandsFormatted);
    }
}