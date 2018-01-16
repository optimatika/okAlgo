package org.nield.okalgo

import org.junit.Test


class OptimizationTest {

    @Test
    fun expressionsBasedModelDSL() {

        expressionsbasedmodel {

            val v1 = variable(lower = 3, upper = 6, weight = 1)
            val v2 = variable(lower = 10, upper = 12, weight = 1)

            expression(weight = 1) {
                set(v1, 1)
                set(v2, 1)
            }

            maximise()

            println("v1=${v1.value.toDouble()} v2=${v2.value.toDouble()}")
        }

    }
}
