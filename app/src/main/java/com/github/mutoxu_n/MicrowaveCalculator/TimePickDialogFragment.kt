package com.github.mutoxu_n.MicrowaveCalculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.NumberPicker
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class TimePickDialogFragment(private var min: Int, private var sec: Int) : BottomSheetDialogFragment() {
    private lateinit var npMin: NumberPicker
    private lateinit var npSec: NumberPicker

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,  savedInstanceState: Bundle?): View {
        val v: View = inflater.inflate(R.layout.time_pick_layout, container, false)

        // formatting
        if(sec >= 60) {
            min += 1
            sec -= 60
        }

        // min number picker
        npMin = v.findViewById(R.id.npMin)
        npMin.minValue = 0
        npMin.maxValue = 60
        npMin.value = min

        // sec number picker
        npSec = v.findViewById(R.id.npSec)
        npSec.minValue = 0
        npSec.maxValue = 59
        npSec.value = sec

        return v
    }

    override fun onDestroy() {
        val a = activity as MainActivity
        a.onReturnTimeValue(npMin.value, npSec.value)
        super.onDestroy()
    }
}