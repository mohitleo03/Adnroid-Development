package com.example.cust_list_view2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     ListView listView;
     String mTitle[]={"Running","Cross Trainer","Jumping Jacks","Squats","PushUps"};
     String mDescription[]={"A smart running warmup gives your muscles, bones, and joints a chance to loosen up \n \n" +
             "Time Duration = 5-10 min","Boost your stamina and cardio capacity,Put less stress on your joints" +
             "Time Duration = 2-5 min","offer cardiovascular benefits,balances out your heart rate,increases blood circulation," +
             "controls & maintains blood pressure, helps in doing away with bad cholesterol levels in the body" +
             "Time Duration = 1-2 min","Strengthens your core,Crushes calories,Strengthens the muscles of your lower body." +
             "Repetitions = 15-25","Traditional PushUps are beneficial for building upper body strength. They work the triceps," +
             " pectoral muscles, and shoulders.if its too easy for you try burpees\n\n" +
             "Repetitions = 15-30"};
     int images[] = {R.drawable.running,R.drawable.cross_trainer,R.drawable.jumping_jacks,R.drawable.squats,R.drawable.pushups};
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listView);
        MyAdaptor adaptor=new MyAdaptor(this,mTitle,mDescription,images);
        listView.setAdapter(adaptor);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?>parent,View view,int position,long id) {
                if (position == 0){
                    Toast.makeText(MainActivity.this, "Running", Toast.LENGTH_SHORT).show();
                }
                if (position == 1){
                    Toast.makeText(MainActivity.this, "Cross Trainer", Toast.LENGTH_SHORT).show();
                }
                if (position == 2){
                    Toast.makeText(MainActivity.this, "Jumping Jacks", Toast.LENGTH_SHORT).show();
                }
                if (position == 3){
                    Toast.makeText(MainActivity.this, "Squats", Toast.LENGTH_SHORT).show();
                }
                if (position == 4){
                    Toast.makeText(MainActivity.this, "PushUps", Toast.LENGTH_SHORT).show();
                }
            }
        });
     }
    class MyAdaptor extends ArrayAdapter<String>{
         Context context;
         String rTitle[];
         String rDesription[];
         int rImage[];
         MyAdaptor (Context c,String title[],String description[],int images[]){
             super(c,R.layout.row,R.id.testView1,title);
             this.context=c;
             this.rTitle=title;
             this.rImage=images;
             this.rDesription=description;

         }
         @NonNull
         @Override
         public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent){
             LayoutInflater layoutInflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
             View row=layoutInflater.inflate(R.layout.row,parent,false);
             ImageView images=row.findViewById(R.id.image);
             TextView myTitle=row.findViewById(R.id.testView1);
             TextView myDescription=row.findViewById(R.id.testView2);
             images.setImageResource(rImage[position]);
             myTitle.setText(rTitle[position]);
             myDescription.setText(rDesription[position]);
             return row;
         }
    }
}