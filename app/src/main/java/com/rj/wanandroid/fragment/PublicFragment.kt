package com.rj.wanandroid.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.rj.wanandroid.databinding.FragmentPublicBinding

class PublicFragment:Fragment() {
    private var _binding: FragmentPublicBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if(_binding==null){
            _binding= FragmentPublicBinding.inflate(inflater)
        }
        return _binding?.root
    }
}