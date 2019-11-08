package com.wego.web.cmm;
@FunctionalInterface
public interface IFunction<T,R> {
	public R apply(T t);
}
