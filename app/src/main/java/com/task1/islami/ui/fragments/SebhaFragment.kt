package com.task1.islami.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.task1.islami.R

class SebhaFragment : Fragment() {

    lateinit var sebha: ImageView
    lateinit var zekrNumber: TextView
    lateinit var zekrName: TextView
    var counterToCountNumperOfZekr: Int = 0 // To Change The Zekr When arrive 5

    companion object {
        var counterToZekrNumber: Int = 1
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.sebha_fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sebha = view.findViewById(R.id.body_Of_Sebha)
        zekrNumber = view.findViewById(R.id.number_Of_Zekr)
        zekrName = view.findViewById(R.id.name_Of_Zekr)



        sebha.setOnClickListener {

            sebha.rotation = sebha.rotation + 10

            counterToCountNumperOfZekr++
            zekrNumber.setText("${counterToCountNumperOfZekr}")
            if (counterToCountNumperOfZekr == 33) {
                counterToCountNumperOfZekr = 0
                final()
            }


        }

    }


    fun final() {

        if (counterToZekrNumber == 1) {
            zekrName.setText("الحمدلله")
            counterToZekrNumber++
        } else if (counterToZekrNumber == 2) {
            zekrName.setText("لا اله إلا الله")
            counterToZekrNumber++
        } else if (counterToZekrNumber == 3) {
            zekrName.setText("الله أكبر")
            counterToZekrNumber++
        } else {
            zekrName.setText(" سبحان الله")
            counterToZekrNumber = 1
        }
    }


}





