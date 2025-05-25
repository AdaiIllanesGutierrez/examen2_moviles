package com.ucb.ucbtest.home

import androidx.lifecycle.ViewModel
import com.ucb.ucbtest.home.model.Plan
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel : ViewModel() {
    private val planes = listOf(
        Plan("Plan FLEX 5", "$270", "$199", "5GB", listOf(
            "Llamadas y SMS ilimitados",
            "Hotspot. Comparte tus datos",
            "Redes Sociales ilimitadas incluidas",
            "Arma tu plan con más apps ilimitadas",
            "CO2 Negativo"
        )),
        Plan("Plan FLEX 8", "$370", "$299", "8GB", listOf(
            "Llamadas y SMS ilimitados",
            "Hotspot. Comparte tus datos",
            "Redes Sociales ilimitadas incluidas",
            "Arma tu plan con más apps ilimitadas",
            "CO2 Negativo"
        )),
        Plan("Plan FLEX 10", "$470", "$399", "10GB", listOf(
            "Llamadas y SMS ilimitados",
            "Hotspot. Comparte tus datos",
            "Redes Sociales ilimitadas incluidas",
            "Arma tu plan con más apps ilimitadas",
            "CO2 Negativo"
        ))
    )

    private var index = 0
    private val _currentPlan = MutableStateFlow(planes[index])
    val currentPlan: StateFlow<Plan> = _currentPlan

    fun nextPlan() {
        index = (index + 1) % planes.size
        _currentPlan.value = planes[index]
    }

    fun prevPlan() {
        index = if (index - 1 < 0) planes.size - 1 else index - 1
        _currentPlan.value = planes[index]
    }
}
