package com.pattravee.mysqlapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        final TodoList editTodoList = (TodoList) getIntent().getSerializableExtra("editTodolist");
        final EditText editText = (EditText) findViewById(R.id.edit_editText);
        editText.setText(editTodoList.getTaskname());

        Button editBtn = (Button) findViewById(R.id.edit_button);
        editBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                TodoList eTodoList = new TodoList();
                eTodoList.setTaskid(editTodoList.getTaskid());
                eTodoList.setTaskname(String.valueOf(editText.getText()));
                TodoListDAO todoListDAO = new TodoListDAO(getApplicationContext());
                todoListDAO.open();
                todoListDAO.update(eTodoList);
                todoListDAO.close();
                finish();
            }
        });

        Button delBtn = (Button) findViewById(R.id.delete_button);
        delBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                TodoListDAO todoListDAODel = new TodoListDAO(getApplicationContext());
                todoListDAODel.open();
                todoListDAODel.delete(editTodoList);
                todoListDAODel.close();
                finish();


            }
        });




    }
}
