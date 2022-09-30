package solution;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class SolutionTest {

    public class Node {
        int number;
        int linkedNodeNum;
        int requiredCount = 0;
        int realCount = 0;
        boolean isLeaf = false;
        int index = 0;
        List<Integer> edgeList = new ArrayList<>();

        public Node(int number) {
            this.number = number;
        }

        public void nextLinkedNode() {
            if (edgeList.size() == 0) {
                return;
            }
            linkedNodeNum = edgeList.get(index);
            if (index == edgeList.size() - 1) {
                index = 0;
                return;
            }
            index++;
        }
    }

    public boolean validation(Node[] nodeArr) {
        for (int i = 1; i < nodeArr.length; i++) {
            if (nodeArr[i].isLeaf && nodeArr[i].realCount < nodeArr[i].requiredCount) {
                return false;
            }
        }
        return true;
    }

    public boolean throwNumber(Node[] nodeArr, List<Integer> seq, int[] targetArr) {
        Node node = nodeArr[1];
        while (true) {

            Node nextNode = nodeArr[node.linkedNodeNum];
            node.nextLinkedNode();
            if (nextNode.isLeaf) {
                seq.add(nextNode.number);
                nextNode.realCount++;
                if (nextNode.realCount > targetArr[nextNode.number - 1]) {
                    return false;
                }
                if (validation(nodeArr)) {
                    break;
                }

                node = nodeArr[1];
                continue;
            }
            node = nextNode;
        }
        return true;
    }

    public int[] getResult(Node[] nodeArr, List<Integer> seq, int[] targetArr) {
        int[] result = new int[seq.size()];
        for (int i = 0; i < result.length; i++) {
            Integer number = seq.get(i);
            Node node = nodeArr[number];
            int target = targetArr[number - 1];

            if (node.realCount == 1) {
                result[i] = target;
                targetArr[number - 1] -= target;
            } else if (node.realCount > 1) {
                int max = (node.realCount - 1) * 3;
                if (max >= target) {
                    result[i] = 1;
                } else {
                    result[i] = target - max;
                }
                targetArr[number - 1] -= result[i];
            }

            node.realCount -= 1;
        }
        return result;
    }


    private Node[] initNodeArr(int[][] edges, int[] target) {
        Node[] nodeArr = new Node[edges.length + 2];

        for (int i = 1; i < nodeArr.length; i++) {
            nodeArr[i] = new Node(i);
        }

        for (int i = 0; i < edges.length; i++) {
            Node from = nodeArr[edges[i][0]];
            Node to = nodeArr[edges[i][1]];
            from.edgeList.add(to.number);
        }

        for (int i = 1; i < nodeArr.length; i++) {
            Node node = nodeArr[i];
            if (node.edgeList.size() == 0) {
                node.isLeaf = true;
            }
            if (node.isLeaf) {
                node.requiredCount = (int) (Math.ceil(target[i - 1] / 3d));
            }
            Collections.sort(node.edgeList);
            node.nextLinkedNode();
        }

        return nodeArr;
    }

    public int[] solution(int[][] edges, int[] target) {
        Node[] nodeArr = initNodeArr(edges, target);

        List<Integer> seq = new ArrayList<>();
        if (!throwNumber(nodeArr, seq, target)) {
            return new int[]{-1};
        }

        int[] result = getResult(nodeArr, seq, target);
        return result;
    }


    @Test
    public void solutionTest() {
        int[][] edges = {{2, 4}, {1, 2}, {6, 8}, {1, 3}, {5, 7}, {2, 5}, {3, 6}, {6, 10}, {6, 9}};
        int[] target = {0, 0, 0, 3, 0, 0, 5, 1, 2, 3};
        int[] solution = solution(edges, target);

        System.out.println(Arrays.toString(solution));

    }
}