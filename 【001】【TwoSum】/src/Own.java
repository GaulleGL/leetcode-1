public class Own {
    class Node {
        public int val;
        public int ind;

        public Node(int val, int ind) {
            this.val = val;
            this.ind = ind;
        }
    }
    public static void main(String[] args) {
        int[] a = {5, 10};
        int target = 15;
        Own own = new Own();
        own.solution(a, target);
    }

    private int partition(Node[] nodes, int lo, int hi) {
        Node f = nodes[lo];
        int i = lo, j = hi + 1;
        while(true) {
            while (i < hi && nodes[++i].val < f.val) {}
            while (j > lo && nodes[--j].val > f.val) {}
            if(i >= j) {break;}
            Node t = nodes[j];
            nodes[j] = nodes[i];
            nodes[i] = t;
        }
        Node t =  nodes[lo];
        nodes[lo] = nodes[j];
        nodes[j] = t;
        return j;
    }

    private void sort(Node[] nodes, int lo, int hi) {
        if(lo >= hi) {return;}
        int p = partition(nodes, lo, hi);
        sort(nodes, lo, p-1);
        sort(nodes, p+1, hi);
    }

    private void sort(Node[] nodes) {
        if(nodes == null || nodes.length < 2) {
            return;
        }
        sort(nodes, 0, nodes.length-1);
    }

    private Node[] nodesBuilder(int[] a) {
        if(a == null || a.length == 0){
            return new Node[]{};
        }
        Node[] nodes = new Node[a.length];
        for (int i=0; i<a.length; i++) {
            Node node = new Node(a[i], i+1);
            nodes[i] = node;
        }
        return nodes;
    }

    private int[] solution(int[] a, int target) {
        Node[] nodes = nodesBuilder(a);
        int i = 0, j = nodes.length-1;
        while (i < j) {
            int sum = nodes[i].val + nodes[j].val;
            if(sum > target) {
                --j;
                continue;
            }
            if(sum < target) {
                ++i;
                continue;
            }
            System.out.println("[" + nodes[i].ind + "," + nodes[j].ind + "]");
            return new int[]{nodes[i].ind, nodes[j].ind};
        }
        System.out.println("[]");
        return new int[]{};
    }
}
