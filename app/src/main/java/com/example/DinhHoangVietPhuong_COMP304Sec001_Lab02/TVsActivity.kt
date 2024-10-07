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

class TVsActivity : AppCompatActivity() {
    private val sharedPreferenceFile = "kotlinsharedpreference"

    var checkBoxTV01: CheckBox? = null
    var checkBoxTV02: CheckBox? = null
    var checkBoxTV03: CheckBox? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tvs)

        checkBoxTV01 = findViewById<CheckBox>(R.id.checkBox1_tv01)
        checkBoxTV02 = findViewById<CheckBox>(R.id.checkBox1_tv02)
        checkBoxTV03 = findViewById<CheckBox>(R.id.checkBox1_tv03)

        val checkoutBtn = findViewById<Button>(R.id.check_Out_Btn)
        var title = "TVs"

        checkoutBtn.setOnClickListener {
            check(it)
            intent = Intent(applicationContext, CheckOutActivity::class.java)
            intent.putExtra("title", title)
            startActivity(intent)
        }
    }

    fun check(view: View?){
        val myPreference = getSharedPreferences("info", 0)

        val preferenceEditor = myPreference.edit()
        val tv01State = checkBoxTV01!!.isChecked
        val tv02State = checkBoxTV02!!.isChecked
        val tv03State = checkBoxTV03!!.isChecked
        preferenceEditor.putBoolean("tv01State", tv01State)
        preferenceEditor.putString("tv01Name", checkBoxTV01!!.text as String?)
        preferenceEditor.putBoolean("tv02State", tv02State)
        preferenceEditor.putString("tv02Name", checkBoxTV02!!.text as String?)
        preferenceEditor.putBoolean("tv03State", tv03State)
        preferenceEditor.putString("tv03Name", checkBoxTV03!!.text as String?)
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