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

class FurnitureActivity : AppCompatActivity() {

    var checkBoxFu01:CheckBox? = null
    var checkBoxFu02:CheckBox? = null
    var checkBoxFu03:CheckBox? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_furniture)

        checkBoxFu01 = findViewById<CheckBox>(R.id.checkBox1_fu01)
        checkBoxFu02 = findViewById<CheckBox>(R.id.checkBox2_fu02)
        checkBoxFu03 = findViewById<CheckBox>(R.id.checkBox3_fu03)
        val checkoutBtn = findViewById<Button>(R.id.check_Out_Btn)

        var title = "Furniture"

        checkoutBtn.setOnClickListener {
            check(it)
            intent = Intent(applicationContext, CheckOutActivity::class.java)
            startActivity(intent)
        }
    }

    fun check(view: View?){
        val myPreference = getSharedPreferences("info", 0)
        val preferenceEditor = myPreference.edit()
        val fu01State = checkBoxFu01!!.isChecked
        val fu02State = checkBoxFu02!!.isChecked
        val fu03State = checkBoxFu03!!.isChecked
        preferenceEditor.putBoolean("fu01State", fu01State)
        preferenceEditor.putString("fu01Name", checkBoxFu01!!.text as String?)
        preferenceEditor.putBoolean("fu02State", fu02State)
        preferenceEditor.putString("fu02Name", checkBoxFu02!!.text as String?)
        preferenceEditor.putBoolean("fu03State", fu03State)
        preferenceEditor.putString("fu03Name", checkBoxFu03!!.text as String?)

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