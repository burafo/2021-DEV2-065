package com.buraliforti.berlinuhr.presentation

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat.getDrawable
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.buraliforti.berlinuhr.R.drawable.circle_lamp
import com.buraliforti.berlinuhr.databinding.FragmentBerlinUhrBinding
import com.buraliforti.berlinuhr.models.presentation.BerlinUhrLampShapeColorModel
import com.buraliforti.berlinuhr.models.presentation.BerlinUhrShapeColorModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * [Fragment] of Berlin Uhr screen.
 */
@AndroidEntryPoint
class BerlinUhrFragment : Fragment() {

    private val viewModel: BerlinUhrViewModel by viewModels()

    private var _binding: FragmentBerlinUhrBinding? = null

    private val binding
        get() = checkNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentBerlinUhrBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getBerlinUhrScreenLiveData().observe(viewLifecycleOwner, ::setupBerlinUhrScreen)
    }

    private fun setupBerlinUhrScreen(model: BerlinUhrShapeColorModel?) {
        val contextRequired = this.context ?: return
        val secondsRowList = model?.secondsRowLamps ?: return
        val multiHoursRowList = model.multiHoursRowLamps
        val hoursRowList = model.hoursRowLamps
        val multiMinutesRowList = model.multiMinutesRowLamps
        val minutesRowList = model.minutesRowLamps
        setupSecondsRow(contextRequired, secondsRowList)
        setupMultiHoursRow(contextRequired, multiHoursRowList)
        setupHoursRow(contextRequired, hoursRowList)
        setupMultiMinutesRow(contextRequired, multiMinutesRowList)
        setupMinutesRow(contextRequired, minutesRowList)
    }

    private fun setupSecondsRow(contextRequired: Context, list: List<BerlinUhrLampShapeColorModel>) {
        val drawable = getDrawable(resources, circle_lamp, null) as GradientDrawable
        drawable.setColor(ContextCompat.getColor(contextRequired, list[0].color))
        binding.secondsLamp.background = drawable
    }

    private fun setupMultiHoursRow(contextRequired: Context, list: List<BerlinUhrLampShapeColorModel>) {
        binding.multiHoursLamp1.background = ColorDrawable(ContextCompat.getColor(contextRequired, list[0].color))
        binding.multiHoursLamp2.background = ColorDrawable(ContextCompat.getColor(contextRequired, list[1].color))
        binding.multiHoursLamp3.background = ColorDrawable(ContextCompat.getColor(contextRequired, list[2].color))
        binding.multiHoursLamp4.background = ColorDrawable(ContextCompat.getColor(contextRequired, list[3].color))
    }

    private fun setupHoursRow(contextRequired: Context, list: List<BerlinUhrLampShapeColorModel>) {
        binding.hoursLamp1.background = ColorDrawable(ContextCompat.getColor(contextRequired, list[0].color))
        binding.hoursLamp2.background = ColorDrawable(ContextCompat.getColor(contextRequired, list[1].color))
        binding.hoursLamp3.background = ColorDrawable(ContextCompat.getColor(contextRequired, list[2].color))
        binding.hoursLamp4.background = ColorDrawable(ContextCompat.getColor(contextRequired, list[3].color))
    }

    private fun setupMultiMinutesRow(contextRequired: Context, list: List<BerlinUhrLampShapeColorModel>) {
        binding.multiMinutesLamp1.background = ColorDrawable(ContextCompat.getColor(contextRequired, list[0].color))
        binding.multiMinutesLamp2.background = ColorDrawable(ContextCompat.getColor(contextRequired, list[1].color))
        binding.multiMinutesLamp3.background = ColorDrawable(ContextCompat.getColor(contextRequired, list[2].color))
        binding.multiMinutesLamp4.background = ColorDrawable(ContextCompat.getColor(contextRequired, list[3].color))
        binding.multiMinutesLamp5.background = ColorDrawable(ContextCompat.getColor(contextRequired, list[4].color))
        binding.multiMinutesLamp6.background = ColorDrawable(ContextCompat.getColor(contextRequired, list[5].color))
        binding.multiMinutesLamp7.background = ColorDrawable(ContextCompat.getColor(contextRequired, list[6].color))
        binding.multiMinutesLamp8.background = ColorDrawable(ContextCompat.getColor(contextRequired, list[7].color))
        binding.multiMinutesLamp9.background = ColorDrawable(ContextCompat.getColor(contextRequired, list[8].color))
        binding.multiMinutesLamp10.background = ColorDrawable(ContextCompat.getColor(contextRequired, list[9].color))
        binding.multiMinutesLamp11.background = ColorDrawable(ContextCompat.getColor(contextRequired, list[10].color))
    }

    private fun setupMinutesRow(contextRequired: Context, list: List<BerlinUhrLampShapeColorModel>) {
        binding.minutesLamp1.background = ColorDrawable(ContextCompat.getColor(contextRequired, list[0].color))
        binding.minutesLamp2.background = ColorDrawable(ContextCompat.getColor(contextRequired, list[1].color))
        binding.minutesLamp3.background = ColorDrawable(ContextCompat.getColor(contextRequired, list[2].color))
        binding.minutesLamp4.background = ColorDrawable(ContextCompat.getColor(contextRequired, list[3].color))
    }

    companion object {
        fun newInstance() = BerlinUhrFragment()
    }
}