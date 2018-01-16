# okAlgo


Idiomatic Kotlin extensions for ojAlgo. 

Currently work is focused on linear/integer optimization part of the API. Closures can flexibly be invoked wherever they are needed. 


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


```kotlin 
val v1 = variable(lower = 3, upper = 10)
val v2 = variable(lower = 10, upper = 12)

addExpression((1 * v1) + (1 * v2) GT 4)
```