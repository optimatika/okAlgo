package org.ojalgo.okalgo

import org.ojalgo.algebra.Operation
import org.ojalgo.algebra.ScalarOperation
import org.ojalgo.array.*
import org.ojalgo.matrix.ComplexMatrix
import org.ojalgo.matrix.PrimitiveMatrix
import org.ojalgo.matrix.RationalMatrix
import org.ojalgo.scalar.ComplexNumber
import org.ojalgo.scalar.Quaternion
import org.ojalgo.scalar.RationalNumber
import java.math.BigDecimal
import java.util.concurrent.atomic.AtomicBoolean


fun <T, N: Number> Sequence<T>.toPrimitiveMatrix(vararg selectors: (T) -> N): PrimitiveMatrix {
    val items = toList()

    return primitivematrix(items.count(), selectors.count()) {
        populate { row, col ->
            selectors[col.toInt()](items[row.toInt()])
        }
    }
}

fun <T, N: Number> Iterable<T>.toPrimitiveMatrix(vararg selectors: (T) -> N): PrimitiveMatrix {
    val items = toList()

    return primitivematrix(items.count(), selectors.count()) {
        populate { row, col ->
            selectors[col.toInt()](items[row.toInt()])
        }
    }
}


fun <T, N: Number> Sequence<T>.toComplexMatrix(vararg selectors: (T) -> N): ComplexMatrix {
    val items = toList()

    return complexmatrix(items.count(), selectors.count()) {
        populate { row, col ->
            selectors[col.toInt()](items[row.toInt()])
        }
    }
}
fun <T, N: Number> Iterable<T>.toComplexMatrix(vararg selectors: (T) -> N): ComplexMatrix {
    val items = toList()

    return complexmatrix(items.count(), selectors.count()) {
        populate { row, col ->
            selectors[col.toInt()](items[row.toInt()])
        }
    }
}


fun <T, N: Number> Sequence<T>.toRationalMatrix(vararg selectors: (T) -> N): RationalMatrix {
    val items = toList()

    return rationalmatrix(items.count(), selectors.count()) {
        populate { row, col ->
            selectors[col.toInt()](items[row.toInt()])
        }
    }
}
fun <T, N: Number> Iterable<T>.toRationalMatrix(vararg selectors: (T) -> N): RationalMatrix {
    val items = toList()

    return rationalmatrix(items.count(), selectors.count()) {
        populate { row, col ->
            selectors[col.toInt()](items[row.toInt()])
        }
    }
}

fun bigArrayOf(vararg values: Double) = BigArray.FACTORY.copy(*values)
fun bigArrayOf(vararg values: ComplexNumber) = BigArray.FACTORY.copy(*values)
fun bigArrayOf(vararg values: BigDecimal) = BigArray.FACTORY.copy(*values)

fun complexArrayOf(vararg values: ComplexNumber) = ComplexArray.FACTORY.copy(*values)

fun direct32ArrayOf(vararg values: Double) = BufferArray.DIRECT32.copy(*values)
fun direct64ArrayOf(vararg values: Double) = BufferArray.DIRECT64.copy(*values)

fun quanternionArrayOf(vararg values: Quaternion) = Quaternion.FACTORY.newArrayInstance(values.count()).apply {
    values.withIndex().forEach { this[it.index] = it.value }
}

fun rationalArrayOf(vararg values: RationalNumber) = RationalArray.FACTORY.copy(*values)



fun vectorOf(vararg values: Int) = primitivematrix(values.count(), 1) {
    populate { row, col -> values[row.toInt()]  }
}

fun vectorOf(vararg values: Double) = primitivematrix(values.count(), 1) {
    populate { row, col -> values[row.toInt()]  }
}

fun vectorOf(vararg values: Long) = primitivematrix(values.count(), 1) {
    populate { row, col -> values[row.toInt()]  }
}

fun vectorOf(vararg values: BigDecimal) = rationalmatrix(values.count(), 1) {
    populate { row, col -> values[row.toInt()]  }
}

private val transposeFlag1 = AtomicBoolean(false)

fun primitivematrix(rows: Int, cols: Int, op: (PrimitiveMatrix.DenseReceiver.() -> Unit)? = null) =
        PrimitiveMatrix.FACTORY.makeDense(rows,cols).also {
            if (op != null) op(it)
        }.build().let {
            if (transposeFlag1.getAndSet(false)) it.transpose() else it
        }

private val transposeFlag2 = AtomicBoolean(false)

fun complexmatrix(rows: Int, cols: Int, op: (ComplexMatrix.DenseReceiver.() -> Unit)? = null) =
        ComplexMatrix.FACTORY.makeDense(rows,cols).also {
            if (op != null) op(it)
        }.build().let {
            if (transposeFlag2.getAndSet(false)) it.transpose() else it
        }

private val transposeFlag3 = AtomicBoolean(false)

fun rationalmatrix(rows: Int, cols: Int, op: (RationalMatrix.DenseReceiver.() -> Unit)? = null) =
        RationalMatrix.FACTORY.makeDense(rows,cols).also {
            if (op != null) op(it)
        }.build().let {
            if (transposeFlag3.getAndSet(false)) it.transpose() else it
        }

fun PrimitiveMatrix.DenseReceiver.populate(op: (Long,Long) -> Number) =
        loopAll { row, col -> set(row, col, op(row,col))  }

fun ComplexMatrix.DenseReceiver.populate(op: (Long,Long) -> Number) =
        loopAll { row, col -> set(row, col, op(row,col))  }

fun RationalMatrix.DenseReceiver.populate(op: (Long,Long) -> Number) =
        loopAll { row, col -> set(row, col, op(row,col))  }

fun PrimitiveMatrix.DenseReceiver.populate(vararg values: Double) {
    transposeFlag1.set(true)
    val totalRows = countRows()
    val totalCols = countColumns()

    for ((i,v) in values.withIndex()) {
        set(i.toLong(),v)
    }

}

fun PrimitiveMatrix.DenseReceiver.populate(vararg values: Number) {
    transposeFlag1.set(true)
    val totalRows = countRows()
    val totalCols = countColumns()

    for ((i,v) in values.withIndex()) {
        set(i.toLong(),v)
    }
}

fun ComplexMatrix.DenseReceiver.populate(vararg values: Double) {
    transposeFlag2.set(true)
    val totalRows = countRows()
    val totalCols = countColumns()

    for ((i,v) in values.withIndex()) {
        set(i.toLong(),v)
    }
}

fun ComplexMatrix.DenseReceiver.populate(vararg values: Number) {
    transposeFlag2.set(true)
    val totalRows = countRows()
    val totalCols = countColumns()

    for ((i,v) in values.withIndex()) {
        set(i.toLong(),v)
    }
}


fun RationalMatrix.DenseReceiver.populate(vararg values: Double) {
    transposeFlag3.set(true)
    val totalRows = countRows()
    val totalCols = countColumns()

    for ((i,v) in values.withIndex()) {
        set(i.toLong(),v)
    }
}

fun RationalMatrix.DenseReceiver.populate(vararg values: Number) {
    transposeFlag3.set(true)
    val totalRows = countRows()
    val totalCols = countColumns()

    for ((i,v) in values.withIndex()) {
        set(i.toLong(),v)
    }
}





operator fun <T> Operation.Addition<T>.plus(t: T) = add(t)
operator fun <T> Operation.Division<T>.div(t: T) = divide(t)
operator fun <T> Operation.Multiplication<T>.times(t: T) = multiply(t)
operator fun <T> Operation.Subtraction<T>.minus(t: T) = subtract(t)

operator fun <T, N: Number> ScalarOperation.Addition<T,N>.plus(number: N) = add(number)
operator fun <T, N: Number> ScalarOperation.Division<T,N>.div(number: N) = divide(number)
operator fun <T, N: Number> ScalarOperation.Multiplication<T,N>.times(number: N) = multiply(number)
operator fun <T, N: Number> ScalarOperation.Subtraction<T,N>.minus(number: N) = subtract(number)

fun Double.toComplex() = ComplexNumber.FACTORY.cast(this)
fun Double.toRational() = RationalNumber.FACTORY.cast(this)
fun <N: Number> N.toComplex() = ComplexNumber.FACTORY.cast(this)
fun <N: Number> N.toRational() = RationalNumber.FACTORY.cast(this)

fun Double.toComplexScalar() = ComplexNumber.FACTORY.convert(this)
fun Double.toRationalScalar() = RationalNumber.FACTORY.convert(this)
fun <N: Number> N.toComplexScalar() = ComplexNumber.FACTORY.convert(this)
fun <N: Number> N.toRationalScalar() = RationalNumber.FACTORY.convert(this)
