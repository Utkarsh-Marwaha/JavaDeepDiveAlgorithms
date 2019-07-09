package _8_Trees.RoseTrees;

import java.util.ArrayList;
import java.util.List;

public class RoseTreeNode<T>{


    private T data;
    private List<RoseTreeNode<T>> children;

    /* default constructor */
    public RoseTreeNode(){
        data = null;
        children = null;
    }

    /* parametrised constructor */
    public RoseTreeNode(T data, List<RoseTreeNode<T>> children) {
        this.data = data;
        this.children = children;
    }

    /**
     * method to set(modify) the data of the current tree node
     * @return data value of the tree node
     */
    public T getData() {
        return data;
    }

    /**
     * method to get(access) the data of the current tree node
     * @param data value of the tree node
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * method to get(access) to the children of a parent node
     * @return list of children nodes of the current node
     */
    public List<RoseTreeNode<T>> getChildren() {
        return children;
    }

    /**
     * method to set(modify) the data of the children of a parent node
     * @param children list of children of the current node
     */
    public void setChildren(ArrayList<RoseTreeNode<T>> children) {
        this.children = children;
    }
}
