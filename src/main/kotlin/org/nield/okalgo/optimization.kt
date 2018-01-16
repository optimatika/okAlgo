package org.nield.okalgo

import org.ojalgo.optimisation.Expression
import org.ojalgo.optimisation.ExpressionsBasedModel
import org.ojalgo.optimisation.Variable
import java.util.concurrent.atomic.AtomicInteger


class AutoNameState {
    // custom DSL for  expression and variable inputs, eliminate naming and adding
    val funcId = AtomicInteger(0)
    val variableId = AtomicInteger(0)
    fun generateVariableName() = variableId.incrementAndGet().toString().let { "Variable$it" }
    fun generateExpressionName() = funcId.incrementAndGet().let { "Func$it"}
}

val autoNameStates = mutableMapOf<ExpressionsBasedModel,AutoNameState>()
fun ExpressionsBasedModel.getAutoNameState() = autoNameStates.computeIfAbsent(this) { AutoNameState() }

fun expressionsbasedmodel(op: ExpressionsBasedModel.() -> Unit): ExpressionsBasedModel {
    val ebm = ExpressionsBasedModel()
    ebm.op()
    return ebm
}

fun ExpressionsBasedModel.objective(name: String? = null, lower: Number? = null, upper: Number? = null, op: Expression.() -> Unit = {}): Expression {

    val expr = objective()

    expr.op()
    lower?.let { expr.lower(it) }
    upper?.let { expr.upper(it) }

    return expr
}

fun ExpressionsBasedModel.expression(name: String? = null, lower: Number? = null, upper: Number? = null, op: Expression.() -> Unit = {}): Expression {

    val expr = addExpression(name ?: getAutoNameState().generateExpressionName())

    expr.op()
    lower?.let { expr.lower(it) }
    upper?.let { expr.upper(it) }

    return expr
}


fun ExpressionsBasedModel.variable(name: String? = null, lower: Number? = null, upper: Number? = null, weight: Number? = null, isBinary: Boolean? = null, isInteger: Boolean? = null, op: Variable.() -> Unit = {}): Variable {

    val variable = Variable(name ?: getAutoNameState().generateVariableName())
    variable.op()
    lower?.let { variable.lower(it) }
    upper?.let { variable.upper(it) }
    weight?.let { variable.weight(it) }
    isBinary?.let { if (it) variable.binary() }
    isInteger?.let { variable.integer(it) }

    addVariable(variable)
    return variable
}


