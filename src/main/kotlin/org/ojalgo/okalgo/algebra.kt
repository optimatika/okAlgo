package org.ojalgo.okalgo

import org.ojalgo.algebra.Operation
import org.ojalgo.algebra.ScalarOperation

operator fun <T> Operation.Addition<T>.plus(t: T) = add(t)
operator fun <T> Operation.Division<T>.div(t: T) = divide(t)
operator fun <T> Operation.Multiplication<T>.times(t: T) = multiply(t)
operator fun <T> Operation.Subtraction<T>.minus(t: T) = subtract(t)

operator fun <T, N: Number> ScalarOperation.Addition<T,N>.plus(number: N) = add(number)
operator fun <T, N: Number> ScalarOperation.Division<T,N>.div(number: N) = divide(number)
operator fun <T, N: Number> ScalarOperation.Multiplication<T,N>.times(number: N) = multiply(number)
operator fun <T, N: Number> ScalarOperation.Subtraction<T,N>.minus(number: N) = subtract(number)