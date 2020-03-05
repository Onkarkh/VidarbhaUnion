package com.example.vidarbhaunion.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.vidarbhaunion.R;
import com.example.vidarbhaunion.donation.Donation;

import java.util.ArrayList;

public class Home extends Fragment {

    private static final String TAG = "Home";
    private ArrayList<String> title;
    private ArrayList<Integer> images;

    private Button fundsButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        GridView gridView = view.findViewById(R.id.donationGridView);

        fundsButton = view.findViewById(R.id.partyFunds);

        title = new ArrayList<>();
        title.add("Food");
        title.add("Cloths");
        title.add("Medicine");
        title.add("Books");

        images = new ArrayList<>();
        images.add(R.drawable.fruit);
        images.add(R.drawable.fashion);
        images.add(R.drawable.pill);
        images.add(R.drawable.diary);

        gridView.setAdapter(new SetData());

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                String title;
                switch (position){
                    case 0:
                        title = "Food Donation";
                        bundle.putString("title",title);
                        bundle.putInt("array",R.array.food_item);
                        break;
                    case 1:
                        title = "Cloth Donation";
                        bundle.putString("title",title);
                        bundle.putInt("array",R.array.cloth_item);
                        break;
                    case 2:
                        title = "Medicine Donation";
                        bundle.putString("title",title);
                        bundle.putInt("array",R.array.medicine_item);
                        break;
                    case 3:
                        title = "Books Donation";
                        bundle.putString("title",title);
                        bundle.putInt("array",R.array.book_item);
                        break;
                }

                Fragment donation = new Donation();
                donation.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.mainFrame,donation).commit();
            }
        });

        fundsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toastMessage("Coming Soon!");
            }
        });

        return view;
    }

    private void toastMessage(String s) {
        Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
    }

    private class SetData extends BaseAdapter {
        @Override
        public int getCount() {
            return title.size();
        }

        @Override
        public Object getItem(int position) {
            return title.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.item_donation_layout,null);

            imageView = view.findViewById(R.id.image);
            imageView.setImageResource(images.get(position));
            return view;
        }
    }
}
