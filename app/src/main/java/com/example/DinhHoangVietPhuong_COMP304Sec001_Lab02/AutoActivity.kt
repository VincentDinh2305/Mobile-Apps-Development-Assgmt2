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

class AutoActivity : AppCompatActivity() {
    var checkBoxAuto01: CheckBox? = null
    var checkBoxAuto02: CheckBox? = null
    var checkBoxAuto03: CheckBox? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auto)

        checkBoxAuto01 = findViewById<CheckBox>(R.id.checkBox1_auto01)
        checkBoxAuto02 = findViewById<CheckBox>(R.id.checkBox1_auto02)
        checkBoxAuto03 = findViewById<CheckBox>(R.id.cB3_townhouse)
        val checkoutBtn = findViewById<Button>(R.id.check_Out_Btn)
        var title = "Auto Accessories"

        checkoutBtn.setOnClickListener {
            check(it)
            intent = Intent(applicationContext, CheckOutActivity::class.java)
            intent.putExtra("title",title)
            startActivity(intent)
        }
    }

    fun check(view: View?) { //saving information from checkboxes to further process on checkout page
        val myPreference = getSharedPreferences("info", 0)
        val prefEditor = myPreference.edit()

        val auto01State = checkBoxAuto01!!.isChecked
        val auto02State = checkBoxAuto02!!.isChecked
        val auto03State = checkBoxAuto03!!.isChecked
        prefEditor.putBoolean("auto01State", auto01State)
        prefEditor.putString("auto01Name", checkBoxAuto01!!.text as String?)
        prefEditor.putBoolean("auto02State", auto02State)
        prefEditor.putString("auto02Name", checkBoxAuto02!!.text as String?)
        prefEditor.putBoolean("auto03State", auto03State)
        prefEditor.putString("auto03Name", checkBoxAuto03!!.text as String?)

        prefEditor.commit()
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
                Toast.makeText(this,"Displaying TVs", Toast.LENGTH_SHORT).show()
                check(view = null)
                intent = Intent(applicationContext,TVsActivity::class.java)
                startActivity(intent)
            }
            R.id.m_computers -> {
                Toast.makeText(this,"Displaying Computers", Toast.LENGTH_SHORT).show()
                check(view = null)
                intent = Intent(applicationContext,ComputersActivity::class.java)
                startActivity(intent)
            }
            R.id.m_furniture -> {
                Toast.makeText(this,"Displaying Furniture", Toast.LENGTH_SHORT).show()
                check(view = null)
                intent = Intent(applicationContext,FurnitureActivity::class.java)
                startActivity(intent)
            }
            R.id.m_Auto -> {
                Toast.makeText(this,"Displaying Auto Accessories", Toast.LENGTH_SHORT).show()
                check(view = null)
                intent = Intent(applicationContext,AutoActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
