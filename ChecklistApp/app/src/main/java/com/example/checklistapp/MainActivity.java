package com.example.checklistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase mConnection;
    private DatabaseHelper mDataHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createConnection();
    }

    private void createConnection() {
        try {
            mDataHelper = new DatabaseHelper(this.getApplicationContext());
            mConnection = mDataHelper.getWritableDatabase();
            Toast.makeText(this, "Conexão realizada com sucesso!", Toast.LENGTH_SHORT).show();
        } catch(SQLException e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

}