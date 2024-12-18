package com.radhangs.mydesignsystem.theme.tokens.core

@RequiresOptIn(
    level = RequiresOptIn.Level.WARNING,
    message = "Use core tokens at your own discretion. Please try to use Theme tokens where applicable"
)
@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY)
public annotation class CoreTokensOptIn
