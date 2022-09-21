package com.example.android.ciceronedemo.util

import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.showToast(message: String) = Toast.makeText(this.context, message, Toast.LENGTH_LONG).show()
