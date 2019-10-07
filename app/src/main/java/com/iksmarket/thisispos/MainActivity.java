package com.iksmarket.thisispos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.iksmarket.thisispos.adapter.ReceiptAdapter;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    List<ItemForReceipt> items;
    RecyclerView receiptView;
    FloatingActionButton fab;
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fab = findViewById(R.id.fabBtn);
        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        navigationView = findViewById(R.id.navigation);



        receiptView = findViewById(R.id.mainRecycler);
        final Intent intent = new Intent(this, SimpleScannerActivity.class);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Pressed", Toast.LENGTH_SHORT).show();
                    startActivityForResult(intent, 1);
            }
        });

       LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
       receiptView.setLayoutManager(linearLayoutManager);
       initializeData();
       initializeAdapter();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }
        Toast.makeText(this, "Добавленно", Toast.LENGTH_SHORT).show();
        if (data.getStringExtra("name").equals("6901443120598")){
            items.add(new ItemForReceipt("Хуевей модем", data.getStringExtra("barcode")));
        }
        findUsingEnhancedForLoop("Хуевей модем", items);
        initializeAdapter();
    }

    public void findUsingEnhancedForLoop(
            String name, List<ItemForReceipt> items) {

        for (ItemForReceipt customer : items) {
            if (customer.getName().equals(name)) {



            }
        }
        System.out.println("Nothing");
    }




    private void initializeAdapter() {

        ReceiptAdapter receiptAdapter = new ReceiptAdapter(items);
        receiptView.setAdapter(receiptAdapter);
    }

    private void initializeData() {
        items = new ArrayList<>();


    }
}
