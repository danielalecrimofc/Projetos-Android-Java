package com.example.checklistapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ChecklistDAO {

    SQLiteDatabase mConnection_;

    public ChecklistDAO(SQLiteDatabase mConnection) {
        mConnection_ = mConnection;
    }


    public void insert(Checklist chk) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("Description", chk.getmDescription());
        contentValues.put("Active", chk.ismActive());

        mConnection_.insertOrThrow("Checklist", null, contentValues);
    }

    public void delete(int id, SQLiteDatabase mConnection) {
        String[] params = new String[1];
        params[0] = String.valueOf(id);

        mConnection_.delete("Checklist", "ID = ?", params);
    }
    public void alter(Checklist chk) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("Description", chk.getmDescription());
        contentValues.put("Active", chk.ismActive());

        String[] params = new String[1];
        params[0] = String.valueOf(chk.getmId());

        mConnection_.update("Checklist", contentValues, "ID = ?", params);
    }
    public List<Checklist> listChecklists() {
        List<Checklist> checklists = new ArrayList<Checklist>();
        Cursor result = mConnection_.rawQuery(ScriptDLL.getChecklists(),null);
        if(result.getCount()>0){
            result.moveToFirst();
            do{
                Checklist chk = new Checklist();
                chk.setmId(result.getInt(result.getColumnIndexOrThrow("ID")));
                chk.setmDescription(result.getString(result.getColumnIndexOrThrow("Description")));
                boolean value = result.getInt(result.getColumnIndexOrThrow("Active")) > 0;
                chk.setmActive(value);
                checklists.add(chk);
            }while(result.moveToNext());
        }
        return checklists;
    }
    public Checklist getChecklist(int id) { return null; }



}
