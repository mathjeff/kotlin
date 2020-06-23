/*
 * Copyright 2010-2019 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.ir.declarations

import org.jetbrains.kotlin.ir.symbols.IrPropertySymbol
import org.jetbrains.kotlin.ir.symbols.IrSimpleFunctionSymbol

abstract class IrSimpleFunction :
    IrFunction(),
    IrSymbolDeclaration<IrSimpleFunctionSymbol>,
    IrOverridableDeclaration<IrSimpleFunctionSymbol>,
    IrOverridableMember,
    IrAttributeContainer {

    abstract val isTailrec: Boolean
    abstract val isSuspend: Boolean
    abstract val isFakeOverride: Boolean
    abstract val isOperator: Boolean

    abstract var correspondingPropertySymbol: IrPropertySymbol?
}

val IrFunction.isPropertyAccessor: Boolean
    get() = this is IrSimpleFunction && correspondingPropertySymbol != null
