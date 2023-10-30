/*
 * Copyright 2010-2016 JetBrains s.r.o.
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

package org.jetbrains.kotlin.ir.visitors

import org.jetbrains.kotlin.ir.IrElement
import org.jetbrains.kotlin.ir.IrStatement
import org.jetbrains.kotlin.ir.declarations.*
import org.jetbrains.kotlin.ir.expressions.*

abstract class IrElementTransformerVoid : IrElementTransformer<Nothing?> {

    protected inline fun <T : IrElement> T.transformPostfix(body: T.() -> Unit): T {
        transformChildrenVoid()
        this.body()
        return this
    }

    protected fun IrElement.transformChildrenVoid() {
        transformChildrenVoid(this@IrElementTransformerVoid)
    }

    open fun visitElement(element: IrElement): IrElement {
        element.transformChildren(this, null)
        return element
    }

    final override fun visitElement(element: IrElement, data: Nothing?): IrElement =
        visitElement(element)

    open fun visitDeclaration(declaration: IrDeclarationBase): IrStatement {
        declaration.transformChildren(this, null)
        return declaration
    }

    final override fun visitDeclaration(declaration: IrDeclarationBase, data: Nothing?): IrStatement =
        visitDeclaration(declaration)

    open fun visitValueParameter(declaration: IrValueParameter): IrStatement =
        visitDeclaration(declaration)

    final override fun visitValueParameter(declaration: IrValueParameter, data: Nothing?): IrStatement =
        visitValueParameter(declaration)

    open fun visitClass(declaration: IrClass): IrStatement =
        visitDeclaration(declaration)

    final override fun visitClass(declaration: IrClass, data: Nothing?): IrStatement =
        visitClass(declaration)

    open fun visitAnonymousInitializer(declaration: IrAnonymousInitializer): IrStatement =
        visitDeclaration(declaration)

    final override fun visitAnonymousInitializer(declaration: IrAnonymousInitializer, data: Nothing?): IrStatement =
        visitAnonymousInitializer(declaration)

    open fun visitTypeParameter(declaration: IrTypeParameter): IrStatement =
        visitDeclaration(declaration)

    final override fun visitTypeParameter(declaration: IrTypeParameter, data: Nothing?): IrStatement =
        visitTypeParameter(declaration)

    open fun visitFunction(declaration: IrFunction): IrStatement =
        visitDeclaration(declaration)

    final override fun visitFunction(declaration: IrFunction, data: Nothing?): IrStatement =
        visitFunction(declaration)

    open fun visitConstructor(declaration: IrConstructor): IrStatement =
        visitFunction(declaration)

    final override fun visitConstructor(declaration: IrConstructor, data: Nothing?): IrStatement =
        visitConstructor(declaration)

    open fun visitEnumEntry(declaration: IrEnumEntry): IrStatement =
        visitDeclaration(declaration)

    final override fun visitEnumEntry(declaration: IrEnumEntry, data: Nothing?): IrStatement =
        visitEnumEntry(declaration)

    open fun visitErrorDeclaration(declaration: IrErrorDeclaration): IrStatement =
        visitDeclaration(declaration)

    final override fun visitErrorDeclaration(declaration: IrErrorDeclaration, data: Nothing?): IrStatement =
        visitErrorDeclaration(declaration)

    open fun visitField(declaration: IrField): IrStatement =
        visitDeclaration(declaration)

    final override fun visitField(declaration: IrField, data: Nothing?): IrStatement =
        visitField(declaration)

    open fun visitLocalDelegatedProperty(declaration: IrLocalDelegatedProperty): IrStatement =
        visitDeclaration(declaration)

    final override fun visitLocalDelegatedProperty(declaration: IrLocalDelegatedProperty, data: Nothing?): IrStatement =
        visitLocalDelegatedProperty(declaration)

    open fun visitModuleFragment(declaration: IrModuleFragment): IrModuleFragment {
        declaration.transformChildren(this, null)
        return declaration
    }

    final override fun visitModuleFragment(declaration: IrModuleFragment, data: Nothing?): IrModuleFragment =
        visitModuleFragment(declaration)

    open fun visitProperty(declaration: IrProperty): IrStatement =
        visitDeclaration(declaration)

    final override fun visitProperty(declaration: IrProperty, data: Nothing?): IrStatement =
        visitProperty(declaration)

    open fun visitScript(declaration: IrScript): IrStatement =
        visitDeclaration(declaration)

    final override fun visitScript(declaration: IrScript, data: Nothing?): IrStatement =
        visitScript(declaration)

    open fun visitSimpleFunction(declaration: IrSimpleFunction): IrStatement =
        visitFunction(declaration)

    final override fun visitSimpleFunction(declaration: IrSimpleFunction, data: Nothing?): IrStatement =
        visitSimpleFunction(declaration)

    open fun visitTypeAlias(declaration: IrTypeAlias): IrStatement =
        visitDeclaration(declaration)

    final override fun visitTypeAlias(declaration: IrTypeAlias, data: Nothing?): IrStatement =
        visitTypeAlias(declaration)

    open fun visitVariable(declaration: IrVariable): IrStatement =
        visitDeclaration(declaration)

    final override fun visitVariable(declaration: IrVariable, data: Nothing?): IrStatement =
        visitVariable(declaration)

    open fun visitPackageFragment(declaration: IrPackageFragment): IrPackageFragment {
        declaration.transformChildren(this, null)
        return declaration
    }

    final override fun visitPackageFragment(declaration: IrPackageFragment, data: Nothing?): IrElement =
        visitPackageFragment(declaration)

    open fun visitExternalPackageFragment(declaration: IrExternalPackageFragment): IrExternalPackageFragment =
        visitPackageFragment(declaration) as IrExternalPackageFragment

    final override fun visitExternalPackageFragment(declaration: IrExternalPackageFragment, data: Nothing?): IrExternalPackageFragment =
        visitExternalPackageFragment(declaration)

    open fun visitFile(declaration: IrFile): IrFile =
        visitPackageFragment(declaration) as IrFile

    final override fun visitFile(declaration: IrFile, data: Nothing?): IrFile =
        visitFile(declaration)

    open fun visitExpression(expression: IrExpression): IrExpression {
        expression.transformChildren(this, null)
        return expression
    }

    final override fun visitExpression(expression: IrExpression, data: Nothing?): IrExpression =
        visitExpression(expression)

    open fun visitBody(body: IrBody): IrBody {
        body.transformChildren(this, null)
        return body
    }

    final override fun visitBody(body: IrBody, data: Nothing?): IrBody =
        visitBody(body)

    open fun visitExpressionBody(body: IrExpressionBody): IrBody =
        visitBody(body)

    final override fun visitExpressionBody(body: IrExpressionBody, data: Nothing?): IrBody =
        visitExpressionBody(body)

    open fun visitBlockBody(body: IrBlockBody): IrBody =
        visitBody(body)

    final override fun visitBlockBody(body: IrBlockBody, data: Nothing?): IrBody =
        visitBlockBody(body)

    open fun visitDeclarationReference(expression: IrDeclarationReference): IrExpression =
        visitExpression(expression)

    final override fun visitDeclarationReference(expression: IrDeclarationReference, data: Nothing?): IrExpression =
        visitDeclarationReference(expression)

    open fun visitMemberAccess(expression: IrMemberAccessExpression<*>): IrExpression =
        visitDeclarationReference(expression)

    final override fun visitMemberAccess(expression: IrMemberAccessExpression<*>, data: Nothing?): IrExpression =
        visitMemberAccess(expression)

    open fun visitFunctionAccess(expression: IrFunctionAccessExpression): IrExpression =
        visitMemberAccess(expression)

    final override fun visitFunctionAccess(expression: IrFunctionAccessExpression, data: Nothing?): IrExpression =
        visitFunctionAccess(expression)

    open fun visitConstructorCall(expression: IrConstructorCall): IrExpression =
        visitFunctionAccess(expression)

    final override fun visitConstructorCall(expression: IrConstructorCall, data: Nothing?): IrExpression =
        visitConstructorCall(expression)

    open fun visitSingletonReference(expression: IrGetSingletonValue): IrExpression =
        visitDeclarationReference(expression)

    final override fun visitSingletonReference(expression: IrGetSingletonValue, data: Nothing?): IrExpression =
        visitSingletonReference(expression)

    open fun visitGetObjectValue(expression: IrGetObjectValue): IrExpression =
        visitSingletonReference(expression)

    final override fun visitGetObjectValue(expression: IrGetObjectValue, data: Nothing?): IrExpression =
        visitGetObjectValue(expression)

    open fun visitGetEnumValue(expression: IrGetEnumValue): IrExpression =
        visitSingletonReference(expression)

    final override fun visitGetEnumValue(expression: IrGetEnumValue, data: Nothing?): IrExpression =
        visitGetEnumValue(expression)

    open fun visitRawFunctionReference(expression: IrRawFunctionReference): IrExpression =
        visitDeclarationReference(expression)

    final override fun visitRawFunctionReference(expression: IrRawFunctionReference, data: Nothing?): IrExpression =
        visitRawFunctionReference(expression)

    open fun visitContainerExpression(expression: IrContainerExpression): IrExpression =
        visitExpression(expression)

    final override fun visitContainerExpression(expression: IrContainerExpression, data: Nothing?): IrExpression =
        visitContainerExpression(expression)

    open fun visitBlock(expression: IrBlock): IrExpression =
        visitContainerExpression(expression)

    final override fun visitBlock(expression: IrBlock, data: Nothing?): IrExpression =
        visitBlock(expression)

    open fun visitComposite(expression: IrComposite): IrExpression =
        visitContainerExpression(expression)

    final override fun visitComposite(expression: IrComposite, data: Nothing?): IrExpression =
        visitComposite(expression)

    open fun visitSyntheticBody(body: IrSyntheticBody): IrBody =
        visitBody(body)

    final override fun visitSyntheticBody(body: IrSyntheticBody, data: Nothing?): IrBody =
        visitSyntheticBody(body)

    open fun visitBreakContinue(jump: IrBreakContinue): IrExpression =
        visitExpression(jump)

    final override fun visitBreakContinue(jump: IrBreakContinue, data: Nothing?): IrExpression =
        visitBreakContinue(jump)

    open fun visitBreak(jump: IrBreak): IrExpression =
        visitBreakContinue(jump)

    final override fun visitBreak(jump: IrBreak, data: Nothing?): IrExpression =
        visitBreak(jump)

    open fun visitContinue(jump: IrContinue): IrExpression =
        visitBreakContinue(jump)

    final override fun visitContinue(jump: IrContinue, data: Nothing?): IrExpression =
        visitContinue(jump)

    open fun visitCall(expression: IrCall): IrExpression =
        visitFunctionAccess(expression)

    final override fun visitCall(expression: IrCall, data: Nothing?): IrExpression =
        visitCall(expression)

    open fun visitCallableReference(expression: IrCallableReference<*>): IrExpression =
        visitMemberAccess(expression)

    final override fun visitCallableReference(expression: IrCallableReference<*>, data: Nothing?): IrExpression =
        visitCallableReference(expression)

    open fun visitFunctionReference(expression: IrFunctionReference): IrExpression =
        visitCallableReference(expression)

    final override fun visitFunctionReference(expression: IrFunctionReference, data: Nothing?): IrElement =
        visitFunctionReference(expression)

    open fun visitPropertyReference(expression: IrPropertyReference): IrExpression =
        visitCallableReference(expression)

    final override fun visitPropertyReference(expression: IrPropertyReference, data: Nothing?): IrElement =
        visitPropertyReference(expression)

    open fun visitLocalDelegatedPropertyReference(expression: IrLocalDelegatedPropertyReference): IrExpression =
        visitCallableReference(expression)

    final override fun visitLocalDelegatedPropertyReference(expression: IrLocalDelegatedPropertyReference, data: Nothing?): IrExpression =
        visitLocalDelegatedPropertyReference(expression)

    open fun visitClassReference(expression: IrClassReference): IrExpression =
        visitDeclarationReference(expression)

    final override fun visitClassReference(expression: IrClassReference, data: Nothing?): IrExpression =
        visitClassReference(expression)

    open fun visitConst(expression: IrConst<*>): IrExpression =
        visitExpression(expression)

    final override fun visitConst(expression: IrConst<*>, data: Nothing?): IrExpression =
        visitConst(expression)

    open fun visitConstantValue(expression: IrConstantValue): IrConstantValue {
        expression.transformChildren(this, null)
        return expression
    }

    final override fun visitConstantValue(expression: IrConstantValue, data: Nothing?): IrConstantValue =
        visitConstantValue(expression)

    open fun visitConstantPrimitive(expression: IrConstantPrimitive): IrConstantValue =
        visitConstantValue(expression)

    final override fun visitConstantPrimitive(expression: IrConstantPrimitive, data: Nothing?): IrConstantValue =
        visitConstantPrimitive(expression)

    open fun visitConstantObject(expression: IrConstantObject): IrConstantValue =
        visitConstantValue(expression)

    final override fun visitConstantObject(expression: IrConstantObject, data: Nothing?): IrConstantValue {
        return visitConstantObject(expression)
    }

    open fun visitConstantArray(expression: IrConstantArray): IrConstantValue =
        visitConstantValue(expression)

    final override fun visitConstantArray(expression: IrConstantArray, data: Nothing?): IrConstantValue =
        visitConstantArray(expression)

    open fun visitDelegatingConstructorCall(expression: IrDelegatingConstructorCall): IrExpression =
        visitFunctionAccess(expression)

    final override fun visitDelegatingConstructorCall(expression: IrDelegatingConstructorCall, data: Nothing?): IrExpression =
        visitDelegatingConstructorCall(expression)

    open fun visitDynamicExpression(expression: IrDynamicExpression): IrExpression =
        visitExpression(expression)

    final override fun visitDynamicExpression(expression: IrDynamicExpression, data: Nothing?): IrExpression =
        visitDynamicExpression(expression)

    open fun visitDynamicOperatorExpression(expression: IrDynamicOperatorExpression): IrExpression =
        visitDynamicExpression(expression)

    final override fun visitDynamicOperatorExpression(expression: IrDynamicOperatorExpression, data: Nothing?): IrExpression =
        visitDynamicOperatorExpression(expression)

    open fun visitDynamicMemberExpression(expression: IrDynamicMemberExpression): IrExpression =
        visitDynamicExpression(expression)

    final override fun visitDynamicMemberExpression(expression: IrDynamicMemberExpression, data: Nothing?): IrExpression =
        visitDynamicMemberExpression(expression)

    open fun visitEnumConstructorCall(expression: IrEnumConstructorCall): IrExpression =
        visitFunctionAccess(expression)

    final override fun visitEnumConstructorCall(expression: IrEnumConstructorCall, data: Nothing?): IrExpression =
        visitEnumConstructorCall(expression)

    open fun visitErrorExpression(expression: IrErrorExpression): IrExpression =
        visitExpression(expression)

    final override fun visitErrorExpression(expression: IrErrorExpression, data: Nothing?): IrExpression =
        visitErrorExpression(expression)

    open fun visitErrorCallExpression(expression: IrErrorCallExpression): IrExpression =
        visitErrorExpression(expression)

    final override fun visitErrorCallExpression(expression: IrErrorCallExpression, data: Nothing?): IrExpression =
        visitErrorCallExpression(expression)

    open fun visitFieldAccess(expression: IrFieldAccessExpression): IrExpression =
        visitDeclarationReference(expression)

    final override fun visitFieldAccess(expression: IrFieldAccessExpression, data: Nothing?): IrExpression =
        visitFieldAccess(expression)

    open fun visitGetField(expression: IrGetField): IrExpression =
        visitFieldAccess(expression)

    final override fun visitGetField(expression: IrGetField, data: Nothing?): IrExpression =
        visitGetField(expression)

    open fun visitSetField(expression: IrSetField): IrExpression =
        visitFieldAccess(expression)

    final override fun visitSetField(expression: IrSetField, data: Nothing?): IrExpression =
        visitSetField(expression)

    open fun visitFunctionExpression(expression: IrFunctionExpression): IrExpression =
        visitExpression(expression)

    final override fun visitFunctionExpression(expression: IrFunctionExpression, data: Nothing?): IrElement =
        visitFunctionExpression(expression)

    open fun visitGetClass(expression: IrGetClass): IrExpression =
        visitExpression(expression)

    final override fun visitGetClass(expression: IrGetClass, data: Nothing?): IrExpression =
        visitGetClass(expression)

    open fun visitInstanceInitializerCall(expression: IrInstanceInitializerCall): IrExpression =
        visitExpression(expression)

    final override fun visitInstanceInitializerCall(expression: IrInstanceInitializerCall, data: Nothing?): IrExpression =
        visitInstanceInitializerCall(expression)

    open fun visitLoop(loop: IrLoop): IrExpression =
        visitExpression(loop)

    final override fun visitLoop(loop: IrLoop, data: Nothing?): IrExpression =
        visitLoop(loop)

    open fun visitWhileLoop(loop: IrWhileLoop): IrExpression =
        visitLoop(loop)

    final override fun visitWhileLoop(loop: IrWhileLoop, data: Nothing?): IrExpression =
        visitWhileLoop(loop)

    open fun visitDoWhileLoop(loop: IrDoWhileLoop): IrExpression =
        visitLoop(loop)

    final override fun visitDoWhileLoop(loop: IrDoWhileLoop, data: Nothing?): IrExpression =
        visitDoWhileLoop(loop)

    open fun visitReturn(expression: IrReturn): IrExpression =
        visitExpression(expression)

    final override fun visitReturn(expression: IrReturn, data: Nothing?): IrExpression =
        visitReturn(expression)

    open fun visitStringConcatenation(expression: IrStringConcatenation): IrExpression =
        visitExpression(expression)

    final override fun visitStringConcatenation(expression: IrStringConcatenation, data: Nothing?): IrExpression =
        visitStringConcatenation(expression)

    open fun visitSuspensionPoint(expression: IrSuspensionPoint): IrExpression =
        visitExpression(expression)

    final override fun visitSuspensionPoint(expression: IrSuspensionPoint, data: Nothing?): IrExpression =
        visitSuspensionPoint(expression)

    open fun visitSuspendableExpression(expression: IrSuspendableExpression): IrExpression =
        visitExpression(expression)

    final override fun visitSuspendableExpression(expression: IrSuspendableExpression, data: Nothing?): IrExpression =
        visitSuspendableExpression(expression)

    open fun visitThrow(expression: IrThrow): IrExpression =
        visitExpression(expression)

    final override fun visitThrow(expression: IrThrow, data: Nothing?): IrExpression =
        visitThrow(expression)

    open fun visitTry(aTry: IrTry): IrExpression =
        visitExpression(aTry)

    final override fun visitTry(aTry: IrTry, data: Nothing?): IrExpression =
        visitTry(aTry)

    open fun visitCatch(aCatch: IrCatch): IrCatch {
        aCatch.transformChildren(this, null)
        return aCatch
    }

    final override fun visitCatch(aCatch: IrCatch, data: Nothing?): IrCatch =
        visitCatch(aCatch)

    open fun visitTypeOperator(expression: IrTypeOperatorCall): IrExpression =
        visitExpression(expression)

    final override fun visitTypeOperator(expression: IrTypeOperatorCall, data: Nothing?): IrExpression =
        visitTypeOperator(expression)

    open fun visitValueAccess(expression: IrValueAccessExpression): IrExpression =
        visitDeclarationReference(expression)

    final override fun visitValueAccess(expression: IrValueAccessExpression, data: Nothing?): IrExpression =
        visitValueAccess(expression)

    open fun visitGetValue(expression: IrGetValue): IrExpression =
        visitValueAccess(expression)

    final override fun visitGetValue(expression: IrGetValue, data: Nothing?): IrExpression =
        visitGetValue(expression)

    open fun visitSetValue(expression: IrSetValue): IrExpression =
        visitValueAccess(expression)

    final override fun visitSetValue(expression: IrSetValue, data: Nothing?): IrExpression =
        visitSetValue(expression)

    open fun visitVararg(expression: IrVararg): IrExpression =
        visitExpression(expression)

    final override fun visitVararg(expression: IrVararg, data: Nothing?): IrExpression =
        visitVararg(expression)

    open fun visitSpreadElement(spread: IrSpreadElement): IrSpreadElement {
        spread.transformChildren(this, null)
        return spread
    }

    final override fun visitSpreadElement(spread: IrSpreadElement, data: Nothing?): IrSpreadElement =
        visitSpreadElement(spread)

    open fun visitWhen(expression: IrWhen): IrExpression =
        visitExpression(expression)

    final override fun visitWhen(expression: IrWhen, data: Nothing?): IrExpression =
        visitWhen(expression)

    open fun visitBranch(branch: IrBranch): IrBranch {
        branch.transformChildren(this, null)
        return branch
    }

    final override fun visitBranch(branch: IrBranch, data: Nothing?): IrBranch =
        visitBranch(branch)

    open fun visitElseBranch(branch: IrElseBranch): IrElseBranch {
        branch.transformChildren(this, null)
        return branch
    }

    final override fun visitElseBranch(branch: IrElseBranch, data: Nothing?): IrElseBranch =
        visitElseBranch(branch)
}

fun IrElement.transformChildrenVoid(transformer: IrElementTransformerVoid) {
    transformChildren(transformer, null)
}