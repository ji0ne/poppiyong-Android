package net.hananet.bns2.poppiyong

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import net.hananet.bns2.poppiyong.databinding.FragmentAlertPageBinding


class FragmentAlertPage : Fragment() {

        private lateinit var binding: FragmentAlertPageBinding
        override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAlertPageBinding.inflate(inflater,container,false)
        val view = binding
        return inflater.inflate(R.layout.fragment_alert_page, container, false)
    }


}