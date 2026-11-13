
package com.angelcloud.app

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.view.View
import android.widget.*

class MainActivity : Activity() {

    private val bg = Color.rgb(12, 16, 32)
    private val card = Color.rgb(27, 34, 57)
    private val purple = Color.rgb(155, 90, 255)
    private val white = Color.WHITE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showDashboard()
    }

    private fun dp(value: Int): Int =
        (value * resources.displayMetrics.density).toInt()

    private fun showDashboard() {
        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(bg)
        }

        val scroll = ScrollView(this)
        val content = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(dp(20), dp(25), dp(20), dp(30))
        }

        val title = TextView(this).apply {
            text = "☁ ANGEL CLOUD"
            textSize = 27f
            typeface = Typeface.DEFAULT_BOLD
            setTextColor(white)
        }
        content.addView(title)

        val welcome = TextView(this).apply {
            text = "Your Cloud Gaming World"
            textSize = 15f
            setTextColor(Color.LTGRAY)
            setPadding(0, dp(8), 0, dp(22))
        }
        content.addView(welcome)

        val balance = TextView(this).apply {
            text = "YOUR PLAYTIME\n\n0 Minutes Available"
            textSize = 21f
            gravity = Gravity.CENTER
            typeface = Typeface.DEFAULT_BOLD
            setTextColor(white)
            setBackgroundColor(card)
            setPadding(dp(15), dp(25), dp(15), dp(25))
        }
        content.addView(balance)

        heading(content, "Gaming Dashboard")

        addButton(content, "🎮  Browse Games") {
            showGames()
        }

        addButton(content, "👤  Player Account") {
            showPlayer()
        }

        heading(content, "Earn Playtime")

        addButton(content, "▶  Watch YouTube Channel") {
            Toast.makeText(
                this,
                "YouTube reward system will be connected later.",
                Toast.LENGTH_LONG
            ).show()
        }

        addButton(content, "⭐  Subscribe & Get Reward") {
            Toast.makeText(
                this,
                "Subscription verification will be added later.",
                Toast.LENGTH_LONG
            ).show()
        }

        heading(content, "Administration")

        addButton(content, "🔐  Owner Panel") {
            showOwner()
        }

        val footer = TextView(this).apply {
            text = "\nANGEL CLOUD © 2026\nCloud Gaming Platform"
            gravity = Gravity.CENTER
            textSize = 13f
            setTextColor(Color.LTGRAY)
        }
        content.addView(footer)

        scroll.addView(content)
        root.addView(
            scroll,
            LinearLayout.LayoutParams(-1, 0, 1f)
        )

        setContentView(root)
    }

    private fun heading(parent: LinearLayout, text: String) {
        val view = TextView(this).apply {
            this.text = text
            textSize = 20f
            typeface = Typeface.DEFAULT_BOLD
            setTextColor(white)
            setPadding(0, dp(25), 0, dp(12))
        }
        parent.addView(view)
    }

    private fun addButton(
        parent: LinearLayout,
        text: String,
        action: () -> Unit
    ) {
        val button = Button(this).apply {
            this.text = text
            textSize = 15f
            setTextColor(white)
            setBackgroundColor(purple)
            isAllCaps = false
            setOnClickListener { action() }
        }

        val params = LinearLayout.LayoutParams(
            -1, dp(55)
        )
        params.bottomMargin = dp(10)
        parent.addView(button, params)
    }

    private fun showGames() {
        val names = arrayOf(
            "Cloud Game 01",
            "Cloud Game 02",
            "Cloud Game 03"
        )

        val builder = android.app.AlertDialog.Builder(this)
        builder.setTitle("🎮 Angel Cloud Games")
        builder.setItems(names) { _, which ->
            Toast.makeText(
                this,
                "Cloud streaming will be connected later.",
                Toast.LENGTH_LONG
            ).show()
        }
        builder.setNegativeButton("Back", null)
        builder.show()
    }

    private fun showPlayer() {
        android.app.AlertDialog.Builder(this)
            .setTitle("Player Account")
            .setMessage(
                "Player account\n\n" +
                "Available Playtime: 0 Minutes\n\n" +
                "Account login will be added in the next stage."
            )
            .setPositiveButton("OK", null)
            .show()
    }

    private fun showOwner() {
        android.app.AlertDialog.Builder(this)
            .setTitle("Owner Panel")
            .setMessage(
                "ANGEL CLOUD OWNER\n\n" +
                "• Manage Games\n" +
                "• Manage Player Accounts\n" +
                "• Set Daily Playtime\n" +
                "• Manage YouTube Rewards\n\n" +
                "Secure owner authentication will be added later."
            )
            .setPositiveButton("OK", null)
            .show()
    }
}

