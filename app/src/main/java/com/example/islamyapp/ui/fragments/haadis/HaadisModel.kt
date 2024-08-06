package com.example.islamyapp.ui.fragments.haadis

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class HaadisModel(val tittle: String, val content: String) : Parcelable