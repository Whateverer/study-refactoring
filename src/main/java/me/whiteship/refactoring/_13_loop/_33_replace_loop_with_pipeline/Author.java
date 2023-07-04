package me.whiteship.refactoring._13_loop._33_replace_loop_with_pipeline;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Author {

    private String company;

    private String twitterHandle;

    public Author(String company, String twitterHandle) {
        this.company = company;
        this.twitterHandle = twitterHandle;
    }

    static public List<String> TwitterHandles(List<Author> authors, String company) {
        return authors.stream().filter(a -> a.company.equals(company)) // if로 거를 때 사용
                .map(author -> author.twitterHandle) // 변환
                .filter(Objects::nonNull) // if로 거를 때 사용
                .collect(Collectors.toList()); // List로 만들때 사용
    }

}
