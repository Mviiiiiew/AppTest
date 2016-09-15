package com.manzx.myapplication.Database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.manzx.myapplication.R;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    ListView todoListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        todoListView = (ListView)findViewById(R.id.todo_ListView);

        TodoListDAO todoListDAO = new TodoListDAO(getApplicationContext());
        todoListDAO.open();
        ArrayList<String> myList = todoListDAO.getAllTodoList();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myList);

        todoListView.setAdapter(adapter);
        todoListDAO.close();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
