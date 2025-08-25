# Introduction
Types are essential elements that are well-defined within the system and helps it to evaluate expression (or at least understand them for AST generation). In DeduKt there are some primitive types but one can extend them. 

Types are generally used to define simple mathematical objects with some inherent properties but they are not used to define structures, syntax, or computational aspects. 

# Using Types
Any object in DeduKt can be assigned a type. This helps DeduKt to consider more context for an object. Any object without a type (which means just an identifier) is considered a `Variable`, which is a primitive type.

```dedukt
x : T // object x has type T
y // object y is a Variable
```

where `x` is the identifier and `T` is the type. In DeduKt language convention we use pascal case for type names, (e.g. `TypeName` and not `typeName` or `type_name`). It is a convention that would be used for DeduKt Standard Library as well.

# Defining Types
DeduKt allows you to define new types in the system, it can help differentiate symbols or to make context which we will investigate later. To define a type you use the `type` keyword followed by a type identifier.

```dedukt
type X
```

This would let DeduKt know about a new type named `X`.  It can now be used in a declaration:

```dedukt
y : X
```

here `y` is of type `X`. Every object in DeduKt has a type property, which can be used like below:

```dedukt
y.type // X would be returned
```


## Extension Types
User defined types can extend on top of other types as well. there are two major ways to do it, first is using the `extends` keyword, second is type contextualization which we'll get to:

```
type X extends String
```

Now type `X` has properties or operators assigned to `String`. This is a simple extension capability given to DeduKt language. Assuming that String has some internal context, one can override them using the definition block, and `override` keyword followed by the desired context parameter of String type:

```dedukt
type X extends String {
	override someInternalStringFunction { ... }
}
```

# Contextualization
Types can have context in them, these are properties and forms. Contextualization allows type to be abstract, and have different properties when used in actualized form. Let's have a look at an example

```dedukt
type X
```

Is an abstract type, we didn't provide any information on capabilities or properties. Because this limits types to just names for safe or readable definitions, we would introduce a definition for this type. In DeduKt definition of an object is given by curly braces:

```dedukt
type X {
	// Definition of X goes here
}
```

a definition can be produced with 

- `property` keyword allows defining new properties like a literal saved in every `X` type with default value: `Model Value`,
- sealed is a property that let's DeduKt know that you cannot extend `X` outside of definition block.
Type context can also be given other types or be generic:

```dedukt
type X<T> {
	...
}
```

`T` can be used to further define context of the type.
Another way to talk about types is the `outer-contextualization` using this you don't talk about type itself but give out what this type can act upon. For example:

```dedukt
fun concat :: String {
	...
}
```

In the code above we defined a new function called `concat` which acts upon `String` types, this gives us context to work with in the body of the function. Later we can use `concat` as:

```dedukt
concat {"Hello"}
concat "Hello"
```
generic types can also vary and be contextual.
