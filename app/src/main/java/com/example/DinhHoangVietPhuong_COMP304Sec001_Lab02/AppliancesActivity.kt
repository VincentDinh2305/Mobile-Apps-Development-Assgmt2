package com.example.DinhHoangVietPhuong_COMP304Sec001_Lab02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast

class AppliancesActivity : AppCompatActivity() {
    private val sharedPreferenceFile = "kotlinsharedpreference"

    private var checkBoxApp01: CheckBox? = null
    private var checkBoxApp02: CheckBox? = null
    private var checkBoxApp03: CheckBox? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appliances)

        checkBoxApp01 = findViewById<CheckBox>(R.id.checkBox1_app01)
        checkBoxApp02 = findViewById<CheckBox>(R.id.checkBox2_app02)
        checkBoxApp03 = findViewById<CheckBox>(R.id.checkbox3_app03)
        val checkoutBtn = findViewById<Button>(R.id.check_Out_Btn)


        val actionBar: android.app.ActionBar? = getActionBar()
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setDisplayShowHomeEnabled(true)
            actionBar.show()
        }

        var title = "Appliances"

        checkoutBtn.setOnClickListener {
            check(it);
            intent = Intent(applicationContext,CheckOutActivity::class.java)
            intent.putExtra("title",title)
            startActivity(intent)
        }
    }

    fun check(view: View?){
        val myPreference = getSharedPreferences("info", 0)

        val preferenceEditor = myPreference.edit()

        //checking and saving info from checkboxes
        val app01State = checkBoxApp01!!.isChecked
        val app02State = checkBoxApp02!!.isChecked
        val app03State = checkBoxApp03!!.isChecked

        preferenceEditor.putBoolean("app01State", app01State)
        preferenceEditor.putString("app01Name", checkBoxApp01!!.text as String?)
        preferenceEditor.putBoolean("app02State", app02State)
        preferenceEditor.putString("app02Name", checkBoxApp02!!.text as String?)
        preferenceEditor.putBoolean("app03State", app03State)
        preferenceEditor.putString("app03Name", checkBoxApp03!!.text as String?)

        preferenceEditor.commit()
        Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_product,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.m_appliances -> {
                Toast.makeText(this,"Displaying Appliances", Toast.LENGTH_SHORT).show()
                check(view = null)
                intent = Intent(applicationContext,AppliancesActivity::class.java)
                startActivity(intent)
            }
            R.id.m_TVs ->{
                Toast.makeText(this,"Displaying TVs",Toast.LENGTH_SHORT).show()
                check(view = null)
                intent = Intent(applicationContext,TVsActivity::class.java)
                startActivity(intent)
            }
            R.id.m_computers -> {
                Toast.makeText(this,"Displaying Computers",Toast.LENGTH_SHORT).show()
                check(view = null)
                intent = Intent(applicationContext,ComputersActivity::class.java)
                startActivity(intent)
            }
            R.id.m_furniture -> {
                Toast.makeText(this,"Displaying Furniture",Toast.LENGTH_SHORT).show()
                check(view = null)
                intent = Intent(applicationContext,FurnitureActivity::class.java)
                startActivity(intent)
            }
            R.id.m_Auto -> {
                Toast.makeText(this,"Displaying Auto Accessories",Toast.LENGTH_SHORT).show()
                check(view = null)
                intent = Intent(applicationContext,AutoActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}