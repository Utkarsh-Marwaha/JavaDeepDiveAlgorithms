package _8_Trees.RoseTrees;


public class RoseTree<T> {

    private RoseTreeNode<Integer> root;

    /*constructor*/
    public RoseTree(){
        root = null;
    }

    /**
     * method to check if the tree is empty
     * @return true if the tree is empty
     * false otherwise
     */
    public boolean isEmpty(){
        return root == null;
    }


    /*method to countNodes the number of nodes in a tree*/
    public int countNodes(){
        return countNodes(root);
    }

    /**
     * time complexity  = O(number of nodes)
     * space complexity = O(height of the tree)
     *
     * @param node root of the rose tree
     * @return number of nodes present in the rose tree with
     * the given root
     */
    public int countNodes(RoseTreeNode<Integer> node){

        /*if the tree is empty then there are 0 nodes present in it*/
        if (node == null){
            return 0;
        }

        // This variable will keep countNodes of the number of nodes present in the tree
        int size = 0;

        // cycle through all the children of the current node
        for (int i = 0; i < node.getChildren().size(); i++){

            // recall the countNodes() for each subtree and accumulate the result in the `size` variable
            size += countNodes(node.getChildren().get(i));
        }

        // add one to the size to account for the root node
        return size+1;
    }

    /*method to find the sum of a rose tree*/
    public int sum(){
        return sum(root);
    }

    /**
     * time complexity  = O(number of nodes)
     * space complexity = O(height of the tree)
     *
     * @param node root of the rose tree
     * @return sum of all the nodes present in the rose tree with the given root
     */
    public int sum(RoseTreeNode<Integer> node){

        /*if the tree is empty then its sum is 0*/
        if (node == null){
            return 0;
        }

        // This variable will accumulate the sum of all nodes present in the tree
        int total = 0;

        // cycle through all the children of the current node
        for (int i = 0; i < node.getChildren().size(); i++){

            // recall the sum() for each subtree and accumulate the result in the `total` variable
            total += sum(node.getChildren().get(i));
        }

        // add root's data to the `total` at the end
        return node.getData() + total;
    }

    /*method to find the largest element of a rose tree*/
    public int largest(){
        return largest(root);
    }

    /**
     * time complexity  = O(number of nodes)
     * space complexity = O(height of the tree)
     *
     * @param node root of the rose tree
     * @return node with the largest value present in the rose tree
     */
    public int largest(RoseTreeNode<Integer> node){

        /*if the tree is empty then we simply return 0*/
        if (node == null){
            return 0;
        }

        int max = Integer.MIN_VALUE;

        /*compare root data with data of all children's data*/
        for (int i = 0; i < node.getChildren().size(); i++){

            RoseTreeNode<Integer> child = node.getChildren().get(i);

            if (max < child.getData()){
                max = child.getData();
            }
        }

        /*Every subtree calculates the maximum in its own hierarchy*/
        for (int i = 0; i < node.getChildren().size(); i++){
            int maxOfSubtree = largest(node.getChildren().get(i));

            if (max < maxOfSubtree){
                max = maxOfSubtree;
            }
        }

        /*Check if the root is the largest element of the (sub)tree*/
        if (max < node.getData()){
            max = node.getData();
        }

        // return the maximum value a.k.a largest element
        return max;
    }

    /*method to find the smallest element of a rose tree*/
    public int smallest(){
        return smallest(root);
    }

    /**
     * time complexity  = O(number of nodes)
     * space complexity = O(height of the tree)
     *
     * @param node root of the rose tree
     * @return node with the smallest value present in the rose tree
     */
    public int smallest(RoseTreeNode<Integer> node){

        /*if the tree is empty then we simply return 0*/
        if (node == null){
            return 0;
        }

        int min = Integer.MAX_VALUE;

        /*compare root data with data of all children's data*/
        for (int i = 0; i < node.getChildren().size(); i++){

            RoseTreeNode<Integer> child = node.getChildren().get(i);

            if (min > child.getData()){
                min = child.getData();
            }
        }

        /*Every subtree calculates the minimum in its own hierarchy*/
        for (int i = 0; i < node.getChildren().size(); i++){
            int minOfSubtree = largest(node.getChildren().get(i));

            if (min > minOfSubtree){
                min = minOfSubtree;
            }
        }

        /*Check if the root is the smallest element of the (sub)tree*/
        if (min > node.getData()){
            min = node.getData();
        }

        // return the minimum value a.k.a smallest element
        return min;
    }


    /*method to find the height of a rose tree*/
    public int height(){
        return height(root);
    }

    /**
     * time complexity  = O(number of nodes)
     * space complexity = O(height of the tree)
     *
     * @param node root of the rose tree
     * @return height of the rose tree
     */
    public int height(RoseTreeNode<Integer> node){

        if (node == null){
            return 0;
        }

        int maxHeight = 0;

        for (int i = 0; i < node.getChildren().size(); i++){

            int heightOfSubtree = height(node.getChildren().get(i));

            if (maxHeight > heightOfSubtree){
                maxHeight = heightOfSubtree;
            }
        }

        return maxHeight+1;
    }
}
