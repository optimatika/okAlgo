package org.nield.okalgo

import org.junit.Test
import org.ojalgo.optimisation.ExpressionsBasedModel


class OptimizationTest {

    @Test
    fun expressionsBasedModelDSL() {

        val model = ExpressionsBasedModel()

        val v1 = model.variable(lower = 3, upper = 6)
        val v2 = model.variable(lower = 10, upper = 12)

        model.expression(weight=1) {
            set(v1, 1)
            set(v2, 1)
        }

        model.maximise()

        println("v1=${v1.value.toDouble()} v2=${v2.value.toDouble()}")

    }
}
