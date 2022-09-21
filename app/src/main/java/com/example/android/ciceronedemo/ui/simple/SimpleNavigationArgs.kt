package com.example.android.ciceronedemo.ui.simple

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@JvmInline
@Parcelize
value class SimpleNavigationArgs(val backStack: List<Int>) : Parcelable