package davidrowantechnologies.medibuddy4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

public class cameraActivity1 extends AppCompatActivity {
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera1);

        String interfereProd;
        ArrayList<String> badProd = new ArrayList<String>();
        for(int x = 0; x< Global.medlist.size();x++){
            for(int y=0;y<Global.medlist.size();y++){
                if(Global.medlist.get(x).getInteract().contains(Global.medlist.get(y).getName())){
                   interfereProd= " Problem: " + Global.medlist.get(x).getName() +" Does not work with " +Global.medlist.get(y).getName() ;
                    badProd.add(interfereProd);
                }

            }
        }

          interfereProd =  badProd.toString();

        TextView interfereView = (TextView) findViewById(R.id.textView7);
        interfereView.setText(interfereProd);


        ListView list = (ListView) findViewById(R.id.ListView2);

        ArrayList<String> arrayList = new ArrayList<String>();
        int x=0;
        while(Global.medlist.size()!=x){
            arrayList.add(Global.medlist.get(x).getName());
            x++;
        }
        adapter = new ArrayAdapter<String>( this, R.layout.text, arrayList);
        list.setAdapter(adapter);
        Button listButton = (Button) findViewById(R.id.button3);
        listButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // this line adds the data of your EditText and puts in your array

                // next thing you have to do is check if yourarrayList adapter has changed
                adapter.notifyDataSetChanged();
            }
        });
        adapter.notifyDataSetChanged();
    }
}
