package org.ojalgo.okalgo

import org.ojalgo.ann.ArtificialNeuralNetwork
import org.ojalgo.ann.NetworkBuilder

fun artificialneuralnetwork(numberOfInputNodes: Int, vararg nodesPerCalculationLayer: Int, op: NetworkBuilder.() -> Unit = {}): ArtificialNeuralNetwork? {

    val builder = ArtificialNeuralNetwork.builder(numberOfInputNodes, *nodesPerCalculationLayer)

    builder.op()

    return builder.get()
}