package com.example.simulatedforbeslist;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ForbesListAdapter adapter = new ForbesListAdapter(this, makePerson());
        ListView listView = (ListView) findViewById(R.id.forbes);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = ((Person)parent.getItemAtPosition(position)).name;
                String url = "https://yandex.ru/search&q=" + name.replace(" ", "+");

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }

    Person[] makePerson() {
        String[] people = getResources().getStringArray(R.array.forbes);
        Person[] arr = new Person[people.length];

        String[] money = {"$839 B", "$257 B", "$237 B", "$224 B", "$222 B", "$190 B", "$171 B",
                "$154 B", "$149 B", "$148 B", "$146 B", "$143 B", "$141 B", "$134 B", "$126 B",
                "$125 B", "$110 B", "$109 B", "$108 B", "$100 B"};

        int[] age = {54, 52, 52, 62, 41, 81, 77, 63, 95, 89, 81, 77, 61, 76, 69, 86, 49, 84, 70,
                72};

        String[] source = {
                "Tesla, SpaceX",
                "Google",
                "Google",
                "Amazon",
                "Facebook",
                "Oracle",
                "LVMH",
                "Semiconductors",
                "Berkshire Hathaway",
                "Zara",
                "Walmart",
                "Walmart",
                "Dell Technologies",
                "Walmart",
                "Microsoft",
                "Telecom",
                "Cryptocurrency exchange",
                "Bloomberg LP",
                "Microsoft",
                "L'Oréal"};

        String[] contry ={
                "United States",
                "United States",
                "United States",
                "United States",
                "United States",
                "United States",
                "France",
                "United States",
                "United States",
                "Spain",
                "United States",
                "United States",
                "United States",
                "United States",
                "United States",
                "Mexico",
                "Canada",
                "United States",
                "United States",
                "France",
        };

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Person(people[i], money[i], age[i], source[i], contry[i]);

        }
        return arr;
    }
}