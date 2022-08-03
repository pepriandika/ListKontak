package com.programersma.listkontak


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.programersma.listkontak.R




class MainActivity : AppCompatActivity() {
    private lateinit var rvKontak: RecyclerView
    private var list: ArrayList<Kontak> = arrayListOf()

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.tentangku, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }
    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.tombolTengtangku -> {
                val moveIntent = Intent(this@MainActivity, ActivityTentangku::class.java)
                startActivity(moveIntent)
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvKontak = findViewById(R.id.rv_kontak)
        rvKontak.setHasFixedSize(true)

        list.addAll(KontakData.listKontak)
        showRecyclerList()



    }
    private fun showSelectedHero(kontak: Kontak) {

            val phoneNumber = kontak.detail
            val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
            startActivity(dialPhoneIntent)

        Toast.makeText(this, "Kamu memilih kontak " + kontak.nama, Toast.LENGTH_SHORT).show()
    }

    private fun showRecyclerList() {
        rvKontak.layoutManager = LinearLayoutManager(this)
        val listKontakAdapter = ListKontakAdapter(list){
            Intent(this,Activity2::class.java).apply {
                putExtra("kontak",it)
                startActivity(this)
            }
        }
        rvKontak.adapter = listKontakAdapter
        listKontakAdapter.setOnItemClickCallback(object : ListKontakAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Kontak) {
                showSelectedHero(data)
            }
        })
    }
}



