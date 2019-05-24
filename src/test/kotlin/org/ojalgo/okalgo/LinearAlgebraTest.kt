package org.ojalgo.okalgo

import org.junit.Assert
import org.junit.Assert.assertTrue
import org.junit.Test
import org.ojalgo.matrix.ComplexMatrix
import org.ojalgo.matrix.PrimitiveMatrix
import org.ojalgo.matrix.RationalMatrix
import java.math.BigDecimal

class LinearAlgebraTest {

    @Test
    fun toPrimitiveMatrixTestList() {

        val matrix = listOf(1,2,3).toPrimitiveMatrix(
                {it},
                {it * 10},
                {it * 100}
        )

        val shouldMatch = PrimitiveMatrix.FACTORY.makeDense(3,3).also {
            it.set(0L,0L,1)
            it.set(0L,1L,10)
            it.set(0L,2L,100)

            it.set(1L,0L,2)
            it.set(1L,1L,20)
            it.set(1L,2L,200)

            it.set(2L,0L,3)
            it.set(2L,1L,30)
            it.set(2L,2L,300)
        }.build()

        assertTrue(matrix == shouldMatch)
    }

    @Test
    fun toPrimitiveMatrixTestSequence() {

        val matrix = sequenceOf(1,2,3).toPrimitiveMatrix(
                {it},
                {it * 10},
                {it * 100}
        )

        val shouldMatch = PrimitiveMatrix.FACTORY.makeDense(3,3).also {
            it.set(0L,0L,1)
            it.set(0L,1L,10)
            it.set(0L,2L,100)

            it.set(1L,0L,2)
            it.set(1L,1L,20)
            it.set(1L,2L,200)

            it.set(2L,0L,3)
            it.set(2L,1L,30)
            it.set(2L,2L,300)
        }.build()

        assertTrue(matrix == shouldMatch)
    }

    @Test
    fun toComplexMatrixTestList() {

        val matrix = listOf(1,2,3).toComplexMatrix(
                {it},
                {it * 10},
                {it * 100}
        )

        val shouldMatch = ComplexMatrix.FACTORY.makeDense(3,3).also {
            it.set(0L,0L,1)
            it.set(0L,1L,10)
            it.set(0L,2L,100)

            it.set(1L,0L,2)
            it.set(1L,1L,20)
            it.set(1L,2L,200)

            it.set(2L,0L,3)
            it.set(2L,1L,30)
            it.set(2L,2L,300)
        }.build()

        assertTrue(matrix == shouldMatch)
    }

    @Test
    fun toComplexMatrixTestSequence() {

        val matrix = sequenceOf(1,2,3).toComplexMatrix(
                {it},
                {it * 10},
                {it * 100}
        )

        val shouldMatch = ComplexMatrix.FACTORY.makeDense(3,3).also {
            it.set(0L,0L,1)
            it.set(0L,1L,10)
            it.set(0L,2L,100)

            it.set(1L,0L,2)
            it.set(1L,1L,20)
            it.set(1L,2L,200)

            it.set(2L,0L,3)
            it.set(2L,1L,30)
            it.set(2L,2L,300)
        }.build()

        assertTrue(matrix == shouldMatch)
    }

    @Test
    fun toRationalMatrixTestList() {

        val matrix = listOf(1,2,3).toRationalMatrix(
                {it},
                {it * 10},
                {it * 100}
        )

        val shouldMatch = RationalMatrix.FACTORY.makeDense(3,3).also {
            it.set(0L,0L,1)
            it.set(0L,1L,10)
            it.set(0L,2L,100)

            it.set(1L,0L,2)
            it.set(1L,1L,20)
            it.set(1L,2L,200)

            it.set(2L,0L,3)
            it.set(2L,1L,30)
            it.set(2L,2L,300)
        }.build()

        assertTrue(matrix == shouldMatch)
    }

    @Test
    fun toRationalMatrixTestSequence() {

        val matrix = sequenceOf(1,2,3).toRationalMatrix(
                {it},
                {it * 10},
                {it * 100}
        )

        val shouldMatch = RationalMatrix.FACTORY.makeDense(3,3).also {
            it.set(0L,0L,1)
            it.set(0L,1L,10)
            it.set(0L,2L,100)

            it.set(1L,0L,2)
            it.set(1L,1L,20)
            it.set(1L,2L,200)

            it.set(2L,0L,3)
            it.set(2L,1L,30)
            it.set(2L,2L,300)
        }.build()

        assertTrue(matrix == shouldMatch)
    }

    @Test
    fun populatePrimitiveMatrixTest() {

        val matrix = primitivematrix(rows=3,cols=3) {
            populate { row, col ->
                row * col
            }
        }
        val shouldMatch = PrimitiveMatrix.FACTORY.makeDense(3,3).also {
            it.set(0L,0L,0)
            it.set(0L,1L,0)
            it.set(0L,2L,0)

            it.set(1L,0L,0)
            it.set(1L,1L,1)
            it.set(1L,2L,2)

            it.set(2L,0L,0)
            it.set(2L,1L,2)
            it.set(2L,2L,4)
        }.build()

        assertTrue(matrix == shouldMatch)
    }

    @Test
    fun populateComplexMatrixTest() {

        val matrix = complexmatrix(rows=3,cols=3) {
            populate { row, col ->
                row * col
            }
        }
        val shouldMatch = ComplexMatrix.FACTORY.makeDense(3,3).also {
            it.set(0L,0L,0)
            it.set(0L,1L,0)
            it.set(0L,2L,0)

            it.set(1L,0L,0)
            it.set(1L,1L,1)
            it.set(1L,2L,2)

            it.set(2L,0L,0)
            it.set(2L,1L,2)
            it.set(2L,2L,4)
        }.build()

        assertTrue(matrix == shouldMatch)
    }

    @Test
    fun populateRationalMatrixTest() {

        val matrix = rationalmatrix(rows=3,cols=3) {
            populate { row, col ->
                row * col
            }
        }
        val shouldMatch = RationalMatrix.FACTORY.makeDense(3,3).also {
            it.set(0L,0L,0)
            it.set(0L,1L,0)
            it.set(0L,2L,0)

            it.set(1L,0L,0)
            it.set(1L,1L,1)
            it.set(1L,2L,2)

            it.set(2L,0L,0)
            it.set(2L,1L,2)
            it.set(2L,2L,4)
        }.build()

        assertTrue(matrix == shouldMatch)
    }

    @Test
    fun populateVarargPrimitiveMatrixTest() {

        val matrix = primitivematrix(rows=3,cols=3) {
            populate(0,0,0,0,1,2,0,2,4)
        }
        val shouldMatch = PrimitiveMatrix.FACTORY.makeDense(3,3).also {
            it.set(0L,0L,0)
            it.set(0L,1L,0)
            it.set(0L,2L,0)

            it.set(1L,0L,0)
            it.set(1L,1L,1)
            it.set(1L,2L,2)

            it.set(2L,0L,0)
            it.set(2L,1L,2)
            it.set(2L,2L,4)
        }.build()

        assertTrue(matrix == shouldMatch)
    }

    @Test
    fun populateVarargComplexMatrixTest() {

        val matrix = complexmatrix(rows=3,cols=3) {
            populate(0,0,0,0,1,2,0,2,4)
        }
        val shouldMatch = ComplexMatrix.FACTORY.makeDense(3,3).also {
            it.set(0L,0L,0)
            it.set(0L,1L,0)
            it.set(0L,2L,0)

            it.set(1L,0L,0)
            it.set(1L,1L,1)
            it.set(1L,2L,2)

            it.set(2L,0L,0)
            it.set(2L,1L,2)
            it.set(2L,2L,4)
        }.build()

        assertTrue(matrix == shouldMatch)
    }

    @Test
    fun populateVarargRationalMatrixTest() {

        val matrix = rationalmatrix(rows=3,cols=3) {
            populate(0,0,0,0,1,2,0,2,4)
        }
        val shouldMatch = RationalMatrix.FACTORY.makeDense(3,3).also {
            it.set(0L,0L,0)
            it.set(0L,1L,0)
            it.set(0L,2L,0)

            it.set(1L,0L,0)
            it.set(1L,1L,1)
            it.set(1L,2L,2)

            it.set(2L,0L,0)
            it.set(2L,1L,2)
            it.set(2L,2L,4)
        }.build()

        assertTrue(matrix == shouldMatch)
    }

    @Test
    fun vectorOfIntTest() {
        val v = vectorOf(1,2,3).transpose()
        val shouldMatch = PrimitiveMatrix.FACTORY.makeDense(1,3).also {
            it.set(0L,0L,1)
            it.set(0L,1L,2)
            it.set(0L,2L,3)
        }.build()

        assertTrue(v == shouldMatch)
    }


    @Test
    fun vectorOfDoubleTest() {
        val v = vectorOf(1.0,2.0,3.0).transpose()
        val shouldMatch = PrimitiveMatrix.FACTORY.makeDense(1,3).also {
            it.set(0L,0L,1)
            it.set(0L,1L,2)
            it.set(0L,2L,3)
        }.build()

        assertTrue(v == shouldMatch)
    }

    @Test
    fun vectorOfLongTest() {
        val v = vectorOf(1L,2L,3L).transpose()
        val shouldMatch = PrimitiveMatrix.FACTORY.makeDense(1,3).also {
            it.set(0L,0L,1)
            it.set(0L,1L,2)
            it.set(0L,2L,3)
        }.build()

        assertTrue(v == shouldMatch)
    }

    @Test
    fun vectorOfBigDecimalTest() {
        val v = vectorOf(BigDecimal.valueOf(1), BigDecimal.valueOf(2), BigDecimal.valueOf(3)).transpose()
        val shouldMatch = PrimitiveMatrix.FACTORY.makeDense(1,3).also {
            it.set(0L,0L,1)
            it.set(0L,1L,2)
            it.set(0L,2L,3)
        }.build()

        assertTrue(v == shouldMatch)
    }
}