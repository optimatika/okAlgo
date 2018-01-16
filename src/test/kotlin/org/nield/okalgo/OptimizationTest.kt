package org.nield.okalgo

import org.junit.Test


class OptimizationTest {

    @Test
    fun expressionsBasedModelDSL() {

        expressionsbasedmodel {

            val v1 = variable(lower = 3, upper = 6)
            val v2 = variable(lower = 10, upper = 12)

            expression(weight = 1) {
                set(v1, 1)
                set(v2, 1)
            }

            maximise()

            println("v1=${v1.value.toDouble()} v2=${v2.value.toDouble()}")
        }

    }

    @Test
    fun expressionBuilderTest() {

        expressionsbasedmodel {

            val v1 = variable(lower = 3, upper = 10)
            val v2 = variable(lower = 10, upper = 12)

            addExpression((1 * v1) + (1 * v2) GTE 4)

            maximise()

            println("v1=${v1.value.toDouble()} v2=${v2.value.toDouble()}")
        }

    }
}
