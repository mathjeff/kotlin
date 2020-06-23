/*
 * Copyright 2010-2017 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.kotlin.ir.expressions.impl

import org.jetbrains.kotlin.ir.ObsoleteDescriptorBasedAPI
import org.jetbrains.kotlin.ir.declarations.IrAttributeContainer
import org.jetbrains.kotlin.ir.expressions.IrExpression
import org.jetbrains.kotlin.ir.expressions.IrFunctionReference
import org.jetbrains.kotlin.ir.expressions.IrStatementOrigin
import org.jetbrains.kotlin.ir.symbols.IrFunctionSymbol
import org.jetbrains.kotlin.ir.types.IrType
import org.jetbrains.kotlin.ir.visitors.IrElementVisitor
import org.jetbrains.kotlin.name.Name

class IrFunctionReferenceImpl(
    override val startOffset: Int,
    override val endOffset: Int,
    override val type: IrType,
    override val symbol: IrFunctionSymbol,
    override val typeArgumentsCount: Int,
    override val valueArgumentsCount: Int,
    override val reflectionTarget: IrFunctionSymbol? = symbol,
    override val origin: IrStatementOrigin? = null
) : IrFunctionReference(), IrCallWithIndexedArgumentsBase {
    override var dispatchReceiver: IrExpression? = null
    override var extensionReceiver: IrExpression? = null

    override val argumentsByParameterIndex: Array<IrExpression?> = arrayOfNulls(valueArgumentsCount)

    override val typeArgumentsByIndex: Array<IrType?> = arrayOfNulls(typeArgumentsCount)

    override var attributeOwnerId: IrAttributeContainer = this

    @ObsoleteDescriptorBasedAPI
    constructor(
        startOffset: Int,
        endOffset: Int,
        type: IrType,
        symbol: IrFunctionSymbol,
        typeArgumentsCount: Int,
        reflectionTarget: IrFunctionSymbol?,
        origin: IrStatementOrigin? = null
    ) : this(
        startOffset, endOffset,
        type,
        symbol,
        typeArgumentsCount,
        symbol.descriptor.valueParameters.size,
        reflectionTarget,
        origin
    )

    override val referencedName: Name
        get() = symbol.owner.name

    override fun getTypeArgument(index: Int): IrType? = super.getTypeArgument(index)

    override fun putTypeArgument(index: Int, type: IrType?): Unit = super.putTypeArgument(index, type)

    override fun getValueArgument(index: Int): IrExpression? = super.getValueArgument(index)

    override fun putValueArgument(index: Int, valueArgument: IrExpression?): Unit = super.putValueArgument(index, valueArgument)

    override fun removeValueArgument(index: Int): Unit = super.removeValueArgument(index)

    override fun <R, D> accept(visitor: IrElementVisitor<R, D>, data: D): R =
        visitor.visitFunctionReference(this, data)
}
