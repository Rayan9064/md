package com.example.optionmenu;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
 @Override
 protected void onCreate(Bundle
savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_main);
 }
 @Override
 public boolean onCreateOptionsMenu(Menu menu)
{

getMenuInflater().inflate(R.menu.opt_menu,menu);
 return true;
 }
 public boolean onOptionsItemSelected(@NonNull
MenuItem item)
 {
 int item_id=item.getItemId();
 if (item_id==R.id.option1) {
 Toast.makeText(this, "Opening new
file", Toast.LENGTH_SHORT).show();
 return true;
 }
 if(item_id==R.id.option2) {
 Toast.makeText(this, "Saving file",
Toast.LENGTH_SHORT).show();
return true;
 }
 if (item_id==R.id.option3) {
 Toast.makeText(this, "Searching file",
Toast.LENGTH_SHORT).show();
 return true;
 }
 return
super.onOptionsItemSelected(item);
 }
 }