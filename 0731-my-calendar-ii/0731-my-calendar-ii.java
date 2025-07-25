class MyCalendarTwo {
    Tree root;

    private static class Tree{
        int beg;
        int end;
        int times;
        Tree left;
        Tree right;

        public Tree(int beg, int end){
            this.beg = beg;
            this.end = end;
            this.times = 1;
        }

        public static boolean query(Tree node, int b, int e){
            if(node == null){
                return true;
            }
            if(node.beg >= e){
                return query(node.left, b, e);
            }
            if(node.end <= b){
                return query(node.right, b, e);
            }
            if(node.times == 2){
                return false;
            }
            int l1 = Math.min(b, node.beg);
            int l2 = Math.max(b, node.beg);
            int r1 = Math.min(e, node.end);
            int r2 = Math.max(e, node.end);
            boolean re1 = true;
            if(l1 != l2){
                re1 = query(node.left, l1, l2);
            }
            boolean re2 = true;
            if(r1 != r2){
                re2 = query(node.right, r1, r2);
            }

            return re1 && re2;

        }

        public static Tree insert(Tree node, int b, int e){
            if(node == null){
                return new Tree(b, e);
            }
            if(node.beg >= e){
                node.left = insert(node.left, b, e);
                return node;
            }
            if(node.end <= b){
                node.right = insert(node.right, b, e);
                return node;
            }
            int l1 = Math.min(b, node.beg);
            int l2 = Math.max(b, node.beg);
            int r1 = Math.min(e, node.end);
            int r2 = Math.max(e, node.end);
            Tree n1 = l1 != l2 ? new Tree(l1, l2) : null;
            Tree n3 = r1 != r2 ? new Tree(r1, r2) : null;
            node.beg = l2;
            node.end = r1;
            if(n1 != null){
                node.left = insert(node.left, l1, l2);
            }
            if(n3 != null){
                node.right = insert(node.right, r1, r2);
            }
            
            node.times++;
            return node;
        }
    }

    public MyCalendarTwo() {
        
    }
    
    public boolean book(int start, int end) {
        if(root == null){
            root = new Tree(start, end);
            return true;
        }
        if(!Tree.query(root, start, end)){
            return false;
        }
        Tree.insert(root, start, end);
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */