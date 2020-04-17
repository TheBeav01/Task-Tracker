package com.kazara.tasks.Utils.SearchTree;

import com.kazara.tasks.Utils.ItemStackWrapper;
import com.kazara.tasks.Utils.RecipeUtils;
import com.kazara.tasks.Utils.TasksLogger;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.regex.Pattern;

public class SearchTree {
    private Node root;
    private Set<Edge> edgeSet;
    private int numEntries;
    private Logger LOGGER = LogManager.getLogger();
    public SearchTree() {
        root = new Node();
        edgeSet = new TreeSet<Edge>();

    }
    public void buildTree(Set<ResourceLocation>... set) {
        Node cur;
        char c = '?';
        Edge cachedEdge;
        Pattern pattern = Pattern.compile(":");
        String splitDom[];
        List<IRecipe<?>> recList;
        NonNullList<Ingredient> ig = NonNullList.create();
        HashMap<String, NonNullList<Ingredient>> map;
        for (Set s : set) {
            for (Object fullStr : s) {
                List<IRecipe<?>> TEST;
                map = new HashMap<>();
                numEntries++;
                cur = root;
                splitDom = pattern.split(fullStr.toString(), 2);
                String str = splitDom[1];
                recList = RecipeUtils.getRecipesFromExactItemName(str);
                if(!recList.isEmpty()) {
                    for (IRecipe<?> iRecipe : recList) {
                        ig = iRecipe.getIngredients();
                    }
                }
                for (int l = 0; l < str.length(); l++) {
                    c = str.charAt(l);
                    if (!cur.hasChild(c)) {
                        cachedEdge = cur.addEdge(c, cur);
                        if (l == str.length() - 1) {
                            Node child = cachedEdge.getChild();
                            child.toggleEndOfWord();
                            child.setNames(splitDom[1], splitDom[0]);
                            child.setIngredients(ig);
                        }
                    }
                    else {
                        Edge edge = cur.getEdge(c);
                        if(edge != null) {
                            if( l == str.length() - 1 && !edge.getChild().isEndOfWord()) {
                                LOGGER.debug("Potentially set end of word for " + str);
                                Node n = edge.getChild();
                                n.toggleEndOfWord();
                                n.setNames(splitDom[1], splitDom[0]);
                                n.setIngredients(ig);
                            }
                        }
//                        if(!cur.isEndOfWord() && l == str.length() - 1) {
//                            LOGGER.debug("Potentially set end of word for " + str);
//
//                            cur.toggleEndOfWord();
//                            cur.setNames(splitDom[1], splitDom[0]);
//                            cur.setIngredients(ig);
//                        }
                    }
                    cur = cur.getNextNode(c);
                }


            }
        }
    }

    public Node getRoot() {
        return root;
    }

    public Node searchTreeForNode(String key) {
        String lowerKey = key.toLowerCase();
        TasksLogger.log("Performing search on " + key);
        Node cur = root;
        int numMatches = 0;
        for(int l = 0; l < key.length(); l++) {
            char c = lowerKey.charAt(l);
            if(cur.hasMatchingEdge(c)) {
                numMatches++;
                cur = cur.getNextNode(c);
            }
            else {
                if(numMatches == 0) {
                    TasksLogger.log("No matches found for: " + key);
                    return new Node();
                }
                return cur;
            }
        }

        return cur;
    }


    public ArrayList<String> enumerateKeysAfter(String key) {
        Stack<Node> nodesToTraverse = new Stack<Node>();
        nodesToTraverse.push(searchTreeForNode(key));
        while(!nodesToTraverse.isEmpty()) {
            Node n = nodesToTraverse.pop();
            Set<Edge> edges = n.getEdgeSet();
            if(n.isEndOfWord()) {
                TasksLogger.log(n.getFullName());
            }
            for (Edge edge : edges) {
                nodesToTraverse.push(edge.getChild());
            }
        }
        return null;
    }
    public void printKeyset(String key) {
        enumerateKeysAfter(key);
    }

    public int getNumEntries() {
        return numEntries;
    }
    //Just a test
    public ArrayList<ItemStackWrapper> getComponentItemsFromTree(String name) {
        ArrayList<ItemStackWrapper> ret = new ArrayList<>();
        Node node = searchTreeForNode(name);
        List<Ingredient> ingList = node.getIngredients();
        if(ingList == null || ingList.size() == 0) {
            return new ArrayList<>();
        }
        Stack<List<Ingredient>> toSearch = new Stack<>();
        toSearch.push(ingList);
        while (!toSearch.isEmpty()) {
            ingList = toSearch.pop();
            for (Ingredient ingredient : ingList) {
                ItemStack[] itemStacks = ingredient.getMatchingStacks();
                for (ItemStack itemStack : itemStacks) {
                    ItemStackWrapper it = new ItemStackWrapper(itemStack);
                    int idx = ret.indexOf(it);

                    if(idx >= 0) {
                        it = ret.get(idx);
                        int cnt = it.getCount();
                        it.setCount(++cnt);
                    }
                    else {
                        //Search for a node?
                        if(itemStacks.length > 1) {
                            it.setDict();
                        }
                        Node tmp = searchTreeForNode(it.getRegistryName());
                        if(tmp.isEndOfWord()) {
//                            toSearch.push();
                            System.out.println("Iterate on " + it.getRegistryName());
                        }
                        else {
                            System.out.println("Uh.");
                        }
                        ret.add(it);

                    }

                }
            }
        }
        return null;
    }

}
