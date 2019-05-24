# okAlgo


[![](https://jitpack.io/v/optimatika/okAlgo.svg)](https://jitpack.io/#optimatika/okAlgo)

Idiomatic Kotlin extensions for ojAlgo, with some inspirations from [PuLP](https://github.com/coin-or/pulp). 

## Linear Algebra DSL 

Below is an example of how to use the linear algebra DSL. In this particular example, we create a Markov chain to calculate the probability of 5 consecutive heads in 10 coin flips. 

```kotlin 
import org.ojalgo.okalgo.populate
import org.ojalgo.okalgo.primitivematrix
import org.ojalgo.okalgo.times

fun main() {
	
	val transitionMatrix = primitivematrix(rows = 6, cols = 6) {
		populate {row, col ->
			when {
				col == 0L -> .50
				row + 1L == col -> .50
				row == 5L && col == 5L -> 1.0
				else -> 0.0
			}
		}
	}

	println("\r\nTransition Matrix:")
	println(transitionMatrix)

	val toTenthPower = generateSequence(transitionMatrix) { it * transitionMatrix }.take(10).last()
	println("\r\nTransition Matrix Raised to 10th Power")
	println(toTenthPower)

	println("\r\nMARKOV CHAIN RESULT: ${toTenthPower[0,5]}")
}

// REFERENCE: https://www.quora.com/What-is-the-probability-of-getting-5-consecutive-heads-in-10-tosses-of-a-fair-coin
```

**OUTPUT:**

```
Transition Matrix:
org.ojalgo.matrix.PrimitiveMatrix < 6 x 6 >
{ { 0.5,	0.5,	0.0,	0.0,	0.0,	0.0 },
{ 0.5,	0.0,	0.5,	0.0,	0.0,	0.0 },
{ 0.5,	0.0,	0.0,	0.5,	0.0,	0.0 },
{ 0.5,	0.0,	0.0,	0.0,	0.5,	0.0 },
{ 0.5,	0.0,	0.0,	0.0,	0.0,	0.5 },
{ 0.5,	0.0,	0.0,	0.0,	0.0,	1.0 } }

Transition Matrix Raised to 10th Power
org.ojalgo.matrix.PrimitiveMatrix < 6 x 6 >
{ { 0.5546875,	0.267578125,	0.1298828125,	0.0634765625,	0.03125,	0.109375 },
{ 0.6015625,	0.287109375,	0.1376953125,	0.06640625,	0.0322265625,	0.140625 },
{ 0.7109375,	0.333984375,	0.1572265625,	0.07421875,	0.03515625,	0.2041015625 },
{ 0.9609375,	0.443359375,	0.2041015625,	0.09375,	0.04296875,	0.333984375 },
{ 1.5244140625,	0.693359375,	0.3134765625,	0.140625,	0.0625,	0.6015625 },
{ 2.78125,	1.2568359375,	0.5634765625,	0.25,	0.109375,	1.15625 } }

MARKOV CHAIN RESULT: 0.109375
```

## MIP Solver DSL

**EXAMPLE 1**

```kotlin 
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
```

**EXAMPLE 2**


```kotlin 
val model = ExpressionsBasedModel()
        
val v1 = model.variable(lower = 3, upper = 6)
val v2 = model.variable(lower = 10, upper = 12)

model.expression(weight=1) {
    set(v1, 1)
    set(v2, 1)
}

model.maximise()

println("v1=${v1.value.toDouble()} v2=${v2.value.toDouble()}")
```


Expression building with Kotlin extensions is also being explored:


**EXAMPLE 3**

```kotlin 
expressionsbasedmodel {

    val v1 = variable(lower = 2, upper = 10, isInteger = true)
    val v2 = variable(lower = 2, upper = 10, isInteger = true)

    expression(v1 + 2*v2) {
        weight(1)
    }

    expression {
        set(v1 + v2 EQ 16)
    }

    minimise().run(::println)

    println("v1=${v1.value.toDouble()} v2=${v2.value.toDouble()}")
}
```

## Artifact Instructions

Until this gets deployed to Maven Central, you can use JitPack to import this project as a dependency.

**Maven**

```xml
<dependency>
    <groupId>org.ojalgo</groupId>
    <artifactId>okalgo</artifactId>
    <version>0.0.2</version>
</dependency>
```

**Gradle**

```groovy
compile 'org.ojalgo:okalgo:0.0.2'
```
