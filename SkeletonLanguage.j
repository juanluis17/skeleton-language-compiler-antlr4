; public class SkeletonLanguage extends Object { ...}
.class public SkeletonLanguage
.super java/lang/Object

; COMMENT: --> Atributos
; COMMENT: --> Atributo global1 de tipo I
.field public static global1 I
; COMMENT: --> Atributo global2 de tipo I
.field public static global2 I

; public SkeletonLanguage() { super(); } // calls java.lang.Object()
.method public <init>()V
    .limit stack 1
    .limit locals 1
    aload_0
    invokespecial java/lang/Object/<init>()V
    return
.end method

; main()
.method public static main([Ljava/lang/String;)V
   .limit stack 1
   .limit locals 1
   ; este método tiene solo la llamada al método skeleton por el cual empieza la ejecución del código
   invokestatic SkeletonLanguage/skeleton()V
   return
.end method

; COMMENT: --> Métodos
.method public static metodo1(I)V
    .limit stack 3 ; COMMENT: --> Espacio que necesita la pila
    .limit locals 2 ; COMMENT: --> Cantidad de variable locales
    ; COMMENT: --> Asignación de un resultado a la variable global global1
    iload 0 ; COMMENT: --> Cargando la variable a
    putstatic SkeletonLanguage/global1 I
    ; COMMENT: --> Imprimiendo un valor ENTERO
    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload 0 ; COMMENT: --> Cargando la variable a
    invokevirtual java/io/PrintStream/println(I)V
    ; COMMENT: --> Imprimiendo un valor ENTERO
    getstatic java/lang/System/out Ljava/io/PrintStream;
    getstatic SkeletonLanguage/global1 I
    invokevirtual java/io/PrintStream/println(I)V
    return
.end method
.method public static metodo2(II)I
    .limit stack 3 ; COMMENT: --> Espacio que necesita la pila
    .limit locals 3 ; COMMENT: --> Cantidad de variable locales
    iload 0 ; COMMENT: --> Cargando la variable a
    iload 1 ; COMMENT: --> Cargando la variable b
    iadd
    ; COMMENT: --> Retornando un valor
    ireturn
.end method
.method public static metodo3(IF)V
    .limit stack 3 ; COMMENT: --> Espacio que necesita la pila
    .limit locals 4 ; COMMENT: --> Cantidad de variable locales
    ; COMMENT: --> Asignación de un resultado a c
    iload 0 ; COMMENT: --> Cargando la variable a
    i2f
    fload 1 ; COMMENT: --> Cargando la variable b
    fmul
    fstore 2
    ;Sentencia If para enteros
    iload 0 ; COMMENT: --> Cargando la variable a
    ifeq Label0
    ; COMMENT: --> Imprimiendo un valor REAL
    getstatic java/lang/System/out Ljava/io/PrintStream;
    fload 2 ; COMMENT: --> Cargando la variable c
    invokevirtual java/io/PrintStream/println(F)V
    Label0:

    return
.end method
.method public static skeleton()V
    .limit stack 3 ; COMMENT: --> Espacio que necesita la pila
    .limit locals 2 ; COMMENT: --> Cantidad de variable locales
    ; COMMENT: --> Llamando a la función metodo1
	Label0:
    ldc 5
    invokestatic SkeletonLanguage/metodo1(I)V
    ; COMMENT: --> Asignación de un resultado a k
    ldc 10
    istore 0
    ; COMMENT: --> Llamando a la función metodo1
    iload 0 ; COMMENT: --> Cargando la variable k
    invokestatic SkeletonLanguage/metodo1(I)V
    ; COMMENT: --> Asignación de un resultado a la variable global global2
    ; COMMENT: --> Llamando a la función metodo2
    ldc 2
    ldc 4
    invokestatic SkeletonLanguage/metodo2(II)I
    putstatic SkeletonLanguage/global2 I
    ; COMMENT: --> Llamando a la función metodo3
    ldc 5
    ldc 6.3
    invokestatic SkeletonLanguage/metodo3(IF)V
    ; COMMENT: --> Imprimiendo un valor ENTERO
    getstatic java/lang/System/out Ljava/io/PrintStream;
    getstatic SkeletonLanguage/global2 I
    invokevirtual java/io/PrintStream/println(I)V
    return
.end method