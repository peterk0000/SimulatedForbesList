package com.example.simulatedforbeslist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ForbesListAdapter extends ArrayAdapter<Person> {
    public ForbesListAdapter(Context context, Person[] arr) {
        super(context, R.layout.list_item, arr);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Person person = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, null);
        }

        String n = person.name.toLowerCase();
        String imagePerson = n.replace(" ", "_");
        int idImagePerson = getContext().getResources().getIdentifier(imagePerson,
                "drawable", getContext().getPackageName());

        String f = person.contry.toLowerCase();
        String flag = "flag_" + f.replace(" ", "_");
        int idFlag = getContext().getResources().getIdentifier(flag, "drawable",
                getContext().getPackageName());

        ((ImageView) convertView.findViewById(R.id.imagePerson)).setImageResource(idImagePerson);

        ((TextView) convertView.findViewById(R.id.name)).setText(person.name);
        ((TextView) convertView.findViewById(R.id.money)).setText("Money: " + person.money);
        ((TextView) convertView.findViewById(R.id.age)).setText("Age: " + person.age);
        ((TextView) convertView.findViewById(R.id.source)).setText("Source: " + person.source);
        ((TextView) convertView.findViewById(R.id.contry)).setText("Contry: " + person.contry);

        ((ImageView) convertView.findViewById(R.id.flag)).setImageResource(idFlag);

        return convertView;
    }
}
