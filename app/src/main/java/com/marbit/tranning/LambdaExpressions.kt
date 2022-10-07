package com.marbit.tranning

import android.util.Log

/**
 * Lambdas are a type of function literal, meaning they are a function defined without using the
 * "fun keyword" and are used immediately as part of an expression.
 *
 * Because lambdas are not named or declared using the fun keyword, we are free to easily assign
 * them to variables or pass them as function parameters.
 *
 * Lambdas are not class or function bodies.
 *
 *
 *  The full syntactic form of lambda expressions is as follows:

        val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }

    - A lambda expression is always surrounded by curly braces.
    - Parameter declarations in the full syntactic form go inside curly braces and have optional type annotations.
    - The body goes after the ->.
    - If the inferred return type of the lambda is not Unit, the last (or possibly single) expression inside the lambda body is treated as the return value.

    If you leave all the optional annotations out, what's left looks like this:
        val sum = { x: Int, y: Int -> x + y }
 */
class LambdaExpressions {
    val TAG: String = "TRAINNING"

    fun execute(){
        val simpleLambdaFullSyntax : () -> Unit = { Log.v(TAG, "Hello simpleLambdaFullSyntax") }
        simpleLambdaFullSyntax.invoke()


        val simpleLambdaShortSyntax = { Log.v(TAG, "Hello simpleLambdaShortSyntax") }
        simpleLambdaShortSyntax.invoke()


        /**
         * With parameters. Full syntax and simple syntax examples
         */

        val lambdaWithParameterFullSyntax : (String?) -> Unit = { name: String? -> Log.v(TAG,"My name is $name") }
        lambdaWithParameterFullSyntax.invoke(null)

        val lambdaWithParameterShortSyntaxFirst = { name: String? -> Log.v(TAG,"My name is $name") }
        lambdaWithParameterShortSyntaxFirst.invoke(null)

        val lambdaWithParameterShortSyntaxSecond: (String?) -> Unit = { name -> Log.v(TAG,"My name is $name") }
        lambdaWithParameterShortSyntaxSecond.invoke(null)



    }
}