package com.kazara.tasks.Utils.SearchTree;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Node {
    private Set<Edge> edgeSet;
    private boolean endOfWord = false;
    private String name, domain;
    private ResourceLocation resourceLocation;
    private NonNullList<Ingredient> ingredients;
    private static final Logger LOGGER = LogManager.getLogger();
    private boolean hasDictionaryItems = false;
    public Node() {
        edgeSet = new TreeSet<Edge>();
    }
//    public void addNode(char data) {
//        Set<Edge> tmp = edgeSet;
//        if(edgeSet.size() == 0) {
//            edgeSet.add(new Edge(data,this, new Node()));
//        }
//        else {
//            for (Edge edge : edgeSet) {
//                if (!edge.getData().equals(data)) {
//                    tmp.add(new Edge(data, this, new Node()));
//                    return;
//                }
//            }
//            edgeSet = tmp;
//        }
//
//    }
    public Edge addEdge(char label, Node parent) {
        Edge e = new Edge(label, parent, new Node());
        edgeSet.add(e);
        return e;
    }
    public boolean hasChild(char c) {
        Set<Edge> tmp = edgeSet;
        if(tmp == null) {
            return false;
        }
        for (Edge edge : tmp) {
            if(edge.getData().equals(c)) {
                return true;
            }
        }
        return false;
    }

    public Edge getEdge(char target) {
        for(Edge edge : edgeSet) {
            if(edge.getData().equals(target)) {
                return edge;
            }
        }
        return null;
    }
    public Set<Edge> getEdgeSet() {
        return this.edgeSet;
    }

    public Node getNextNode(char c) {
        return getEdge(c).getChild();
    }
    public boolean hasMatchingEdge(char c) {
        Edge data = getEdge(c);
        return data != null;
    }

    public void toggleEndOfWord() {
        endOfWord = true;
    }

    public boolean isEndOfWord() {
        return endOfWord;
    }

    public void setNames(String name, String domain) {
        this.name = name;
        this.domain = domain;
        this.resourceLocation = new ResourceLocation(domain,name);
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return domain + ":" + name;
    }

    public void setIngredients(NonNullList<Ingredient> ig) {
        this.ingredients = ig;
        setDictionaryFromIngredients();
    }

    public void setDictionaryFromIngredients() {
        ItemStack[] list;
        for (Ingredient ingredient : ingredients) {
            list = ingredient.getMatchingStacks();
            if(list.length > 1) {
                hasDictionaryItems = true;
                break;
            }
        }
    }

}
