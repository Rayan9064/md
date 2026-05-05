package com.example.readwritenew;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
package com.example.readwritenew;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
        // declare the variables
        Button read, write;
        EditText userInput;
        TextView fileContent;
        String filename = "myfile.txt"; // Define your filename here

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                // Handle system bars (optional)
                /*
                ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                        Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                        v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                        return insets;
                });
                */
                // Initialize the UI components
                read = findViewById(R.id.read_button);
                write = findViewById(R.id.write_button);
                userInput = findViewById(R.id.userInput);
                fileContent = findViewById(R.id.content);
                // Set click listeners
                read.setOnClickListener(this);
                write.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
                Button b = (Button) view;
                // Get the button text: either 'read' or 'write' depending on the button pressed
                String b_text = b.getText().toString();
                switch (b_text.toLowerCase()) {
                        case "write": {
                                writeData();
                                break;
                        }
                        case "read": {
                                readData();
                                break;
                        }
                }
        }

        private void writeData() {
                try {
                        // Write the input text to the file
                        FileOutputStream fos = openFileOutput(filename, Context.MODE_APPEND);
                        String data = userInput.getText().toString();
                        fos.write(data.getBytes());
                        fos.flush();
                        fos.close();
                } catch (IOException e) {
                        e.printStackTrace();
                }
                userInput.setText(""); // Clear the input field
                printMessage("Writing to file " + filename + " completed...");
        }

        private void readData() {
                try {
                        // Read the content of the file
                        FileInputStream fin = openFileInput(filename);
                        int a;
                        StringBuilder temp = new StringBuilder();
                        while ((a = fin.read()) != -1) {
                                temp.append((char) a);
                        }
                        // Set the file content to the TextView
                        fileContent.setText(temp.toString());
                        fin.close();
                } catch (IOException e) {
                        e.printStackTrace();
                }
                printMessage("Reading from file " + filename + " completed...");
        }

        // A simple method to print messages to the fileContent TextView
        private void printMessage(String message) {
                fileContent.append("\n" + message);
        }
}