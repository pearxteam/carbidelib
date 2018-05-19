/*
 * Copyright (c) mrAppleXZ, 2018.
 * This file is a part of the CarbideLib project and has been published under the GNU Lesser General Public License 3. For further details, see the "LICENSE" file in the "CarbideLib" module root directory.
 */

package ru.pearx.carbide.collections.sorted.topological;

import javafx.util.Pair;
import ru.pearx.carbide.Tuple;

import javax.management.relation.RelationSupport;
import java.io.ObjectStreamConstants;
import java.util.*;

/*
 * Created by mrAppleXZ on 13.05.18 16:54.
 */
public final class TopologicalSorting
{
    private TopologicalSorting()
    {
    }

    public static class Node<T>
    {
        private T value;
        private List<Node<T>> children = new ArrayList<>();
        private boolean visited;
        private boolean finished;

        public Node()
        {
        }

        public Node(T value)
        {
            this.value = value;
        }

        public T getValue()
        {
            return value;
        }

        public void setValue(T value)
        {
            this.value = value;
        }

        public List<Node<T>> getChildren()
        {
            return children;
        }

        public boolean isVisited()
        {
            return visited;
        }

        public void setVisited(boolean visited)
        {
            this.visited = visited;
        }

        public boolean isFinished()
        {
            return finished;
        }

        public void setFinished(boolean finished)
        {
            this.finished = finished;
        }

        @Override
        public String toString()
        {
            return "Node{" +
                    "value=" + value +
                    ", children=" + children +
                    '}';
        }
    }

    public static class Builder<T>
    {
        private T root;
        private List<T> objects = new ArrayList<>();
        private Map<T, List<T>> connections = new HashMap<>();

        public Builder<T> setRoot(T root)
        {
            ensureExists(root);
            this.root = root;
            return this;
        }

        public Builder<T> addConnection(T from, T to)
        {
            ensureExists(from);
            ensureExists(to);
            List<T> lst = connections.get(from);
            if (lst != null)
                lst.add(to);
            else
            {
                lst = new ArrayList<>();
                lst.add(to);
                connections.put(from, lst);
            }
            return this;
        }

        private void ensureExists(T obj)
        {
            if(!objects.contains(obj))
                objects.add(obj);
        }

        private Node<T> findNodeFor(List<Node<T>> nodes, T t)
        {
            for (Node<T> node : nodes)
            {
                if (node.getValue().equals(t))
                    return node;
            }
            throw new NodeNotFoundException(t);
        }

        public List<T> build()
        {
            List<Node<T>> nodes = new ArrayList<>();
            for (T object : objects)
            {
                nodes.add(new Node<>(object));
            }
            for (Map.Entry<T, List<T>> connEntrs : connections.entrySet())
            {
                Node<T> nd = findNodeFor(nodes, connEntrs.getKey());
                for (T child : connEntrs.getValue())
                {
                    nd.getChildren().add(findNodeFor(nodes, child));
                }
            }
            Node<T> rootNode = findNodeFor(nodes, root);
            List<T> result = new ArrayList<>();
            visit(rootNode, result);
            Collections.reverse(result);
            return result;
        }

        private void visit(Node<T> node, List<T> result)
        {
            if(node.isFinished())
                return;
            if(node.isVisited())
                throw new CyclicDependencyException(node);
            node.setVisited(true);

            for(ListIterator<Node<T>> it = node.getChildren().listIterator(node.getChildren().size()); it.hasPrevious();)
            {
                visit(it.previous(), result);
            }
            result.add(node.getValue());
            node.setFinished(true);
        }
    }
}
