package com.gdi.posbackend.util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Feryadialoi
 * @date 8/4/2021 5:03 PM
 */
public class CollectionListSetTest {


    @Test
    void test() {
        List<String> roles = new ArrayList<>();
        roles.add("ADMIN");
        roles.add("ADMIN");
        roles.add("USER");

        Set<String> collect = roles.stream().map(s -> s).collect(Collectors.toSet());
        System.out.println(collect);
    }
}
