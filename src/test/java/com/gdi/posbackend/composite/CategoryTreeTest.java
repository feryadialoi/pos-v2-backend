package com.gdi.posbackend.composite;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author Feryadialoi
 * @date 8/3/2021 6:42 PM
 */
class CategoryTreeTest {


    class CategoryTree {

        @Override
        public String toString() {
            return "{" +
                    "id:" + id +
                    ", path:" + Arrays.toString(path) +
                    ", name:'" + name + '\'' +
                    ", children:" + children +
                    '}';
        }

        private Integer id;

        private Integer[] path;

        private String name;

        private List<CategoryTree> children = new ArrayList<>();

        public CategoryTree() {
        }

        public CategoryTree(Integer id, Integer[] path, String name) {
            this.id = id;
            this.path = path;
            this.name = name;
        }

        public void add(CategoryTree child) {
            if (child.path.length == 0) {
                children.add(child);
            } else {
                List<CategoryTree> tempList = children;
                CategoryTree temp = null;
                for (int i = 0; i < child.path.length; i++) {
                    int finalI = i;
                    temp = tempList.stream().filter(categoryTree -> categoryTree.id == child.path[finalI]).collect(Collectors.toList()).get(0);

                    if (i < child.path.length) {
                        tempList = temp.children;
                    }
                }
                temp.children.add(child);

            }
        }


    }

    @Test
    void test() {
        CategoryTree categoryTree = new CategoryTree();

        List<CategoryTree> categoryTrees = Arrays.asList(
                new CategoryTree(1, new Integer[]{}, "Pakaian"),
                new CategoryTree(2, new Integer[]{1}, "Baju"),
                new CategoryTree(3, new Integer[]{1}, "Celana"),
                new CategoryTree(4, new Integer[]{1, 2}, "Baju lengan panjang"),
                new CategoryTree(5, new Integer[]{1}, "Topi"),
                new CategoryTree(6, new Integer[]{1, 2}, "Baju lengan pendek"),
                new CategoryTree(7, new Integer[]{}, "Komputer"),
                new CategoryTree(8, new Integer[]{7}, "Desktop"),
                new CategoryTree(9, new Integer[]{7, 8}, "Desktop prebuild"),
                new CategoryTree(10, new Integer[]{7}, "Laptop"),
                new CategoryTree(11, new Integer[]{7, 8}, "Desktop custom build"),
                new CategoryTree(12, new Integer[]{7, 10}, "Ultrabook"),
                new CategoryTree(13, new Integer[]{7, 10}, "Gaming laptop")
        );

        categoryTrees.forEach(categoryTree::add);

        System.out.println(categoryTree.children);

    }
}