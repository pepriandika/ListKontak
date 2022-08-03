package com.programersma.listkontak

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Kontak (
    var nama : String = "aaa",
    var detail : String = "aaa",
    var foto : Int = 0
):Parcelable
