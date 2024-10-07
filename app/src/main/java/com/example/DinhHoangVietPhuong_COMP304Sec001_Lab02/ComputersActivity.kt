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

class ComputersActivity : AppCompatActivity() {

    var checkBoxLaptop01:CheckBox? = null
    var checkBoxLaptop02:CheckBox? = null
    var checkBoxLaptop03:CheckBox? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_computers)
        checkBoxLaptop01 = findViewById<CheckBox>(R.id.checkBox1_lap01)
        checkBoxLaptop02 = findViewById<CheckBox>(R.id.checkBox2_lap02)
        checkBoxLaptop03 = findViewById<CheckBox>(R.id.checkbox3_lap03)
        val checkoutBtn = findViewById<Button>(R.id.check_Out_Btn)
        var title = "Computers"

        checkoutBtn.setOnClickListener {
            check(it)
            intent = Intent(applicationContext, CheckOutActivity::class.java)
            intent.putExtra("title",title)
            startActivity(intent)
        }
    }

    fun check(view: View?) { //saving information from checkboxes to further process on checkout page
        val myPreference = getSharedPreferences("info", 0)
        val preferenceEditor = myPreference.edit()

        val laptop01State = checkBoxLaptop01!!.isChecked
        val laptop02State = checkBoxLaptop02!!.isChecked
        val laptop03State = checkBoxLaptop03!!.isChecked
        preferenceEditor.putBoolean("laptop01State", laptop01State)
        preferenceEditor.putString("laptop01Name", checkBoxLaptop01!!.text as String?)
        preferenceEditor.putBoolean("laptop02State", laptop02State)
        preferenceEditor.putString("laptop02Name", checkBoxLaptop02!!.text as String?)
        preferenceEditor.putBoolean("laptop03State", laptop03State)
        preferenceEditor.putString("laptop03Name", checkBoxLaptop03!!.text as String?)

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