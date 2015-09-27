/*
   class Node 
       int data;
       Node left;
       Node right;
*/
void top_view(Node root)
{
    ArrayList<Integer> lefts = new ArrayList<Integer>();
    Node main_root = root;
    while(root!=null) {
        lefts.add(root.data);
        root = root.left;
    }
    Collections.reverse(lefts);
    for (int i = 0; i < lefts.size(); i++)
        System.out.print(lefts.get(i) + " ");
    root = main_root;
    while(root.right != null) {
        System.out.print(root.right.data + " ");
        root = root.right;
    }
        
}
