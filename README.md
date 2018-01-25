# okAlgo


Idiomatic Kotlin extensions for ojAlgo, with some inspirations from [PuLP](https://github.com/coin-or/pulp). 

Still in development. Production usage not recommended. 

Currently work is focused on linear/integer optimization part of the API. Closures can flexibly be invoked wherever they are needed. 

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
val v1 = variable(lower = 3, upper = 10)
val v2 = variable(lower = 10, upper = 12)

addExpression((2 * v1) + (3 * v2) GTE 4)
```
