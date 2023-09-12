package parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SkeletonLanguageParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SkeletonLanguageVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code TipoFloat}
	 * labeled alternative in {@link SkeletonLanguageParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipoFloat(@NotNull SkeletonLanguageParser.TipoFloatContext ctx);
	/**
	 * Visit a parse tree produced by {@link SkeletonLanguageParser#methods}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethods(@NotNull SkeletonLanguageParser.MethodsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SkeletonLanguageParser#sentAsig}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentAsig(@NotNull SkeletonLanguageParser.SentAsigContext ctx);
	/**
	 * Visit a parse tree produced by {@link SkeletonLanguageParser#sentSalida}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentSalida(@NotNull SkeletonLanguageParser.SentSalidaContext ctx);
	/**
	 * Visit a parse tree produced by {@link SkeletonLanguageParser#tipoRet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipoRet(@NotNull SkeletonLanguageParser.TipoRetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CteInt}
	 * labeled alternative in {@link SkeletonLanguageParser#cte}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCteInt(@NotNull SkeletonLanguageParser.CteIntContext ctx);
	/**
	 * Visit a parse tree produced by {@link SkeletonLanguageParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(@NotNull SkeletonLanguageParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SkeletonLanguageParser#sentIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentIf(@NotNull SkeletonLanguageParser.SentIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link SkeletonLanguageParser#sentReturn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentReturn(@NotNull SkeletonLanguageParser.SentReturnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpMulDiv}
	 * labeled alternative in {@link SkeletonLanguageParser/#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpMulDiv(@NotNull SkeletonLanguageParser.ExpMulDivContext ctx);
	/**
	 * Visit a parse tree produced by {@link SkeletonLanguageParser#arg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArg(@NotNull SkeletonLanguageParser.ArgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpID}
	 * labeled alternative in {@link SkeletonLanguageParser/#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpID(@NotNull SkeletonLanguageParser.ExpIDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpAddSub}
	 * labeled alternative in {@link SkeletonLanguageParser/#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpAddSub(@NotNull SkeletonLanguageParser.ExpAddSubContext ctx);
	/**
	 * Visit a parse tree produced by {@link SkeletonLanguageParser#sent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSent(@NotNull SkeletonLanguageParser.SentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SkeletonLanguageParser#localDclVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalDclVar(@NotNull SkeletonLanguageParser.LocalDclVarContext ctx);
	/**
	 * Visit a parse tree produced by {@link SkeletonLanguageParser#callMethodSent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallMethodSent(@NotNull SkeletonLanguageParser.CallMethodSentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CteFloat}
	 * labeled alternative in {@link SkeletonLanguageParser#cte}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCteFloat(@NotNull SkeletonLanguageParser.CteFloatContext ctx);
	/**
	 * Visit a parse tree produced by {@link SkeletonLanguageParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(@NotNull SkeletonLanguageParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link SkeletonLanguageParser#callMethod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallMethod(@NotNull SkeletonLanguageParser.CallMethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpCallMethod}
	 * labeled alternative in {@link SkeletonLanguageParser/#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpCallMethod(@NotNull SkeletonLanguageParser.ExpCallMethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TipoInt}
	 * labeled alternative in {@link SkeletonLanguageParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipoInt(@NotNull SkeletonLanguageParser.TipoIntContext ctx);
	/**
	 * Visit a parse tree produced by {@link SkeletonLanguageParser#attributes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributes(@NotNull SkeletonLanguageParser.AttributesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpParent}
	 * labeled alternative in {@link SkeletonLanguageParser/#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpParent(@NotNull SkeletonLanguageParser.ExpParentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpCte}
	 * labeled alternative in {@link SkeletonLanguageParser/#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpCte(@NotNull SkeletonLanguageParser.ExpCteContext ctx);
}