package davidrowantechnologies.medibuddy4;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.w3c.dom.Text;

import java.io.IOException;

import static android.app.PendingIntent.getActivity;

public class TestActivity extends AppCompatActivity {
    FakeDatabase medInfo = new FakeDatabase();
    String BarCode = null;
    Medicine medInformation = new Medicine();
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Intent intent = new Intent("com.google.zxing.client.android.SCAN");
        intent.putExtra("SCAN_MODE", "PRODUCT_MODE");//for Qr code, its "QR_CODE_MODE" instead of "PRODUCT_MODE"
        intent.putExtra("SAVE_HISTORY", false);//this stops saving ur barcode in barcode scanner app's history
        startActivityForResult(intent, 0);





        Button testButton = (Button) findViewById(R.id.button2);

        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(TestActivity.this, "Medication added to list", Toast.LENGTH_SHORT).show();

                finish();
            }

        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                BarCode = data.getStringExtra("SCAN_RESULT"); //this is the result
                Toast.makeText(this, "Result: " + BarCode, Toast.LENGTH_LONG).show();
                System.out.println("This is the barcode:"+BarCode);
                medInformation = medInfo.checkMed(BarCode);
                if(medInformation.getBarcode() != null){
                    TextView nameText = (TextView) findViewById(R.id.nameText);
                    nameText.setText(medInformation.getName());
                    TextView amountText = (TextView) findViewById(R.id.amountText);
                    amountText.setText((medInformation.getAmount()));
                    TextView sideEffect = (TextView) findViewById((R.id.sideEffectText));
                    sideEffect.setText(medInformation.getSideEffects());
                    TextView interactText = (TextView) findViewById(R.id.interactText);
                    interactText.setText(medInformation.getInteract());
                    TextView dosageText = (TextView) findViewById(R.id.dosageText);
                    dosageText.setText(medInformation.getDosage());
                    Global.medlist.add(medInformation);
                    System.out.println("Recreated View");

                }


            }
            else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(TestActivity.this,"Cancelling Operation",Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }
}
