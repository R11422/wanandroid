package com.ruijie.setting.fragment

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.rj.moudle_base.SimpleBindingHolder
import com.rj.wanandroid.databinding.TabCustomViewBinding
import com.ruijie.base.tools.DimensionTools


class SettingTabAdapter(private var mData: ArrayList<Triple<Int, Int,Int>>,
                        private var selectIndex: Int = 0) : RecyclerView.Adapter<SimpleBindingHolder<TabCustomViewBinding>>() {

    private val iconSize = DimensionTools.dp2px(16f)

    private var mSelectListener: ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleBindingHolder<TabCustomViewBinding> {
        val binding = TabCustomViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        binding.root.setOnClickListener { view ->
            view.tag?.apply {
                val position = this as Int
                if (position != selectIndex) {
                    selectIndex = position
                    notifyDataSetChanged()
                    mSelectListener?.invoke(mData[position].third)
                }
            }
        }
        return SimpleBindingHolder(binding)
    }

    override fun getItemCount() = mData.size

    fun setOnSelectListener(listener: (Int) -> Unit) {
        this.mSelectListener = listener
    }

    override fun onBindViewHolder(holder: SimpleBindingHolder<TabCustomViewBinding>, position: Int) {
        holder.binding.apply {
            val itemData = mData[position]
            val icon = ContextCompat.getDrawable(root.context, itemData.first)
            icon!!.setBounds(0, 0, iconSize, iconSize)
            tvSettingsTab.setCompoundDrawables(null, icon, null, null)
            tvSettingsTab.setText(itemData.second)
            if (selectIndex == position) {
                tvSettingsTab.isChecked = true
                //flTabRoot.setBackgroundResource(R.drawable.bg_settings_tab_checked)
            } else {
                tvSettingsTab.isChecked = false
                flTabRoot.setBackgroundColor(Color.TRANSPARENT)
            }
            root.tag = position
        }
    }

}