/*******************************************************************************
 * Copyright (c) 2015 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
grammar Query;

@header {
/*******************************************************************************
 * Copyright (c) 2015 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.acceleo.query.parser;
  
}

entry : expression EOF
;

expression : expression navigationSegment #Nav
             | 'not' expression    #Not
		     | '-' expression     #Min
		     | expression MultOp expression   #Mult     
		     | expression addOp expression #Add
		     | expression compOp expression #Comp
		     | expression 'and' expression #And
		     | expression 'or' expression  #Or
		     | varRef       #Var
		     | literal      #Lit
		     | '(' expression ')'    #Paren 
; 

addOp: '+' | '-';
compOp :     '<='
	    	|'>='
	  		|'<>'
	  		|'='
	 		|'<'
	  		|'>'
  ;
varRef : Ident
;
navigationSegment :     '.'Ident #Feature
				      | '.' callExp  #Apply
				      | '->' callExp #CallService
;      
callExp :     'filter(' typeLiteral ')'        #Filter
			| 'oclAsType(' typeLiteral ')'       #AsType
			| 'as(' typeLiteral ')'         #As
			| 'oclIsKindOf(' typeLiteral ')'        #IsKind
			| 'oclIsTypeOf(' typeLiteral ')'        #IsType
			| 'is(' typeLiteral ')'         #Is
			| 'precedingSiblings(' typeLiteral? ')'     #PrecSiblings
			| 'siblings(' typeLiteral? ')'       #Siblings
			| 'eContents('typeLiteral? ')'       #EContent
			| 'eAllContents('typeLiteral? ')'      #EAContent
			| 'eContainer('typeLiteral? ')'       #EContainer
			| 'eInverse('typeLiteral? ')'       #EInverse
			| collectionIterator '(' variableDefinition lambdaExpression ')'  #IterationCall
			| qualifiedName'(' expressionSequence ')'    #ServiceCall
;
lambdaExpression : expression
;
collectionIterator : 'select' | 'reject' | 'collect'
;
expressionSequence : (expression (',' expression)*)?
;
variableDefinition : Ident (':' typeLiteral)? '|'
;
literal :    String         #StringLit
		   | Integer         #IntegerLit
		   | Real         #RealLit
		   |'true'        #TrueLit
		   |'false'        #FalseLit
		   |'null'        #NullLit
		   |'{' expressionSequence '}'   #SetLit
		   |'[' expressionSequence ']'   #SeqLit
		   |'Sequence{' expressionSequence'}'  #ExplicitSeqLit
		   |'OrderedSet{' expressionSequence '}'  #ExplicitSetLit
		   | qualifiedName '::' Ident     #EnumOrClassifierLit
;
typeLiteral :   'String'        #StrType
		      | 'Integer'        #IntType
		      | 'Real'        #RealType
		      | 'Boolean'        #BooleanType
		      | 'Sequence(' typeLiteral')'   #SeqType
		      | 'OrderedSet(' typeLiteral')' #SetType
		      | qualifiedName       #ModelObjectType
      ;
qualifiedName : Ident('::'Ident)? 
     ; 
WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines

MultOp : ['*''/']
;
Integer : [0-9]+
;
Real : [0-9]+'.'[0-9]+
;
String :  '\'' .*? '\''
;
Ident : (Letter | '_') (Letter | [0-9]|'_')*
;
fragment Letter : [a-zA-Z]
;