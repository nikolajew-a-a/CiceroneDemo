package com.example.android.ciceronedemo.ui.simple

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SimpleNavigationArgs(val number: Int, val time: Long) : Parcelable