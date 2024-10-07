package com.example.DinhHoangVietPhuong_COMP304Sec001_Lab02

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class CheckOutActivity : AppCompatActivity() {
    private val sharedPreferenceFile = "kotlinsharedpreference"
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_out)

        val sharedPreferences: SharedPreferences = this.getSharedPreferences(sharedPreferenceFile, Context.MODE_PRIVATE)

        clearSharedPreferences()
        val selectProduct = findViewById<View>(R.id.selectHouse) as TextView
        selectProduct.visibility = View.INVISIBLE
        val nextBtn = findViewById<Button>(R.id.nextBtn)

        val titleTextView = findViewById<TextView>(R.id.tV)

        val myPreference = getSharedPreferences("info", MODE_PRIVATE)
        val app01State = myPreference.getBoolean("condo1State", false)
        val app01Name = myPreference.getString("app01Name", "")
        val app02State = myPreference.getBoolean("app02State", false)
        val app02Name = myPreference.getString("app02Name", "")
        val app03State = myPreference.getBoolean("app03State", false)
        val app03Name = myPreference.getString("app03Name", "")

        val tv01State = myPreference.getBoolean("tv01State", false)
        val tv01Name = myPreference.getString("tv01Name", "")
        val tv02State = myPreference.getBoolean("tv02State", false)
        val tv02Name = myPreference.getString("tv02Name", "")
        val tv03State = myPreference.getBoolean("tv03State", false)
        val tv03Name = myPreference.getString("tv03Name", "")

        val laptop01State = myPreference.getBoolean("laptop01State", false)
        val laptop01Name = myPreference.getString("laptop01Name", "")
        val laptop02State = myPreference.getBoolean("laptop02State", false)
        val laptop02Name = myPreference.getString("laptop02Name", "")
        val laptop03State = myPreference.getBoolean("laptop03State", false)
        val laptop03Name = myPreference.getString("laptop03Name", "")

        val fu01State = myPreference.getBoolean("fu01State", false)
        val fu01Name = myPreference.getString("fu01Name", "")
        val fu02State = myPreference.getBoolean("fu02State", false)
        val fu02Name = myPreference.getString("fu02Name", "")
        val fu03State = myPreference.getBoolean("fu03State", false)
        val fu03Name = myPreference.getString("fu03Name", "")

        val auto01State = myPreference.getBoolean("auto01State", false)
        val auto01Name = myPreference.getString("auto01Name", "")
        val auto02State = myPreference.getBoolean("auto02State", false)
        val auto02Name = myPreference.getString("auto02Name", "")
        val auto03State = myPreference.getBoolean("auto03State", false)
        val auto03Name = myPreference.getString("auto03Name", "")


        var options_exist = false // to check whether there are selected options at all
        val rg = findViewById<View>(R.id.radioGroupCombo) as RadioGroup

        //checking every checkbox and adding radio button if it's checked
        if (app01State) {
            val rb1 = RadioButton(this)
            rb1.setText(app01Name)
            rb1.id = 1
            val params = RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT
            )
            rg.addView(rb1, params)
            options_exist = true
        }
        if (app02State) {
            val rb2 = RadioButton(this)
            rb2.setText(app02Name)
            rb2.id = 2
            val params = RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT
            )
            rg.addView(rb2, params)
            options_exist = true
        }

        if (app03State) {
            val rb12 = RadioButton(this)
            rb12.setText(app03Name)
            rb12.id = 12
            val params = RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT
            )
            rg.addView(rb12, params)
            options_exist = true
        }

        if (tv01State) {
            val rb3 = RadioButton(this)
            rb3.setText(tv01Name)
            rb3.id = 3
            val params = RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT
            )
            rg.addView(rb3, params)
            options_exist = true
        }
        if (tv02State) {
            val rb4 = RadioButton(this)
            rb4.setText(tv02Name)
            rb4.id = 4
            val params = RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT
            )
            rg.addView(rb4, params)
            options_exist = true
        }

        if (tv03State) {
            val rb14 = RadioButton(this)
            rb14.setText(tv03Name)
            rb14.id = 14
            val params = RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT
            )
            rg.addView(rb14, params)
            options_exist = true
        }

        if (laptop01State) {
            val rb5 = RadioButton(this)
            rb5.setText(laptop01Name)
            rb5.id = 5
            val params = RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT
            )
            rg.addView(rb5, params)
            options_exist = true
        }

        if (laptop02State) {
            val rb6 = RadioButton(this)
            rb6.setText(laptop02Name)
            rb6.id = 6
            val params = RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT
            )
            rg.addView(rb6, params)
            options_exist = true
        }

        if (laptop03State) {
            val rb11 = RadioButton(this)
            rb11.setText(laptop03Name)
            rb11.id = 11
            val params = RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT
            )
            rg.addView(rb11, params)
            options_exist = true
        }

        if (fu01State) {
            val rb7 = RadioButton(this)
            rb7.setText(fu01Name)
            rb7.id = 7
            val params = RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT
            )
            rg.addView(rb7, params)
            options_exist = true
        }

        if (fu02State) {
            val rb8 = RadioButton(this)
            rb8.setText(fu02Name)
            rb8.id = 8
            val params = RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT
            )
            rg.addView(rb8, params)
            options_exist = true
        }

        if (fu03State) {
            val rb13 = RadioButton(this)
            rb13.setText(fu03Name)
            rb13.id = 13
            val params = RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT
            )
            rg.addView(rb13, params)
            options_exist = true
        }

        if (auto01State) {
            val rb9 = RadioButton(this)
            rb9.setText(auto01Name)
            rb9.id = 9
            val params = RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT
            )
            rg.addView(rb9, params)
            options_exist = true
        }

        if (auto02State) {
            val rb10 = RadioButton(this)
            rb10.setText(auto02Name)
            rb10.id = 10
            val params = RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT
            )
            rg.addView(rb10, params)
            options_exist = true
        }

        if (auto03State) {
            val rb15 = RadioButton(this)
            rb15.setText(auto03Name)
            rb15.id = 15
            val params = RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT
            )
            rg.addView(rb15, params)
            options_exist = true
        }

        if (!options_exist) {
            nextBtn.visibility = View.INVISIBLE
            selectProduct.visibility = View.VISIBLE
        }

        nextBtn.setOnClickListener {
            if (options_exist==false){
                Toast.makeText(applicationContext,"Please select atleast one", Toast.LENGTH_SHORT).show()
            }else{
                intent = Intent(applicationContext,PaymentActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun clearSharedPreferences() {
        // Clear the shared preferences file
        val sharedPref = getSharedPreferences(sharedPreferenceFile, Context.MODE_PRIVATE)
        sharedPref.edit().clear().apply()
    }
}