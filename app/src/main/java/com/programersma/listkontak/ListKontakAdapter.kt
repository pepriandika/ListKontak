package com.programersma.listkontak


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.programersma.listkontak.R
import com.programersma.listkontak.KontakData.listKontak

class ListKontakAdapter(private val daftarKontak: ArrayList<Kontak>,
                        private val listener : (Kontak) -> Unit
                        ):
    RecyclerView.Adapter<ListKontakAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_kontak,parent,false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val kontak = daftarKontak[position]

        Glide.with(holder.itemView.context)
            .load(kontak.foto)
            .apply(RequestOptions().override(55,55))
            .into(holder.imageViewFoto)

        holder.textViewNama.text = kontak.nama
        holder.textViewNomor.text = kontak.detail

        //pas di klik laju
        holder.itemView.setOnClickListener {
            listener(daftarKontak[position])
        }
        holder.tombolCall.setOnClickListener{
            onItemClickCallback.onItemClicked(listKontak[holder.adapterPosition])
        }


    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Kontak)
    }

    override fun getItemCount(): Int {
        return  listKontak.size
    }


    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textViewNama : TextView = itemView.findViewById(R.id.nama_kontak)
        var textViewNomor : TextView = itemView.findViewById(R.id.nomor_kotak)
        var imageViewFoto : ImageView = itemView.findViewById(R.id.photo_kontak)
        var tombolCall : ImageButton = itemView.findViewById(R.id.imageButton)
    }
}