package org.nield.okalgo

import org.junit.Test


class OptimizationTest {

    @Test
    fun expressionsBasedModelDSL() {

        expressionsbasedmodel {

            val v1 = variable(lower = 3, upper = 6)
            val v2 = variable(lower = 10, upper = 12)

            objective {
                set(v1, 1)
                set(v2, 1)
            }

            val result = maximise()

            println(result)
        }

    }
}
