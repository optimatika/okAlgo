package org.ojalgo.okalgo

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
    fun expressionBuilderTest1() {

        expressionsbasedmodel {

            val v1 = variable(lower = 3, upper = 10)
            val v2 = variable(lower = 10, upper = 12)

            expression(
                    expression = (.3 * v1) + (.2 * v2) GTE 4
            )

            maximise().run(::println)

            println("v1=${v1.value.toDouble()} v2=${v2.value.toDouble()}")
        }

    }

    @Test
    fun expressionBuilderTest2() {

        expressionsbasedmodel {

            val v1 = variable(lower = 2, upper = 10, isInteger = true)
            val v2 = variable(lower = 2, upper = 10, isInteger = true)

            expression(v1 + 2 * v2) {
                weight(1)
            }

            expression {
                set(v1 + v2 EQ 16)
            }

            minimise().run(::println)

            println("v1=${v1.value.toDouble()} v2=${v2.value.toDouble()}")


        }

    }
}
