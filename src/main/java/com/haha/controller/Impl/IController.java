package com.haha.controller.Impl;
import java.io.Serializable;

/**
 * @author yaoguohong
 */
public interface IController<T extends Serializable, P extends Serializable> extends ICreateController<T>, IDeleteController<T, P>, IUpdateController<T>, IReadController<T, P> {
}
