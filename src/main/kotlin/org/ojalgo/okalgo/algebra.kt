package org.ojalgo.okalgo

import org.ojalgo.algebra.Operation
import org.ojalgo.algebra.ScalarOperation
import org.ojalgo.matrix.BasicMatrix
import org.ojalgo.matrix.ComplexMatrix
import org.ojalgo.matrix.PrimitiveMatrix

operator fun <T> Operation.Addition<T>.plus(t: T) = add(t)
operator fun <T> Operation.Division<T>.div(t: T) = divide(t)
operator fun <T> Operation.Multiplication<T>.times(t: T) = multiply(t)
operator fun <T> Operation.Subtraction<T>.minus(t: T) = subtract(t)

operator fun <T, N: Number> ScalarOperation.Addition<T,N>.plus(number: N) = add(number)
operator fun <T, N: Number> ScalarOperation.Division<T,N>.div(number: N) = divide(number)
operator fun <T, N: Number> ScalarOperation.Multiplication<T,N>.times(number: N) = multiply(number)
operator fun <T, N: Number> ScalarOperation.Subtraction<T,N>.minus(number: N) = subtract(number)


fun primitivematrix(rows: Int, cols: Int, op: (BasicMatrix.Builder<PrimitiveMatrix>.() -> Unit)? = null) =
        PrimitiveMatrix.FACTORY.getBuilder(rows,cols).also {
            if (op != null) op(it)
        }.build()


fun complexmatrix(rows: Int, cols: Int, op: (BasicMatrix.Builder<ComplexMatrix>.() -> Unit)? = null) =
        ComplexMatrix.FACTORY.getBuilder(rows,cols).also {
            if (op != null) op(it)
        }.build()

fun <I: BasicMatrix> BasicMatrix.Builder<I>.populate(op: (Long, Long) -> Number) =
        loopAll { row, col -> set(row, col, op(row,col))  }


