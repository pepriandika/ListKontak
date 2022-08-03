package com.programersma.listkontak

object KontakData {
    private val namaKontak = arrayOf(
        "Adam Sandler",
        "Dwayne Johnson",
        "jennifer Aniston",
        "Jeremy Renner",
        "Mark Wahlberg",
        "Matt Damon",
        "Robert Downey",
        "Ryan Gosling",
        "Ryan Reynolds",
        "Sah Ruk Kan",
        "Salman Kan",
        "Tom Cuirse",
        "Tom Hanks",
        "Vin Diesel"
    )

    private val nomorKontak = arrayOf(
        "+8688899776623",
        "+8688899776634",
        "+8688899776656",
        "+8688899776667",
        "+8688898776678",
        "+8688899776689",
        "+8688899676690",
        "+8688897776601",
        "+8688899776612",
        "+8688856776622",
        "+8688899776633",
        "+8688899776683",
        "+8688899776663",
        "+8688899776673"
    )

    private val fotoKontak = intArrayOf(
        R.drawable.adam_sandler,
        R.drawable.dwayne_johnson,
        R.drawable.jennifer_aniston,
        R.drawable.jeremy_renner,
        R.drawable.mark_wahlberg,
        R.drawable.matt_damon,
        R.drawable.robert_downey,
        R.drawable.ryan_gosling,
        R.drawable.ryan_reynolds,
        R.drawable.sah_rukan,
        R.drawable.salman,
        R.drawable.tom_cruise,
        R.drawable.tom_hanks,
        R.drawable.vin_diesel
    )

    val listKontak : ArrayList<Kontak>
        get(){
            val list = arrayListOf<Kontak>()
                for (position in namaKontak.indices){
                    val kontak = Kontak()
                    kontak.nama = namaKontak[position]
                    kontak.detail = nomorKontak[position]
                    kontak.foto = fotoKontak[position]
                    list.add(kontak)
                }
            return list
        }
}