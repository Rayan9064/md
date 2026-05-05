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

public class MainActivity extends
AppCompatActivity implements View.OnClickListener
{
 // declare the variables
 Button read, write;
 EditText userInput;
 TextView fileContent;
 String filename = "myfile.txt"; // Define
your filename here
 @Override
 protected void onCreate(Bundle
savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_main);
 // Handle system bars (optional)
 /*

ViewCompat.setOnApplyWindowInsetsListener(findView
ById(R.id.main), (v, insets) -> {
 Insets systemBars =
insets.getInsets(WindowInsetsCompat.Type.systemBar
s());

v.setPadding(systemBars.left,
systemBars.top, systemBars.right,
systemBars.bottom);
 return insets;
 });*/
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
 // Get the button text: either 'read' or
'write' depending on the button pressed
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
 FileOutputStream fos =
openFileOutput(filename, Context.MODE_APPEND);
 String data =
userInput.getText().toString();
 fos.write(data.getBytes());
 fos.flush();
 fos.close();
 } catch (IOException e) {
 e.printStackTrace();
 }
 userInput.setText(""); 

 // Clear the input field
 printMessage("Writing to file " + filename + " completed...\");\r\n" + //
        " }\r\n" + //
        " private void readData() {\r\n" + //
        " try {\r\n" + //
        " // Read the content of the file\r\n" + //
        " FileInputStream fin =\r\n" + //
        "openFileInput(filename);\r\n" + //
        " int a;\r\n" + //
        " StringBuilder temp = new\r\n" + //
        "StringBuilder();\r\n" + //
        " while ((a = fin.read()) != -1) {\r\n" + //
        " temp.append((char) a);\r\n" + //
        " }\r\n" + //
        " // Set the file content to the\r\n" + //
        "TextView\r\n" + //
        " fileContent.setText(temp.toString());\r\n" + //
        " fin.close();\r\n" + //
        " } catch (IOException e) {\r\n" + //
        " e.printStackTrace();\r\n" + //
        " }\r\n" + //
        " printMessage(\"Reading from file \" +\r\n" + //
        "filename + \" completed...\");\r\n" + //
        " }\r\n" + //
        // A simple method to print messages to the
fileContent TextView
 private void printMessage(String message) {
 fileContent.append("\n" + message);
 }
}