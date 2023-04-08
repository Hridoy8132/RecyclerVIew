package com.hridoy.a283recycleview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.CircularArray;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclearView;
    HashMap<String,String> hashMap;
    ArrayList<HashMap<String,String>> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclearView = findViewById(R.id.recyclearView);

        arrayList = new ArrayList<>();

        hashMap = new HashMap<>();
        hashMap.put("Video_id","Y74Z6RZoVUM");
        hashMap.put("title","চোরদের বিরুদ্ধে সময়ের সেরা গজল । Chor । চোর । Sayed Ahmad");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("Video_id","Ud-uKrFTOYg ");
        hashMap.put("title","সেলফি নিয়ে সময়ের সেরা নতুন গজল । Selfie । সেলফি । Sayed Ahmad ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("Video_id","tguAQr5eqv2Y ");
        hashMap.put("title","দা-জ্জা-ল সম্পর্কে অজানা কিছু তথ্য। আবু ত্বহা মুহাম্মাদ আদনান");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("Video_id","tMtEVal9dHcU  ");
        hashMap.put("title"," দেশের তেল,বিদ্যুৎ সংকট নিয়ে ইসলামিক সমাধান দিলেন ");
        arrayList.add(hashMap);





        MyAdapter adapter = new MyAdapter();
        recyclearView.setAdapter(adapter);
        recyclearView.setLayoutManager(new LinearLayoutManager(MainActivity.this));


    }

    //--------------------------------------------
    private class MyAdapter extends RecyclerView.Adapter <MyAdapter.myViewHolder> {

        private class myViewHolder extends RecyclerView.ViewHolder {

            ImageView imageView;
            TextView textView;

            public myViewHolder(@NonNull View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.imageView);
                textView = itemView.findViewById(R.id.textView);

            }
        }



        @NonNull
        @Override

        public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater inflater = getLayoutInflater();
            View myView = inflater.inflate(R.layout.recycle_item,parent,false);



            return new myViewHolder(myView);
        }

        @Override
        public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

             hashMap = arrayList.get(position);
             String title = hashMap.get("title");
             String video_id = hashMap.get("Video_id");
             String imgUrl = "https://img.youtube.com/vi/" +video_id + "/0.jpg";

             holder.textView.setText(title);
             Picasso.with(MainActivity.this)
                     .load("imgUrl")
                     .placeholder(R.drawable.pic)
                     .into(holder.imageView);



        }

        @Override
        public int getItemCount() {
            return arrayList.size();

        }


    }





}