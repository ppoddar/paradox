// Generated from NoSQL.g4 by ANTLR 4.5

	package antlr4.generated;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link NoSQLParser}.
 */
public interface NoSQLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#selectStatement}.
	 * @param ctx the parse tree
	 */
	void enterSelectStatement(NoSQLParser.SelectStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#selectStatement}.
	 * @param ctx the parse tree
	 */
	void exitSelectStatement(NoSQLParser.SelectStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#selectClause}.
	 * @param ctx the parse tree
	 */
	void enterSelectClause(NoSQLParser.SelectClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#selectClause}.
	 * @param ctx the parse tree
	 */
	void exitSelectClause(NoSQLParser.SelectClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void enterWhereClause(NoSQLParser.WhereClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void exitWhereClause(NoSQLParser.WhereClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#orderByClause}.
	 * @param ctx the parse tree
	 */
	void enterOrderByClause(NoSQLParser.OrderByClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#orderByClause}.
	 * @param ctx the parse tree
	 */
	void exitOrderByClause(NoSQLParser.OrderByClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#groupByClause}.
	 * @param ctx the parse tree
	 */
	void enterGroupByClause(NoSQLParser.GroupByClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#groupByClause}.
	 * @param ctx the parse tree
	 */
	void exitGroupByClause(NoSQLParser.GroupByClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#limitClause}.
	 * @param ctx the parse tree
	 */
	void enterLimitClause(NoSQLParser.LimitClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#limitClause}.
	 * @param ctx the parse tree
	 */
	void exitLimitClause(NoSQLParser.LimitClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#skipClause}.
	 * @param ctx the parse tree
	 */
	void enterSkipClause(NoSQLParser.SkipClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#skipClause}.
	 * @param ctx the parse tree
	 */
	void exitSkipClause(NoSQLParser.SkipClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#projections}.
	 * @param ctx the parse tree
	 */
	void enterProjections(NoSQLParser.ProjectionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#projections}.
	 * @param ctx the parse tree
	 */
	void exitProjections(NoSQLParser.ProjectionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#typeName}.
	 * @param ctx the parse tree
	 */
	void enterTypeName(NoSQLParser.TypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#typeName}.
	 * @param ctx the parse tree
	 */
	void exitTypeName(NoSQLParser.TypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#rootPath}.
	 * @param ctx the parse tree
	 */
	void enterRootPath(NoSQLParser.RootPathContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#rootPath}.
	 * @param ctx the parse tree
	 */
	void exitRootPath(NoSQLParser.RootPathContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#fieldName}.
	 * @param ctx the parse tree
	 */
	void enterFieldName(NoSQLParser.FieldNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#fieldName}.
	 * @param ctx the parse tree
	 */
	void exitFieldName(NoSQLParser.FieldNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#fieldPath}.
	 * @param ctx the parse tree
	 */
	void enterFieldPath(NoSQLParser.FieldPathContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#fieldPath}.
	 * @param ctx the parse tree
	 */
	void exitFieldPath(NoSQLParser.FieldPathContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#aggregateTerm}.
	 * @param ctx the parse tree
	 */
	void enterAggregateTerm(NoSQLParser.AggregateTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#aggregateTerm}.
	 * @param ctx the parse tree
	 */
	void exitAggregateTerm(NoSQLParser.AggregateTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#alias}.
	 * @param ctx the parse tree
	 */
	void enterAlias(NoSQLParser.AliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#alias}.
	 * @param ctx the parse tree
	 */
	void exitAlias(NoSQLParser.AliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterPredicate(NoSQLParser.PredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitPredicate(NoSQLParser.PredicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#predicateTerm}.
	 * @param ctx the parse tree
	 */
	void enterPredicateTerm(NoSQLParser.PredicateTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#predicateTerm}.
	 * @param ctx the parse tree
	 */
	void exitPredicateTerm(NoSQLParser.PredicateTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#unaryPredicate}.
	 * @param ctx the parse tree
	 */
	void enterUnaryPredicate(NoSQLParser.UnaryPredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#unaryPredicate}.
	 * @param ctx the parse tree
	 */
	void exitUnaryPredicate(NoSQLParser.UnaryPredicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#binaryPredicate}.
	 * @param ctx the parse tree
	 */
	void enterBinaryPredicate(NoSQLParser.BinaryPredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#binaryPredicate}.
	 * @param ctx the parse tree
	 */
	void exitBinaryPredicate(NoSQLParser.BinaryPredicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#and}.
	 * @param ctx the parse tree
	 */
	void enterAnd(NoSQLParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#and}.
	 * @param ctx the parse tree
	 */
	void exitAnd(NoSQLParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#or}.
	 * @param ctx the parse tree
	 */
	void enterOr(NoSQLParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#or}.
	 * @param ctx the parse tree
	 */
	void exitOr(NoSQLParser.OrContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#equals}.
	 * @param ctx the parse tree
	 */
	void enterEquals(NoSQLParser.EqualsContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#equals}.
	 * @param ctx the parse tree
	 */
	void exitEquals(NoSQLParser.EqualsContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#notequals}.
	 * @param ctx the parse tree
	 */
	void enterNotequals(NoSQLParser.NotequalsContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#notequals}.
	 * @param ctx the parse tree
	 */
	void exitNotequals(NoSQLParser.NotequalsContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#equalsIgnoreCase}.
	 * @param ctx the parse tree
	 */
	void enterEqualsIgnoreCase(NoSQLParser.EqualsIgnoreCaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#equalsIgnoreCase}.
	 * @param ctx the parse tree
	 */
	void exitEqualsIgnoreCase(NoSQLParser.EqualsIgnoreCaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#greater}.
	 * @param ctx the parse tree
	 */
	void enterGreater(NoSQLParser.GreaterContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#greater}.
	 * @param ctx the parse tree
	 */
	void exitGreater(NoSQLParser.GreaterContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#greaterOrEqual}.
	 * @param ctx the parse tree
	 */
	void enterGreaterOrEqual(NoSQLParser.GreaterOrEqualContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#greaterOrEqual}.
	 * @param ctx the parse tree
	 */
	void exitGreaterOrEqual(NoSQLParser.GreaterOrEqualContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#less}.
	 * @param ctx the parse tree
	 */
	void enterLess(NoSQLParser.LessContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#less}.
	 * @param ctx the parse tree
	 */
	void exitLess(NoSQLParser.LessContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#lessOrEqual}.
	 * @param ctx the parse tree
	 */
	void enterLessOrEqual(NoSQLParser.LessOrEqualContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#lessOrEqual}.
	 * @param ctx the parse tree
	 */
	void exitLessOrEqual(NoSQLParser.LessOrEqualContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#like}.
	 * @param ctx the parse tree
	 */
	void enterLike(NoSQLParser.LikeContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#like}.
	 * @param ctx the parse tree
	 */
	void exitLike(NoSQLParser.LikeContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#not}.
	 * @param ctx the parse tree
	 */
	void enterNot(NoSQLParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#not}.
	 * @param ctx the parse tree
	 */
	void exitNot(NoSQLParser.NotContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#isNull}.
	 * @param ctx the parse tree
	 */
	void enterIsNull(NoSQLParser.IsNullContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#isNull}.
	 * @param ctx the parse tree
	 */
	void exitIsNull(NoSQLParser.IsNullContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#isNotNull}.
	 * @param ctx the parse tree
	 */
	void enterIsNotNull(NoSQLParser.IsNotNullContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#isNotNull}.
	 * @param ctx the parse tree
	 */
	void exitIsNotNull(NoSQLParser.IsNotNullContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#exists}.
	 * @param ctx the parse tree
	 */
	void enterExists(NoSQLParser.ExistsContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#exists}.
	 * @param ctx the parse tree
	 */
	void exitExists(NoSQLParser.ExistsContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#sum}.
	 * @param ctx the parse tree
	 */
	void enterSum(NoSQLParser.SumContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#sum}.
	 * @param ctx the parse tree
	 */
	void exitSum(NoSQLParser.SumContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#min}.
	 * @param ctx the parse tree
	 */
	void enterMin(NoSQLParser.MinContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#min}.
	 * @param ctx the parse tree
	 */
	void exitMin(NoSQLParser.MinContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#max}.
	 * @param ctx the parse tree
	 */
	void enterMax(NoSQLParser.MaxContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#max}.
	 * @param ctx the parse tree
	 */
	void exitMax(NoSQLParser.MaxContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#count}.
	 * @param ctx the parse tree
	 */
	void enterCount(NoSQLParser.CountContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#count}.
	 * @param ctx the parse tree
	 */
	void exitCount(NoSQLParser.CountContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#avg}.
	 * @param ctx the parse tree
	 */
	void enterAvg(NoSQLParser.AvgContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#avg}.
	 * @param ctx the parse tree
	 */
	void exitAvg(NoSQLParser.AvgContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(NoSQLParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(NoSQLParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#stringValue}.
	 * @param ctx the parse tree
	 */
	void enterStringValue(NoSQLParser.StringValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#stringValue}.
	 * @param ctx the parse tree
	 */
	void exitStringValue(NoSQLParser.StringValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#numericValue}.
	 * @param ctx the parse tree
	 */
	void enterNumericValue(NoSQLParser.NumericValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#numericValue}.
	 * @param ctx the parse tree
	 */
	void exitNumericValue(NoSQLParser.NumericValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#integerValue}.
	 * @param ctx the parse tree
	 */
	void enterIntegerValue(NoSQLParser.IntegerValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#integerValue}.
	 * @param ctx the parse tree
	 */
	void exitIntegerValue(NoSQLParser.IntegerValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#decimalValue}.
	 * @param ctx the parse tree
	 */
	void enterDecimalValue(NoSQLParser.DecimalValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#decimalValue}.
	 * @param ctx the parse tree
	 */
	void exitDecimalValue(NoSQLParser.DecimalValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#bindParam}.
	 * @param ctx the parse tree
	 */
	void enterBindParam(NoSQLParser.BindParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#bindParam}.
	 * @param ctx the parse tree
	 */
	void exitBindParam(NoSQLParser.BindParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#paramKey}.
	 * @param ctx the parse tree
	 */
	void enterParamKey(NoSQLParser.ParamKeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#paramKey}.
	 * @param ctx the parse tree
	 */
	void exitParamKey(NoSQLParser.ParamKeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#orderByTerm}.
	 * @param ctx the parse tree
	 */
	void enterOrderByTerm(NoSQLParser.OrderByTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#orderByTerm}.
	 * @param ctx the parse tree
	 */
	void exitOrderByTerm(NoSQLParser.OrderByTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#asc}.
	 * @param ctx the parse tree
	 */
	void enterAsc(NoSQLParser.AscContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#asc}.
	 * @param ctx the parse tree
	 */
	void exitAsc(NoSQLParser.AscContext ctx);
	/**
	 * Enter a parse tree produced by {@link NoSQLParser#desc}.
	 * @param ctx the parse tree
	 */
	void enterDesc(NoSQLParser.DescContext ctx);
	/**
	 * Exit a parse tree produced by {@link NoSQLParser#desc}.
	 * @param ctx the parse tree
	 */
	void exitDesc(NoSQLParser.DescContext ctx);
}