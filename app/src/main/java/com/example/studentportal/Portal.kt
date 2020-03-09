package com.example.studentportal

import android.net.Uri
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Portal (
    var name: String,
    var link: Uri
) : Parcelable {
    companion object  {
        val PORTAL_NAMES = arrayOf(
            "Brightspace",
            "Roosters",
            "Sis",
            "HvA"
        )
        val PORTAL_LINKS = arrayOf<Uri>(
            Uri.parse("https://dlo.mijnhva.nl"),
            Uri.parse("https://roosters.hva.nl"),
            Uri.parse("https://sis.hva.nl"),
            Uri.parse("https://hva.nl")
        )
    }
}