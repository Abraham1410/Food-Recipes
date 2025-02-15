package com.example.resepmakanan

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    private lateinit var foodList: List<Food>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set the Toolbar as the Action Bar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

            // Menyiapkan data makanan
            foodList = listOf(
                Food(
                    "Ayam Karage",
                    "30 Menit",
                    getString(R.string.bahanAyam),
                    getString(R.string.prosesAyam),
                    R.drawable.ayam_karage
                ),
                Food(
                    "Ayam Terasi",
                    "40 Menit",
                    getString(R.string.bahanAyamTerasi),
                    getString(R.string.prosesAyamTerasi),
                    R.drawable.ayam_terasi
                ),
                Food(
                    "Beef Teriyaki",
                    "45 Menit",
                    getString(R.string.bahanBeefTeriyaki),
                    getString(R.string.prosesBeefTeriyaki),
                    R.drawable.beef_teriyaki
                ),
                Food(
                    "Chicken Roll",
                    "60 Menit",
                    getString(R.string.bahanChickenRoll),
                    getString(R.string.prosesChickenRoll),
                    R.drawable.chicken_roll
                ),
                Food(
                    "Daging Goreng",
                    "50 Menit",
                    getString(R.string.bahanDagingGoreng),
                    getString(R.string.prosesDagingGoreng),
                    R.drawable.daging_goreng
                ),
                Food(
                    "Ikan Goreng",
                    "30 Menit",
                    getString(R.string.bahanIkanGoreng),
                    getString(R.string.prosesIkanGoreng),
                    R.drawable.ikan_goreng
                ),
                Food(
                    "Sop Ayam",
                    "70 Menit",
                    getString(R.string.bahanSopAyam),
                    getString(R.string.prosesSopAyam),
                    R.drawable.sop_ayam
                ),
                Food(
                    "Telur Kecap",
                    "20 Menit",
                    getString(R.string.bahanTelurKecap),
                    getString(R.string.prosesTelurKecap),
                    R.drawable.telur_kecap
                ),
                Food(
                    "Udang Goreng",
                    "35 Menit",
                    getString(R.string.bahanUdangGoreng),
                    getString(R.string.prosesUdangGoreng),
                    R.drawable.udang_goreng
                ),
                Food(
                    "Udang Tiram",
                    "40 Menit",
                    getString(R.string.bahanUdangTiram),
                    getString(R.string.prosesUdangTiram),
                    R.drawable.udang_tiram
                )
            )

            // Setup RecyclerView
            val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = FoodAdapter(foodList) { selectedFood ->
                // Kirim data makanan ke DetailedActivity
                val intent = Intent(this, DetailedActivity::class.java).apply {
                    putExtra("name", selectedFood.name)
                    putExtra("time", selectedFood.time)
                    putExtra("ingredients", selectedFood.ingredients)
                    putExtra("process", selectedFood.process)
                    putExtra("imageResourceId", selectedFood.imageResourceId)
                }
                startActivity(intent)
            }
        }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu) // Memunculkan menu toolbar
        return true
    }
    // Handle action bar item clicks
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_about -> {
                // Mulai AboutActivity saat ikon diklik
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}