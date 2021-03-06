package com.example.project_management_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

/**
 * Reads the elements of a task from the user then uploads the task to the database
 */
public class Add_Task extends AppCompatActivity {

    // Database references
    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference reference;

    // Create instance of database
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    // Task variables
    TextView title;
    EditText newTaskName,
             newTaskPriority,
             newTaskAssignTo,
             newTaskAssignDate,
             newTaskDescription,
             newTaskDueDate;
    Button   createTaskButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__task);

        //Set task variables
        createTaskButton   = findViewById(R.id.createTaskButton);
        title              = findViewById(R.id.title);
        newTaskName        = findViewById(R.id.newTaskName);
        newTaskPriority    = findViewById(R.id.newTaskPriority);
        newTaskAssignTo    = findViewById(R.id.newTaskAssignTo);
        newTaskAssignDate  = findViewById(R.id.newTaskAssignDate);
        newTaskDueDate     = findViewById(R.id.newTaskDueDate);
        newTaskDescription = findViewById(R.id.newTaskDescription);

        // Listener for Button Create in activity_add_task.xml
        createTaskButton.setOnClickListener(new View.OnClickListener() {
            // When Create Button is clicked this function is called
            @Override
            public void onClick(View v) {
                // Convert task elements to strings
                String taskName         = newTaskName.getText().toString();
                String taskPriority     = newTaskPriority.getText().toString();
                String taskAssignTo     = newTaskAssignTo.getText().toString();
                String taskAssignDate   = newTaskAssignDate.getText().toString();
                String taskDueDate      = newTaskDueDate.getText().toString();
                String taskDescription  = newTaskDescription.getText().toString();

                Map<String, Object> task = new HashMap<>();
                task.put("taskName",    taskName);
                task.put("priority",    taskPriority);
                task.put("assignedTo",  taskAssignTo);
                task.put("assignDate",  taskAssignDate);
                task.put("dueDate",     taskDueDate);
                task.put("description", taskDescription);

                // Add a new document with a generated ID
                db.collection("Tasks")
                        .add(task)

                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Toast.makeText(Add_Task.this, "Task Added Successfully!",
                                        Toast.LENGTH_SHORT).show();
                                //RETURN TO TASK_NEWTASK IF IT IS SUCCESSFUL
                                startActivity(new Intent(Add_Task.this, tasks_newTask.class));
                            }
                        })

                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Add_Task.this, "ERROR" +e.toString(),
                                        Toast.LENGTH_SHORT).show();
                                Log.d("TAG", "problem adding task to database!");
                            }
                        });
            }
        });
    }
}