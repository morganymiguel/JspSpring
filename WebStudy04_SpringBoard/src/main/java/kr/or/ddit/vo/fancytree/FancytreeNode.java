package kr.or.ddit.vo.fancytree;

/**
 * https://github.com/mar10/fancytree/wiki
 * https://wwwendt.de/tech/fancytree/doc/jsdoc/FancytreeNode.html
 */
public interface FancytreeNode<T> extends Comparable<FancytreeNode<T>>{
	public String getKey();
	public String getTitle();
	public T getData();
	public boolean isFolder();
	public boolean isLazy();
}
